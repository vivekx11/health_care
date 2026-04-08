package com.example.health_care.data.dao;

import androidx.lifecycle.LiveData;
import androidx.room.*;
import com.example.health_care.data.model.HealthRecord;
import java.util.List;

@Dao
public interface HealthRecordDao {
    @Insert
    void insert(HealthRecord healthRecord);

    @Update
    void update(HealthRecord healthRecord);

    @Delete
    void delete(HealthRecord healthRecord);

    @Query("SELECT * FROM health_records ORDER BY date DESC, time DESC")
    LiveData<List<HealthRecord>> getAllHealthRecords();

    @Query("SELECT * FROM health_records WHERE type = :type ORDER BY date DESC, time DESC")
    LiveData<List<HealthRecord>> getHealthRecordsByType(String type);

    @Query("SELECT * FROM health_records WHERE id = :id")
    LiveData<HealthRecord> getHealthRecordById(int id);
}
