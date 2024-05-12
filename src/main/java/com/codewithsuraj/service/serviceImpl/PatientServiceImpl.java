package com.codewithsuraj.service.serviceImpl;

import com.codewithsuraj.model.Patient;
import com.codewithsuraj.repository.PatientRepository;
import com.codewithsuraj.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
    private PatientRepository patientRepository;

    @Override
    public List<Patient> getAllPatient() {
        return patientRepository.findAll();
    }

    @Override
    public void getPatientById(long id) {
        patientRepository.findById(id);

    }

    @Override
    public void addPatient(Patient patient) {
        patientRepository.save(patient);
    }

    @Override
    public Patient updatePatient(Patient patient, long id) {

        Boolean isExits = patientRepository.existsById(id);
        if (isExits) {
            Patient patient1 = patientRepository.findById(id).get();

            patient1.setName(patient.getName());
            patient1.setEmail(patient.getEmail());
            patient1.setAddress(patient.getAddress());
            patient1.setDob(patient.getDob());
            patient1.setGender(patient.getGender());
            return patientRepository.save(patient1);

        }
        return null;
    }

    @Override
    public void deletePatient(long id) {
        patientRepository.deleteById(id);
    }
}
