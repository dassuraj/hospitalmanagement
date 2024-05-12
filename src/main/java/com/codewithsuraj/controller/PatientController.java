package com.codewithsuraj.controller;

import com.codewithsuraj.model.Patient;
import com.codewithsuraj.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/patient")
public class PatientController {
    @Autowired
    private PatientService patientService;
    @GetMapping(value = "/get-all-patient")
    public List<Patient> getAllPatient(){
       return patientService.getAllPatient();
    }
    @PostMapping(value = "/save-patient")
    public void savePatient(@RequestBody Patient patient){
         patientService.addPatient(patient);
    }
    @PutMapping(value = "/update-patient-{id}")
    public Patient updatePatient(@RequestBody Patient patient,@PathVariable long id){
        return patientService.updatePatient(patient,id);
    }
    @DeleteMapping(value = "/delete-patient-{id}")
    public void deletePatient(@PathVariable long id){
        patientService.deletePatient(id);

    }


}
