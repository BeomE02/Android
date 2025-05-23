// StatisticsFragment.java - 수정된 통계 화면
package com.example.todomanager.fragment;

import android.os.Bundle;
import android.view.*;
import android.widget.*;
import androidx.fragment.app.Fragment;
import com.example.todomanager.R;
import com.example.todomanager.db.TodoDatabase;
import com.example.todomanager.util.DateUtils;
import java.util.concurrent.Executors;

public class StatisticsFragment extends Fragment {

    private TextView tvTodayStats, tvWeekStats, tvMonthStats;
    private ProgressBar progressToday, progressWeek, progressMonth;
    private TextView tvTodayProgress, tvWeekProgress, tvMonthProgress;

    public StatisticsFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_statistics, container, false);

        initViews(view);
        loadStatistics();

        return view;
    }

    private void initViews(View view) {
        tvTodayStats = view.findViewById(R.id.tvTodayStats);
        tvWeekStats = view.findViewById(R.id.tvWeekStats);
        tvMonthStats = view.findViewById(R.id.tvMonthStats);

        progressToday = view.findViewById(R.id.progressToday);
        progressWeek = view.findViewById(R.id.progressWeek);
        progressMonth = view.findViewById(R.id.progressMonth);

        tvTodayProgress = view.findViewById(R.id.tvTodayProgress);
        tvWeekProgress = view.findViewById(R.id.tvWeekProgress);
        tvMonthProgress = view.findViewById(R.id.tvMonthProgress);
    }

    private void loadStatistics() {
        Executors.newSingleThreadExecutor().execute(() -> {
            try {
                TodoDatabase db = TodoDatabase.getInstance(getContext());

                // 오늘 통계
                long todayStart = DateUtils.getTodayStartTimestamp();
                long todayEnd = DateUtils.getTodayEndTimestamp();

                // DAO 메서드 직접 호출 (범위 쿼리 사용)
                int todayTotal = db.todoDao().getTodosInRange(todayStart, todayEnd).size();
                int todayCompleted = (int) db.todoDao().getTodosInRange(todayStart, todayEnd)
                        .stream().filter(todo -> todo.isDone).count();

                // 이번 주 통계
                long weekStart = DateUtils.getWeekStartTimestamp();
                long weekEnd = DateUtils.getWeekEndTimestamp();

                int weekTotal = db.todoDao().getTodosInRange(weekStart, weekEnd).size();
                int weekCompleted = (int) db.todoDao().getTodosInRange(weekStart, weekEnd)
                        .stream().filter(todo -> todo.isDone).count();

                // 이번 달 통계
                long monthStart = DateUtils.getMonthStartTimestamp();
                long monthEnd = DateUtils.getMonthEndTimestamp();

                int monthTotal = db.todoDao().getTodosInRange(monthStart, monthEnd).size();
                int monthCompleted = (int) db.todoDao().getTodosInRange(monthStart, monthEnd)
                        .stream().filter(todo -> todo.isDone).count();

                // UI 업데이트
                requireActivity().runOnUiThread(() -> {
                    updateStatistics(todayCompleted, todayTotal, weekCompleted, weekTotal, monthCompleted, monthTotal);
                });

            } catch (Exception e) {
                requireActivity().runOnUiThread(() -> {
                    Toast.makeText(getContext(), "통계 로딩 중 오류가 발생했습니다.", Toast.LENGTH_SHORT).show();
                });
            }
        });
    }

    private void updateStatistics(int todayCompleted, int todayTotal,
                                  int weekCompleted, int weekTotal,
                                  int monthCompleted, int monthTotal) {

        // 오늘 통계 업데이트
        updatePeriodStatistics(
                tvTodayStats, progressToday, tvTodayProgress,
                todayCompleted, todayTotal, "오늘"
        );

        // 이번 주 통계 업데이트
        updatePeriodStatistics(
                tvWeekStats, progressWeek, tvWeekProgress,
                weekCompleted, weekTotal, "이번 주"
        );

        // 이번 달 통계 업데이트
        updatePeriodStatistics(
                tvMonthStats, progressMonth, tvMonthProgress,
                monthCompleted, monthTotal, "이번 달"
        );
    }

    /**
     * 개별 기간 통계 업데이트
     */
    private void updatePeriodStatistics(TextView statsText, ProgressBar progressBar,
                                        TextView progressText, int completed, int total, String period) {

        statsText.setText(String.format("완료: %d / 전체: %d", completed, total));

        if (total > 0) {
            int progress = (completed * 100) / total;
            progressBar.setProgress(progress);
            progressText.setText(progress + "%");
        } else {
            progressBar.setProgress(0);
            progressText.setText("0%");
        }
    }

    /**
     * Fragment가 다시 보여질 때 통계 새로고침
     */
    @Override
    public void onResume() {
        super.onResume();
        loadStatistics();
    }
}