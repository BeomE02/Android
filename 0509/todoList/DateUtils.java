package com.example.todomanager.util;

import java.util.Calendar;

public class DateUtils {

    // 오늘 자정 (00:00) 기준의 timestamp 반환
    public static long getTodayStartTimestamp() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTimeInMillis();
    }
}
