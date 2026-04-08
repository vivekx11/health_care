package com.example.health_care.data.repository;

import android.app.Application;
import androidx.lifecycle.LiveData;
import com.example.health_care.data.dao.*;
import com.example.health_care.data.database.HealthCareDatabase;
import com.example.health_care.data.model.*;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HealthCareRepository {
    private final PatientDao patientDao;
    private final AppointmentDao appointmentDao;
    private final HealthRecordDao healthRecordDao;
    private final MedicalHistoryDao medicalHistoryDao;
    private final MedicationDao medicationDao;
    private final ExecutorService executorService;

    public HealthCareRepository(Application application) {
        HealthCareDatabase database = HealthCareDatabase.getInstance(application);
        patientDao = database.patientDao();
        appointmentDao = database.appointmentDao();
        healthRecordDao = database.healthRecordDao();
        medicalHistoryDao = database.medicalHistoryDao();
        medicationDao = database.medicationDao();
        executorService = Executors.newFixedThreadPool(2);
    }

    // Patient operations
    public void insertPatient(Patient patient) {
        executorService.execute(() -> patientDao.insert(patient));
    }

    public void updatePatient(Patient patient) {
        executorService.execute(() -> patientDao.update(patient));
    }

    public LiveData<Patient> getPatient() {
        return patientDao.getPatient();
    }

    // Appointment operations
    public void insertAppointment(Appointment appointment) {
        executorService.execute(() -> appointmentDao.insert(appointment));
    }

    public void updateAppointment(Appointment appointment) {
        executorService.execute(() -> appointmentDao.update(appointment));
    }

    public void deleteAppointment(Appointment appointment) {
        executorService.execute(() -> appointmentDao.delete(appointment));
    }

    public LiveData<List<Appointment>> getAllAppointments() {
        return appointmentDao.getAllAppointments();
    }

    public LiveData<List<Appointment>> getAppointmentsByStatus(String status) {
        return appointmentDao.getAppointmentsByStatus(status);
    }

    // Health Record operations
    public void insertHealthRecord(HealthRecord healthRecord) {
        executorService.execute(() -> healthRecordDao.insert(healthRecord));
    }

    public void updateHealthRecord(HealthRecord healthRecord) {
        executorService.execute(() -> healthRecordDao.update(healthRecord));
    }

    public void deleteHealthRecord(HealthRecord healthRecord) {
        executorService.execute(() -> healthRecordDao.delete(healthRecord));
    }

    public LiveData<List<HealthRecord>> getAllHealthRecords() {
        return healthRecordDao.getAllHealthRecords();
    }

    public LiveData<List<HealthRecord>> getHealthRecordsByType(String type) {
        return healthRecordDao.getHealthRecordsByType(type);
    }

    // Medical History operations
    public void insertMedicalHistory(MedicalHistory medicalHistory) {
        executorService.execute(() -> medicalHistoryDao.insert(medicalHistory));
    }

    public void updateMedicalHistory(MedicalHistory medicalHistory) {
        executorService.execute(() -> medicalHistoryDao.update(medicalHistory));
    }

    public void deleteMedicalHistory(MedicalHistory medicalHistory) {
        executorService.execute(() -> medicalHistoryDao.delete(medicalHistory));
    }

    public LiveData<List<MedicalHistory>> getAllMedicalHistory() {
        return medicalHistoryDao.getAllMedicalHistory();
    }

    // Medication operations
    public void insertMedication(Medication medication) {
        executorService.execute(() -> medicationDao.insert(medication));
    }

    public void updateMedication(Medication medication) {
        executorService.execute(() -> medicationDao.update(medication));
    }

    public void deleteMedication(Medication medication) {
        executorService.execute(() -> medicationDao.delete(medication));
    }

    public LiveData<List<Medication>> getAllMedications() {
        return medicationDao.getAllMedications();
    }

    public LiveData<List<Medication>> getMedicationsWithReminders() {
        return medicationDao.getMedicationsWithReminders();
    }
}
