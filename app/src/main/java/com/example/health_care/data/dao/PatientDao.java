package com.example.health_care.data.dao;

import androidx.lifecycle.LiveData;
import androidx.room.*;
import com.example.health_care.data.model.Patient;
import java.util.List;

@Dao
public interface PatientDao {
    @Insert
    void insert(Patient patient);

    @Update
    void update(Patient patient);

    @Delete
    void delete(Patient patient);

    @Query("SELECT * FROM patients LIMIT 1")
    LiveData<Patient> getPatient();

    @Query("SELECT * FROM patients")
    LiveData<List<Patient>> getAllPatients();
}
