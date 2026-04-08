package com.example.health_care.util;

import android.content.Context;
import androidx.work.Data;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import com.example.health_care.data.model.Medication;
import com.example.health_care.worker.MedicationReminderWorker;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class MedicationScheduler {

    public static void scheduleMedicationReminder(Context context, Medication medication) {
        if (!medication.isReminderEnabled() || medication.getReminderTime() == null) {
            return;
        }

        // Parse reminder time (format: "HH:mm")
        String[] timeParts = medication.getReminderTime().split(":");
        int hour = Integer.parseInt(timeParts[0]);
        int minute = Integer.parseInt(timeParts[1]);

        // Calculate delay until reminder time
        Calendar calendar = Calendar.getInstance();
        Calendar reminderCalendar = Calendar.getInstance();
        reminderCalendar.set(Calendar.HOUR_OF_DAY, hour);
        reminderCalendar.set(Calendar.MINUTE, minute);
        reminderCalendar.set(Calendar.SECOND, 0);

        // If time has passed today, schedule for tomorrow
        if (reminderCalendar.before(calendar)) {
            reminderCalendar.add(Calendar.DAY_OF_MONTH, 1);
        }

        long delay = reminderCalendar.getTimeInMillis() - calendar.getTimeInMillis();

        // Create work data
        Data inputData = new Data.Builder()
                .putString("medication_name", medication.getName())
                .putString("dosage", medication.getDosage())
                .build();

        // Schedule work
        OneTimeWorkRequest workRequest = new OneTimeWorkRequest.Builder(MedicationReminderWorker.class)
                .setInitialDelay(delay, TimeUnit.MILLISECONDS)
                .setInputData(inputData)
                .addTag("medication_" + medication.getId())
                .build();

        WorkManager.getInstance(context).enqueue(workRequest);
    }

    public static void cancelMedicationReminder(Context context, int medicationId) {
        WorkManager.getInstance(context).cancelAllWorkByTag("medication_" + medicationId);
    }
}
