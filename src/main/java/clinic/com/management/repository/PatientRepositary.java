package clinic.com.management.repository;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;



import clinic.com.management.model.Patient;

public interface PatientRepositary extends MongoRepository<Patient, String> {
  List<Patient> findByTokenNumber(int tokenNumber);
  
}