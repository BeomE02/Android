package com.example.myapplication.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.myapplication.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;

import java.util.ArrayList;
import java.util.List;

public class ResultFragment extends Fragment {

    private static final String ARG_LEFT = "left_brain_count";
    private static final String ARG_RIGHT = "right_brain_count";

    private int leftBrainCount;
    private int rightBrainCount;

    public ResultFragment() {}

    public static ResultFragment newInstance(int left, int right) {
        ResultFragment fragment = new ResultFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_LEFT, left);
        args.putInt(ARG_RIGHT, right);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_result, container, false);

        if (getArguments() != null) {
            leftBrainCount = getArguments().getInt(ARG_LEFT);
            rightBrainCount = getArguments().getInt(ARG_RIGHT);
        }

        TextView tvResult = view.findViewById(R.id.tv_result_text);
        Button btnRestart = view.findViewById(R.id.btn_restart);
        BarChart barChart = view.findViewById(R.id.bar_chart);

        // 결과 메시지
        String result;
        if (leftBrainCount > rightBrainCount) {
            result = "당신은 논리적 사고를 중시하는 좌뇌형입니다!";
        } else if (rightBrainCount > leftBrainCount) {
            result = "당신은 감각적이고 창의적인 우뇌형입니다!";
        } else {
            result = "당신은 좌우뇌 균형형입니다!";
        }
        result += "\n\n좌뇌 선택: " + leftBrainCount + "개\n우뇌 선택: " + rightBrainCount + "개";
        tvResult.setText(result);

        // 다시 시작 버튼
        btnRestart.setOnClickListener(v -> {
            FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.fragment_container_view, new StartFragment());
            ft.commit();
        });

        // 그래프 데이터 구성
        List<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(0, leftBrainCount));
        entries.add(new BarEntry(1, rightBrainCount));

        BarDataSet dataSet = new BarDataSet(entries, "좌뇌 vs 우뇌");
        // ✅ 기본 색상 사용 (빨간색과 파란색)
        dataSet.setColors(Color.RED, Color.BLUE);
        dataSet.setValueTextSize(14f);

        BarData barData = new BarData(dataSet);
        barChart.setData(barData);

        // X축 라벨 설정
        String[] labels = new String[]{"좌뇌", "우뇌"};
        XAxis xAxis = barChart.getXAxis();
        xAxis.setValueFormatter(new IndexAxisValueFormatter(labels));
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setGranularity(1f);
        xAxis.setDrawGridLines(false);
        xAxis.setTextSize(12f);

        // Y축 설정
        YAxis leftAxis = barChart.getAxisLeft();
        YAxis rightAxis = barChart.getAxisRight();
        leftAxis.setAxisMinimum(0f);
        rightAxis.setAxisMinimum(0f);
        rightAxis.setEnabled(false); // 오른쪽 축 숨기기

        // 그래프 설정
        barChart.getDescription().setEnabled(false);
        barChart.setFitBars(true);
        barChart.invalidate(); // 그래프 다시 그리기

        return view;
    }
}
