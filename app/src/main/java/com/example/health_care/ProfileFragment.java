package com.example.health_care;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.example.health_care.data.model.Patient;
import com.example.health_care.databinding.FragmentProfileBinding;
import com.example.health_care.viewmodel.HealthCareViewModel;

public class ProfileFragment extends Fragment {
    private FragmentProfileBinding binding;
    private HealthCareViewModel viewModel;
    private Patient currentPatient;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentProfileBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        
        viewModel = new ViewModelProvider(this).get(HealthCareViewModel.class);
        
        observePatient();
        setupSaveButton();
    }

    private void observePatient() {
        viewModel.getPatient().observe(getViewLifecycleOwner(), patient -> {
            if (patient != null) {
                currentPatient = patient;
                populateFields(patient);
            }
        });
    }

    private void populateFields(Patient patient) {
        binding.editName.setText(patient.getName());
        binding.editDateOfBirth.setText(patient.getDateOfBirth());
        binding.editGender.setText(patient.getGender());
        binding.editBloodType.setText(patient.getBloodType());
        binding.editPhone.setText(patient.getPhoneNumber());
        binding.editEmail.setText(patient.getEmail());
        binding.editAddress.setText(patient.getAddress());
        binding.editEmergencyContact.setText(patient.getEmergencyContact());
        binding.editEmergencyPhone.setText(patient.getEmergencyPhone());
    }

    private void setupSaveButton() {
        binding.buttonSave.setOnClickListener(v -> saveProfile());
    }

    private void saveProfile() {
        Patient patient = currentPatient != null ? currentPatient : new Patient();
        
        patient.setName(binding.editName.getText().toString());
        patient.setDateOfBirth(binding.editDateOfBirth.getText().toString());
        patient.setGender(binding.editGender.getText().toString());
        patient.setBloodType(binding.editBloodType.getText().toString());
        patient.setPhoneNumber(binding.editPhone.getText().toString());
        patient.setEmail(binding.editEmail.getText().toString());
        patient.setAddress(binding.editAddress.getText().toString());
        patient.setEmergencyContact(binding.editEmergencyContact.getText().toString());
        patient.setEmergencyPhone(binding.editEmergencyPhone.getText().toString());

        if (currentPatient != null) {
            viewModel.updatePatient(patient);
        } else {
            viewModel.insertPatient(patient);
        }
        
        Toast.makeText(getContext(), "Profile saved", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
