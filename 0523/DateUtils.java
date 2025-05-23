// DateUtils.java - 완전한 날짜 유틸리티 클래스
package com.example.todomanager.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateUtils {

    /**
     * 오늘 시작 시간 (00:00:00.000)
     */
    public static long getTodayStartTimestamp() {
        Calendar today = Calendar.getInstance();
        today.set(Calendar.HOUR_OF_DAY, 0);
        today.set(Calendar.MINUTE, 0);
        today.set(Calendar.SECOND, 0);
        today.set(Calendar.MILLISECOND, 0);
        return today.getTimeInMillis();
    }

    /**
     * 오늘 끝 시간 (23:59:59.999)
     */
    public static long getTodayEndTimestamp() {
        Calendar today = Calendar.getInstance();
        today.set(Calendar.HOUR_OF_DAY, 23);
        today.set(Calendar.MINUTE, 59);
        today.set(Calendar.SECOND, 59);
        today.set(Calendar.MILLISECOND, 999);
        return today.getTimeInMillis();
    }

    /**
     * 특정 날짜의 시작 시간 (00:00:00.000)
     */
    public static long getDayStartTimestamp(long timestamp) {
        Calendar day = Calendar.getInstance();
        day.setTimeInMillis(timestamp);
        day.set(Calendar.HOUR_OF_DAY, 0);
        day.set(Calendar.MINUTE, 0);
        day.set(Calendar.SECOND, 0);
        day.set(Calendar.MILLISECOND, 0);
        return day.getTimeInMillis();
    }

    /**
     * 특정 날짜의 끝 시간 (23:59:59.999)
     */
    public static long getDayEndTimestamp(long timestamp) {
        Calendar day = Calendar.getInstance();
        day.setTimeInMillis(timestamp);
        day.set(Calendar.HOUR_OF_DAY, 23);
        day.set(Calendar.MINUTE, 59);
        day.set(Calendar.SECOND, 59);
        day.set(Calendar.MILLISECOND, 999);
        return day.getTimeInMillis();
    }

    /**
     * 이번 주 시작 시간 (일요일 00:00:00.000)
     */
    public static long getWeekStartTimestamp() {
        Calendar weekStart = Calendar.getInstance();
        weekStart.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        weekStart.set(Calendar.HOUR_OF_DAY, 0);
        weekStart.set(Calendar.MINUTE, 0);
        weekStart.set(Calendar.SECOND, 0);
        weekStart.set(Calendar.MILLISECOND, 0);
        return weekStart.getTimeInMillis();
    }

    /**
     * 이번 주 끝 시간 (토요일 23:59:59.999)
     */
    public static long getWeekEndTimestamp() {
        Calendar weekEnd = Calendar.getInstance();
        weekEnd.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
        weekEnd.set(Calendar.HOUR_OF_DAY, 23);
        weekEnd.set(Calendar.MINUTE, 59);
        weekEnd.set(Calendar.SECOND, 59);
        weekEnd.set(Calendar.MILLISECOND, 999);
        return weekEnd.getTimeInMillis();
    }

    /**
     * 이번 달 시작 시간 (1일 00:00:00.000)
     */
    public static long getMonthStartTimestamp() {
        Calendar monthStart = Calendar.getInstance();
        monthStart.set(Calendar.DAY_OF_MONTH, 1);
        monthStart.set(Calendar.HOUR_OF_DAY, 0);
        monthStart.set(Calendar.MINUTE, 0);
        monthStart.set(Calendar.SECOND, 0);
        monthStart.set(Calendar.MILLISECOND, 0);
        return monthStart.getTimeInMillis();
    }

    /**
     * 이번 달 끝 시간 (마지막 날 23:59:59.999)
     */
    public static long getMonthEndTimestamp() {
        Calendar monthEnd = Calendar.getInstance();
        monthEnd.set(Calendar.DAY_OF_MONTH, 1);
        monthEnd.add(Calendar.MONTH, 1);
        monthEnd.add(Calendar.DAY_OF_MONTH, -1);
        monthEnd.set(Calendar.HOUR_OF_DAY, 23);
        monthEnd.set(Calendar.MINUTE, 59);
        monthEnd.set(Calendar.SECOND, 59);
        monthEnd.set(Calendar.MILLISECOND, 999);
        return monthEnd.getTimeInMillis();
    }

    /**
     * 특정 년/월의 시작 시간
     */
    public static long getMonthStartTimestamp(int year, int month) {
        Calendar cal = Calendar.getInstance();
        cal.set(year, month, 1, 0, 0, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTimeInMillis();
    }

    /**
     * 특정 년/월의 끝 시간
     */
    public static long getMonthEndTimestamp(int year, int month) {
        Calendar cal = Calendar.getInstance();
        cal.set(year, month, 1, 0, 0, 0);
        cal.set(Calendar.MILLISECOND, 0);
        cal.add(Calendar.MONTH, 1);
        cal.add(Calendar.MILLISECOND, -1);
        return cal.getTimeInMillis();
    }

    /**
     * 두 날짜가 같은 날인지 확인
     */
    public static boolean isSameDay(long timestamp1, long timestamp2) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTimeInMillis(timestamp1);

        Calendar cal2 = Calendar.getInstance();
        cal2.setTimeInMillis(timestamp2);

        return cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) &&
                cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR);
    }

    /**
     * 오늘 날짜인지 확인
     */
    public static boolean isToday(long timestamp) {
        return isSameDay(timestamp, System.currentTimeMillis());
    }

    /**
     * 이번 주인지 확인
     */
    public static boolean isThisWeek(long timestamp) {
        long weekStart = getWeekStartTimestamp();
        long weekEnd = getWeekEndTimestamp();
        return timestamp >= weekStart && timestamp <= weekEnd;
    }

    /**
     * 이번 달인지 확인
     */
    public static boolean isThisMonth(long timestamp) {
        long monthStart = getMonthStartTimestamp();
        long monthEnd = getMonthEndTimestamp();
        return timestamp >= monthStart && timestamp <= monthEnd;
    }

    /**
     * 날짜 포맷팅
     */
    public static String formatDate(long timestamp, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern, Locale.getDefault());
        return sdf.format(new Date(timestamp));
    }

    /**
     * 한국어 날짜 포맷팅
     */
    public static String formatDateKorean(long timestamp) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 (E)", Locale.KOREAN);
        return sdf.format(new Date(timestamp));
    }

    /**
     * 간단한 날짜 포맷팅 (yyyy-MM-dd)
     */
    public static String formatDateSimple(long timestamp) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        return sdf.format(new Date(timestamp));
    }

    /**
     * 시간 포함 포맷팅 (yyyy-MM-dd HH:mm)
     */
    public static String formatDateTime(long timestamp) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault());
        return sdf.format(new Date(timestamp));
    }

    /**
     * 현재 시간과의 차이 계산 (몇 분 전, 몇 시간 전 등)
     */
    public static String getTimeAgo(long timestamp) {
        long now = System.currentTimeMillis();
        long diff = now - timestamp;

        long minute = 60 * 1000;
        long hour = 60 * minute;
        long day = 24 * hour;
        long week = 7 * day;
        long month = 30 * day;

        if (diff < minute) {
            return "방금 전";
        } else if (diff < hour) {
            return (diff / minute) + "분 전";
        } else if (diff < day) {
            return (diff / hour) + "시간 전";
        } else if (diff < week) {
            return (diff / day) + "일 전";
        } else if (diff < month) {
            return (diff / week) + "주 전";
        } else {
            return formatDateSimple(timestamp);
        }
    }

    /**
     * Calendar 객체를 timestamp로 변환
     */
    public static long calendarToTimestamp(Calendar calendar) {
        return calendar != null ? calendar.getTimeInMillis() : System.currentTimeMillis();
    }

    /**
     * timestamp를 Calendar 객체로 변환
     */
    public static Calendar timestampToCalendar(long timestamp) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timestamp);
        return calendar;
    }
}