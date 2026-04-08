package com.example.health_care.data.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "health_records")
public class HealthRecord {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String type; // blood_pressure, glucose, weight, temperature, heart_rate
    private String value;
    private String unit;
    private String date;
    private String time;
    private String notes;

    public HealthRecord() {}

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getValue() { return value; }
    public void setValue(String value) { this.value = value; }

    public String getUnit() { return unit; }
    public void setUnit(String unit) { this.unit = unit; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public String getTime() { return time; }
    public void setTime(String time) { this.time = time; }

    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
}
