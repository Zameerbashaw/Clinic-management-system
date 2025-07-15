package clinic.com.management.model;

import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "patients")
public class Patient {
    @Id
    private String id;
    private String name;
    private int tokenNumber;
    private String symptoms;
    private String prescription;
    private List<String> history;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getTokenNumber() {
        return tokenNumber;
    }
    public void setTokenNumber(int tokenNumber) {
        this.tokenNumber = tokenNumber;
    }
    public String getSymptoms() {
        return symptoms;
    }
    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }
    public String getPrescription() {
        return prescription;
    }
    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }
    public List<String> getHistory() {
        return history;
    }
    public void setHistory(List<String> history) {
        this.history = history;
    }

    // Getters and setters
}
    

