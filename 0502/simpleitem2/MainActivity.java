package com.example.simpleitem2;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listView);

        // 데이터 준비: Map 으로 각 아이템의 title, subtitle 설정
        List<Map<String, String>> data = new ArrayList<>();
        addItem(data, "이순신", "조선의 명장");
        addItem(data, "홍길동", "의적이자 영웅");
        addItem(data, "김유신", "신라의 대장군");

        // SimpleAdapter 생성: simple_list_item_2에 텍스트1(text1), 텍스트2(text2)를 연결
        SimpleAdapter adapter = new SimpleAdapter(
                this,
                data,
                android.R.layout.simple_list_item_2,
                new String[] { "title", "subtitle" },
                new int[] { android.R.id.text1, android.R.id.text2 }
        );

        listView.setAdapter(adapter);
    }

    // helper: 데이터 리스트에 Map 추가
    private void addItem(List<Map<String, String>> list, String title, String subtitle) {
        Map<String, String> item = new HashMap<>();
        item.put("title", title);
        item.put("subtitle", subtitle);
        list.add(item);
    }
}
