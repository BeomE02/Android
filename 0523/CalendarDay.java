// CalendarDay.java - 캘린더 날짜 데이터 모델
package com.example.todomanager.model;

import java.util.Calendar;

public class CalendarDay {
    public Calendar date;           // 날짜 정보
    public int dayNumber;          // 날짜 숫자 (1-31)
    public boolean isCurrentMonth; // 현재 월 여부
    public boolean isToday;        // 오늘 날짜 여부
    public int todoCount;          // 할 일 총 개수
    public int completedCount;     // 완료된 할 일 개수

    // 기본 생성자
    public CalendarDay() {
        this.date = Calendar.getInstance();
        this.dayNumber = 1;
        this.isCurrentMonth = true;
        this.isToday = false;
        this.todoCount = 0;
        this.completedCount = 0;
    }

    // 전체 생성자
    public CalendarDay(Calendar date, int dayNumber, boolean isCurrentMonth,
                       boolean isToday, int todoCount, int completedCount) {
        this.date = date;
        this.dayNumber = dayNumber;
        this.isCurrentMonth = isCurrentMonth;
        this.isToday = isToday;
        this.todoCount = todoCount;
        this.completedCount = completedCount;
    }

    // 완료율 계산
    public float getCompletionRate() {
        if (todoCount == 0) return 0f;
        return (float) completedCount / todoCount * 100f;
    }

    // 모든 할 일이 완료되었는지 확인
    public boolean isAllCompleted() {
        return todoCount > 0 && completedCount == todoCount;
    }

    // 일부 할 일이 완료되었는지 확인
    public boolean hasPartialCompletion() {
        return completedCount > 0 && completedCount < todoCount;
    }

    // 할 일이 있는지 확인
    public boolean hasTodos() {
        return todoCount > 0;
    }
}