// dashboaed java 

package com.example.health_care;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.health_care.databinding.FragmentDashboardBinding;
import com.example.health_care.viewmodel.HealthCareViewModel;

public class DashboardFragment extends Fragment {
    private FragmentDashboardBinding binding;
    private HealthCareViewModel viewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        
        viewModel = new ViewModelProvider(this).get(HealthCareViewModel.class);
        
        setupClickListeners();
        observeData();
    }

    private void setupClickListeners() {
        binding.cardProfile.setOnClickListener(v -> 
            NavHostFragment.findNavController(DashboardFragment.this)
                .navigate(R.id.action_Dashboard_to_Profile));
        
        binding.cardAppointments.setOnClickListener(v -> 
            NavHostFragment.findNavController(DashboardFragment.this)
                .navigate(R.id.action_Dashboard_to_Appointments));
        
        binding.cardHealthRecords.setOnClickListener(v -> 
            NavHostFragment.findNavController(DashboardFragment.this)
                .navigate(R.id.action_Dashboard_to_HealthRecords));
        
        binding.cardMedications.setOnClickListener(v -> 
            NavHostFragment.findNavController(DashboardFragment.this)
                .navigate(R.id.action_Dashboard_to_Medications));
    }

    private void observeData() {
        viewModel.getPatient().observe(getViewLifecycleOwner(), patient -> {
            if (patient != null) {
                binding.textWelcome.setText("Welcome, " + patient.getName());
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
