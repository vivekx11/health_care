package com.example.health_care.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.health_care.R;
import com.example.health_care.data.model.Medication;
import java.util.ArrayList;
import java.util.List;

public class MedicationAdapter extends RecyclerView.Adapter<MedicationAdapter.MedicationViewHolder> {
    private List<Medication> medications = new ArrayList<>();

    @NonNull
    @Override
    public MedicationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_medication, parent, false);
        return new MedicationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MedicationViewHolder holder, int position) {
        Medication medication = medications.get(position);
        holder.textName.setText(medication.getName());
        holder.textDosage.setText(medication.getDosage());
        holder.textFrequency.setText(medication.getFrequency());
        holder.textInstructions.setText(medication.getInstructions());
    }

    @Override
    public int getItemCount() {
        return medications.size();
    }

    public void setMedications(List<Medication> medications) {
        this.medications = medications;
        notifyDataSetChanged();
    }

    static class MedicationViewHolder extends RecyclerView.ViewHolder {
        TextView textName, textDosage, textFrequency, textInstructions;

        public MedicationViewHolder(@NonNull View itemView) {
            super(itemView);
            textName = itemView.findViewById(R.id.text_medication_name);
            textDosage = itemView.findViewById(R.id.text_dosage);
            textFrequency = itemView.findViewById(R.id.text_frequency);
            textInstructions = itemView.findViewById(R.id.text_instructions);
        }
    }
}
