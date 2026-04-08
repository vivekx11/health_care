package com.example.health_care.viewmodel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.example.health_care.data.model.*;
import com.example.health_care.data.repository.HealthCareRepository;
import java.util.List;

public class HealthCareViewModel extends AndroidViewModel {
    private final HealthCareRepository repository;
    private final LiveData<Patient> patient;
    private final LiveData<List<Appointment>> allAppointments;
    private final LiveData<List<HealthRecord>> allHealthRecords;
    private final LiveData<List<MedicalHistory>> allMedicalHistory;
    private final LiveData<List<Medication>> allMedications;

    public HealthCareViewModel(@NonNull Application application) {
        super(application);
        repository = new HealthCareRepository(application);
        patient = repository.getPatient();
        allAppointments = repository.getAllAppointments();
        allHealthRecords = repository.getAllHealthRecords();
        allMedicalHistory = repository.getAllMedicalHistory();
        allMedications = repository.getAllMedications();
    }

    // Patient
    public void insertPatient(Patient patient) { repository.insertPatient(patient); }
    public void updatePatient(Patient patient) { repository.updatePatient(patient); }
    public LiveData<Patient> getPatient() { return patient; }

    // Appointments
    public void insertAppointment(Appointment appointment) { repository.insertAppointment(appointment); }
    public void updateAppointment(Appointment appointment) { repository.updateAppointment(appointment); }
    public void deleteAppointment(Appointment appointment) { repository.deleteAppointment(appointment); }
    public LiveData<List<Appointment>> getAllAppointments() { return allAppointments; }
    public LiveData<List<Appointment>> getAppointmentsByStatus(String status) {
        return repository.getAppointmentsByStatus(status);
    }

    // Health Records
    public void insertHealthRecord(HealthRecord healthRecord) { repository.insertHealthRecord(healthRecord); }
    public void updateHealthRecord(HealthRecord healthRecord) { repository.updateHealthRecord(healthRecord); }
    public void deleteHealthRecord(HealthRecord healthRecord) { repository.deleteHealthRecord(healthRecord); }
    public LiveData<List<HealthRecord>> getAllHealthRecords() { return allHealthRecords; }
    public LiveData<List<HealthRecord>> getHealthRecordsByType(String type) {
        return repository.getHealthRecordsByType(type);
    }

    // Medical History
    public void insertMedicalHistory(MedicalHistory medicalHistory) { repository.insertMedicalHistory(medicalHistory); }
    public void updateMedicalHistory(MedicalHistory medicalHistory) { repository.updateMedicalHistory(medicalHistory); }
    public void deleteMedicalHistory(MedicalHistory medicalHistory) { repository.deleteMedicalHistory(medicalHistory); }
    public LiveData<List<MedicalHistory>> getAllMedicalHistory() { return allMedicalHistory; }

    // Medications
    public void insertMedication(Medication medication) { repository.insertMedication(medication); }
    public void updateMedication(Medication medication) { repository.updateMedication(medication); }
    public void deleteMedication(Medication medication) { repository.deleteMedication(medication); }
    public LiveData<List<Medication>> getAllMedications() { return allMedications; }
    public LiveData<List<Medication>> getMedicationsWithReminders() {
        return repository.getMedicationsWithReminders();
    }
}
