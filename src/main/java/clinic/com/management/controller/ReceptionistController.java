package clinic.com.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import clinic.com.management.model.Patient;
import clinic.com.management.service.PatientService;

@RestController
@RequestMapping("/receptionist")
public class ReceptionistController {

    @Autowired
    private PatientService patientService;

    @PostMapping("/add")
public ResponseEntity<String> addPatient(@RequestBody Patient patient) {
    boolean success = patientService.addPatient(patient);

    if (success) {
        return new ResponseEntity<>("Patient added successfully", HttpStatus.CREATED);
    } else {
        return new ResponseEntity<>("Token number already exists", HttpStatus.CONFLICT);
    }
}


    @GetMapping("/all")
    public List<Patient> getAll() {
        return patientService.getAllPatients();
    }
}