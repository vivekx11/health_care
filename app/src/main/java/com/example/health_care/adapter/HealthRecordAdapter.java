package com.example.health_care.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.health_care.R;
import com.example.health_care.data.model.HealthRecord;
import java.util.ArrayList;
import java.util.List;

public class HealthRecordAdapter extends RecyclerView.Adapter<HealthRecordAdapter.HealthRecordViewHolder> {
    private List<HealthRecord> healthRecords = new ArrayList<>();

    @NonNull
    @Override
    public HealthRecordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_health_record, parent, false);
        return new HealthRecordViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HealthRecordViewHolder holder, int position) {
        HealthRecord record = healthRecords.get(position);
        holder.textType.setText(record.getType().replace("_", " ").toUpperCase());
        holder.textValue.setText(record.getValue() + " " + record.getUnit());
        holder.textDateTime.setText(record.getDate() + " " + record.getTime());
    }

    @Override
    public int getItemCount() {
        return healthRecords.size();
    }

    public void setHealthRecords(List<HealthRecord> healthRecords) {
        this.healthRecords = healthRecords;
        notifyDataSetChanged();
    }

    static class HealthRecordViewHolder extends RecyclerView.ViewHolder {
        TextView textType, textValue, textDateTime;

        public HealthRecordViewHolder(@NonNull View itemView) {
            super(itemView);
            textType = itemView.findViewById(R.id.text_type);
            textValue = itemView.findViewById(R.id.text_value);
            textDateTime = itemView.findViewById(R.id.text_date_time);
        }
    }
}
