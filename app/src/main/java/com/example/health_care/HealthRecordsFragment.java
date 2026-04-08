package com.example.health_care;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.example.health_care.adapter.HealthRecordAdapter;
import com.example.health_care.databinding.FragmentHealthRecordsBinding;
import com.example.health_care.viewmodel.HealthCareViewModel;

public class HealthRecordsFragment extends Fragment {
    private FragmentHealthRecordsBinding binding;
    private HealthCareViewModel viewModel;
    private HealthRecordAdapter adapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHealthRecordsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        
        viewModel = new ViewModelProvider(this).get(HealthCareViewModel.class);
        
        setupRecyclerView();
        observeHealthRecords();
        setupFab();
    }

    private void setupRecyclerView() {
        adapter = new HealthRecordAdapter();
        binding.recyclerViewHealthRecords.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerViewHealthRecords.setAdapter(adapter);
    }

    private void observeHealthRecords() {
        viewModel.getAllHealthRecords().observe(getViewLifecycleOwner(), healthRecords -> {
            adapter.setHealthRecords(healthRecords);
        });
    }

    private void setupFab() {
        binding.fabAddHealthRecord.setOnClickListener(v -> {
            // Navigate to add health record dialog or fragment
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
