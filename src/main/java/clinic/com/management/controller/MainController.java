package clinic.com.management.controller;
import clinic.com.management.model.Patient;
import clinic.com.management.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

    @Autowired
    private PatientService patientService;

    @GetMapping("/")
    public String showPatientList(Model model) {
        model.addAttribute("patients", patientService.getAllPatients());
        return "list-patients"; // this is your updated dashboard
    }

    @GetMapping("/add-patient")
    public String showAddPatientPage(Model model) {
        model.addAttribute("patient", new Patient());
        return "add-patient";
    }

    @PostMapping("/add-patient")
    public String addPatient(@ModelAttribute Patient patient) {
        patient.setPrescription("Not yet prescribed");
        patientService.addPatient(patient);
        return "redirect:/";
    }

    @GetMapping("/prescribe/{token}")
    public String showPrescribePage(@PathVariable int token, Model model) {
        Patient patient = patientService.getPatientByToken(token).get(0); // assume token is unique
        model.addAttribute("patient", patient);
        return "prescribe";
    }

    @PostMapping("/prescribe/{token}")
    public String prescribe(@PathVariable int token, @RequestParam String prescription) {
        patientService.updatePrescription(token, prescription);
        return "redirect:/";
    }
}
