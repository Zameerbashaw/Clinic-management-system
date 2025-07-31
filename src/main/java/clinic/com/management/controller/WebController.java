// package clinic.com.management.controller;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.*;

// import clinic.com.management.model.Patient;
// import clinic.com.management.service.PatientService;
// import org.springframework.stereotype.Controller;

// import java.util.List;

// @Controller
// public class WebController {

//     @Autowired
//     private PatientService patientService;

//     // // Show add form
//     // @GetMapping("/add-patient")
//     // public String showAddForm(Model model) {
//     //     model.addAttribute("patient", new Patient());
//     //     return "add-patient";
//     // }

//     // Save patient from form
//     @PostMapping("/submit-patient")
//     public String submitPatient(@ModelAttribute Patient patient) {
//         patientService.addPatient(patient);
//         return "redirect:/patients";
//     }

//     // Show all patients
//     @GetMapping("/patients")
//     public String viewAll(Model model) {
//         List<Patient> patients = patientService.getAllPatients();
//         model.addAttribute("patients", patients);
//         return "list-patients";
//     }

//     // Show prescribe form
//     @GetMapping("/prescribe/{token}")
// public String showPrescribeForm(@PathVariable int token, Model model) {
//     List<Patient> patients = patientService.getPatientByToken(token);

//     if (!patients.isEmpty()) {
//         model.addAttribute("patient", patients.get(0)); // ✅ get the first match
//     } else {
//         model.addAttribute("error", "Patient not found with token: " + token);
//         return "error"; // or return to list-patients with error
//     }

//     return "prescribe";
// }


//     // Submit prescription
//     @PostMapping("/submit-prescription/{token}")
//     public String submitPrescription(@PathVariable int token, @RequestParam String prescription) {
//         patientService.updatePrescription(token, prescription);
//         return "redirect:/patients";
//     }
// }