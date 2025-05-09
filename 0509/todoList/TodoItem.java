package com.example.todomanager.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class TodoItem {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public String title;          // 할 일 제목
    public String content;        // 할 일 내용 (선택적)
    public long timestamp;        // 생성된 시간 (ms 단위)

    public boolean isDone;        // 완료 여부
    public long doneTime;         // 완료한 시간 (ms), 0이면 미완료

    // 생성자
    public TodoItem(String title, String content, long timestamp) {
        this.title = title;
        this.content = content;
        this.timestamp = timestamp;
        this.isDone = false;
        this.doneTime = 0;
    }
}
