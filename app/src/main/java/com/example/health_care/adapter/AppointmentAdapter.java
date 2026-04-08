package com.example.health_care.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.health_care.R;
import com.example.health_care.data.model.Appointment;
import java.util.ArrayList;
import java.util.List;

public class AppointmentAdapter extends RecyclerView.Adapter<AppointmentAdapter.AppointmentViewHolder> {
    private List<Appointment> appointments = new ArrayList<>();

    @NonNull
    @Override
    public AppointmentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_appointment, parent, false);
        return new AppointmentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AppointmentViewHolder holder, int position) {
        Appointment appointment = appointments.get(position);
        holder.textDoctorName.setText(appointment.getDoctorName());
        holder.textSpecialty.setText(appointment.getSpecialty());
        holder.textDateTime.setText(appointment.getDate() + " at " + appointment.getTime());
        holder.textLocation.setText(appointment.getLocation());
    }

    @Override
    public int getItemCount() {
        return appointments.size();
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
        notifyDataSetChanged();
    }

    static class AppointmentViewHolder extends RecyclerView.ViewHolder {
        TextView textDoctorName, textSpecialty, textDateTime, textLocation;

        public AppointmentViewHolder(@NonNull View itemView) {
            super(itemView);
            textDoctorName = itemView.findViewById(R.id.text_doctor_name);
            textSpecialty = itemView.findViewById(R.id.text_specialty);
            textDateTime = itemView.findViewById(R.id.text_date_time);
            textLocation = itemView.findViewById(R.id.text_location);
        }
    }
}
