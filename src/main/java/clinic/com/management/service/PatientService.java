package clinic.com.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import clinic.com.management.model.Patient;
import clinic.com.management.repository.PatientRepositary;

@Service
public class PatientService {

    @Autowired
    private PatientRepositary repo;

    // ✅ Only save if token is not already used
    public boolean addPatient(Patient patient) {
        if (repo.findByTokenNumber(patient.getTokenNumber()).isEmpty()) {
            repo.save(patient);
            return true; // success
        }
        return false; // duplicate token
    }

    // ✅ Now returns list instead of single patient
    public List<Patient> getPatientByToken(int tokenNumber) {
        return repo.findByTokenNumber(tokenNumber);
    }

    public List<Patient> getAllPatients() {
        return repo.findAll();
    }

    // ✅ Update only the first matching patient (if any)
    public Patient updatePrescription(int tokenNumber, String prescription) {
        List<Patient> patients = repo.findByTokenNumber(tokenNumber);
        if (!patients.isEmpty()) {
            Patient p = patients.get(0); // pick first match
            p.setPrescription(prescription);
            return repo.save(p);
        }
        return null;
    }
}
