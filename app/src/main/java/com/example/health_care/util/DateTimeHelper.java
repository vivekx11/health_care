package com.example.health_care.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateTimeHelper {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
    private static final SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm", Locale.getDefault());
    private static final SimpleDateFormat displayDateFormat = new SimpleDateFormat("MMM dd, yyyy", Locale.getDefault());

    public static String getCurrentDate() {
        return dateFormat.format(new Date());
    }

    public static String getCurrentTime() {
        return timeFormat.format(new Date());
    }

    public static String formatDateForDisplay(String date) {
        try {
            Date d = dateFormat.parse(date);
            return d != null ? displayDateFormat.format(d) : date;
        } catch (Exception e) {
            return date;
        }
    }

    public static String formatDate(Date date) {
        return dateFormat.format(date);
    }

    public static String formatTime(int hour, int minute) {
        return String.format(Locale.getDefault(), "%02d:%02d", hour, minute);
    }
}
