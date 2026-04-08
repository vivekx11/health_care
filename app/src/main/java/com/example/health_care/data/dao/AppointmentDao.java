package com.example.health_care.data.dao;

import androidx.lifecycle.LiveData;
import androidx.room.*;
import com.example.health_care.data.model.Appointment;
import java.util.List;

@Dao
public interface AppointmentDao {
    @Insert
    void insert(Appointment appointment);

    @Update
    void update(Appointment appointment);

    @Delete
    void delete(Appointment appointment);

    @Query("SELECT * FROM appointments ORDER BY date DESC, time DESC")
    LiveData<List<Appointment>> getAllAppointments();

    @Query("SELECT * FROM appointments WHERE status = :status ORDER BY date ASC, time ASC")
    LiveData<List<Appointment>> getAppointmentsByStatus(String status);

    @Query("SELECT * FROM appointments WHERE id = :id")
    LiveData<Appointment> getAppointmentById(int id);
}
