package com.example.myfirstapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;

public class GoalAdapter extends BaseAdapter {

    private final Context context;
    private final ArrayList<GoalItem> goals;
    private final LayoutInflater inflater;

    public GoalAdapter(Context context, ArrayList<GoalItem> goals) {
        this.context = context;
        this.goals = goals;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return goals.size();
    }

    @Override
    public Object getItem(int position) {
        return goals.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    // 핵심: 리스트 아이템을 어떻게 그릴지 정의
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = inflater.inflate(R.layout.goal_item, parent, false);

        TextView txtGoal = view.findViewById(R.id.txtGoal);
        Button btnComplete = view.findViewById(R.id.btnComplete);
        Button btnDelete = view.findViewById(R.id.btnDelete);

        GoalItem item = goals.get(position);
        txtGoal.setText(item.text);
        btnComplete.setText(item.isCompleted ? "✔" : "❌");

        // 완료 버튼 눌렀을 때
        btnComplete.setOnClickListener(v -> {
            item.isCompleted = !item.isCompleted;
            saveGoalsToPrefs();  // 변경된 상태 저장
            notifyDataSetChanged();
        });

        // 삭제 버튼 눌렀을 때
        btnDelete.setOnClickListener(v -> {
            goals.remove(position);
            saveGoalsToPrefs();  // 변경된 상태 저장
            notifyDataSetChanged();
        });

        return view;
    }

    // JSON으로 리스트 저장
    private void saveGoalsToPrefs() {
        SharedPreferences pref = context.getSharedPreferences("goal_list", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();

        JSONArray jsonArray = new JSONArray();
        try {
            for (GoalItem g : goals) {
                JSONObject obj = new JSONObject();
                obj.put("text", g.text);
                obj.put("completed", g.isCompleted);
                jsonArray.put(obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        editor.putString("goal_data", jsonArray.toString());
        editor.apply();
    }
}
