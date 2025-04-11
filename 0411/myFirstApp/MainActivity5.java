package com.example.myfirstapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;

public class MainActivity5 extends AppCompatActivity {

    private EditText editGoal;
    private Button btnAdd, btnBackToMain;
    private ListView listGoals;

    private ArrayList<GoalItem> goalList;
    private GoalAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        editGoal = findViewById(R.id.editGoal);
        btnAdd = findViewById(R.id.btnAdd);
        btnBackToMain = findViewById(R.id.btnBackToMain);
        listGoals = findViewById(R.id.listGoals);

        goalList = loadGoalsFromPrefs();
        adapter = new GoalAdapter(this, goalList);
        listGoals.setAdapter(adapter);

        btnAdd.setOnClickListener(v -> {
            String goalText = editGoal.getText().toString().trim();
            if (!goalText.isEmpty()) {
                goalList.add(new GoalItem(goalText, false));
                adapter.notifyDataSetChanged();
                saveGoalsToPrefs();
                editGoal.setText(""); // 입력창 초기화
            } else {
                Toast.makeText(this, "목표를 입력해주세요!", Toast.LENGTH_SHORT).show();
            }
        });

        btnBackToMain.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity5.this, MainActivity1.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
        });
    }

    // 목표 리스트 JSON 저장
    private void saveGoalsToPrefs() {
        SharedPreferences pref = getSharedPreferences("goal_list", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();

        JSONArray jsonArray = new JSONArray();
        for (GoalItem g : goalList) {
            try {
                JSONObject obj = new JSONObject();
                obj.put("text", g.text);
                obj.put("completed", g.isCompleted);
                jsonArray.put(obj);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        editor.putString("goal_data", jsonArray.toString());
        editor.apply();
    }

    // 목표 리스트 JSON 불러오기
    private ArrayList<GoalItem> loadGoalsFromPrefs() {
        ArrayList<GoalItem> list = new ArrayList<>();
        SharedPreferences pref = getSharedPreferences("goal_list", MODE_PRIVATE);
        String json = pref.getString("goal_data", "");

        if (!json.isEmpty()) {
            try {
                JSONArray array = new JSONArray(json);
                for (int i = 0; i < array.length(); i++) {
                    JSONObject obj = array.getJSONObject(i);
                    String text = obj.getString("text");
                    boolean completed = obj.getBoolean("completed");
                    list.add(new GoalItem(text, completed));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return list;
    }
}
