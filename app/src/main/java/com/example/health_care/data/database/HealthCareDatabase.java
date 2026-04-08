package com.example.health_care.data.database;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.example.health_care.data.dao.*;
import com.example.health_care.data.model.*;

@Database(entities = {
        Patient.class,
        Appointment.class,
        HealthRecord.class,
        MedicalHistory.class,
        Medication.class
}, version = 1, exportSchema = false)
public abstract class HealthCareDatabase extends RoomDatabase {

    private static HealthCareDatabase instance;

    public abstract PatientDao patientDao();
    public abstract AppointmentDao appointmentDao();
    public abstract HealthRecordDao healthRecordDao();
    public abstract MedicalHistoryDao medicalHistoryDao();
    public abstract MedicationDao medicationDao();

    public static synchronized HealthCareDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                            HealthCareDatabase.class, "health_care_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
