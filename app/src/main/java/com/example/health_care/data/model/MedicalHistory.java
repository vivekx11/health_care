package com.example.health_care.data.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "medical_history")
public class MedicalHistory {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String condition;
    private String diagnosisDate;
    private String status; // active, resolved
    private String notes;

    public MedicalHistory() {}

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getCondition() { return condition; }
    public void setCondition(String condition) { this.condition = condition; }

    public String getDiagnosisDate() { return diagnosisDate; }
    public void setDiagnosisDate(String diagnosisDate) { this.diagnosisDate = diagnosisDate; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
}
