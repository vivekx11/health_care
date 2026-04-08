package com.example.health_care.data.dao;

import androidx.lifecycle.LiveData;
import androidx.room.*;
import com.example.health_care.data.model.MedicalHistory;
import java.util.List;

@Dao
public interface MedicalHistoryDao {
    @Insert
    void insert(MedicalHistory medicalHistory);

    @Update
    void update(MedicalHistory medicalHistory);

    @Delete
    void delete(MedicalHistory medicalHistory);

    @Query("SELECT * FROM medical_history ORDER BY diagnosisDate DESC")
    LiveData<List<MedicalHistory>> getAllMedicalHistory();

    @Query("SELECT * FROM medical_history WHERE status = :status")
    LiveData<List<MedicalHistory>> getMedicalHistoryByStatus(String status);
}
