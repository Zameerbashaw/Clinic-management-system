package clinic.com.management.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import clinic.com.management.model.Patient;
import clinic.com.management.service.PatientService;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private PatientService patientService;

    @GetMapping("/get/{token}")
    public List <Patient> getPatient(@PathVariable int token) {
        return patientService.getPatientByToken(token);
    }

    @PutMapping("/prescribe/{token}")
    public Patient prescribe(@PathVariable int token, @RequestBody String prescription) {
        return patientService.updatePrescription(token, prescription);
    }
}
