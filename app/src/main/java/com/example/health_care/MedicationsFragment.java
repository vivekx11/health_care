// fragment java 

package com.example.health_care;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.example.health_care.adapter.MedicationAdapter;
import com.example.health_care.databinding.FragmentMedicationsBinding;
import com.example.health_care.viewmodel.HealthCareViewModel;

public class MedicationsFragment extends Fragment {
    private FragmentMedicationsBinding binding;
    private HealthCareViewModel viewModel;
    private MedicationAdapter adapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentMedicationsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        
        viewModel = new ViewModelProvider(this).get(HealthCareViewModel.class);
        
        setupRecyclerView();
        observeMedications();
        setupFab();
    }

    private void setupRecyclerView() {
        adapter = new MedicationAdapter();
        binding.recyclerViewMedications.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerViewMedications.setAdapter(adapter);
    }

    private void observeMedications() {
        viewModel.getAllMedications().observe(getViewLifecycleOwner(), medications -> {
            adapter.setMedications(medications);
        });
    }

    private void setupFab() {
        binding.fabAddMedication.setOnClickListener(v -> {
            // Navigate to add medication dialog or fragment
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
