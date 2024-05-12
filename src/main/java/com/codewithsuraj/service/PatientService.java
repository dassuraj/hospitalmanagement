package com.codewithsuraj.service;

import com.codewithsuraj.model.Patient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PatientService {
    List<Patient> getAllPatient();
    void  getPatientById(long id);
    void addPatient(Patient patient);
    Patient updatePatient(Patient patient,long id);
    void deletePatient(long id);

}
