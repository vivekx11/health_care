package com.example.health_care.data.dao;

import androidx.lifecycle.LiveData;
import androidx.room.*;
import com.example.health_care.data.model.Medication;
import java.util.List;

@Dao
public interface MedicationDao {
    @Insert
    void insert(Medication medication);

    @Update
    void update(Medication medication);

    @Delete
    void delete(Medication medication);

    @Query("SELECT * FROM medications ORDER BY startDate DESC")
    LiveData<List<Medication>> getAllMedications();

    @Query("SELECT * FROM medications WHERE reminderEnabled = 1")
    LiveData<List<Medication>> getMedicationsWithReminders();

    @Query("SELECT * FROM medications WHERE id = :id")
    LiveData<Medication> getMedicationById(int id);
}
