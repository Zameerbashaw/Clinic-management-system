package clinic.com.management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.security.core.Authentication;


@Controller
public class LoginController {

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/dashboard")
    public String redirectByRole(Authentication authentication) {
        if (authentication.getAuthorities().toString().contains("DOCTOR")) {
            return "redirect:/doctor/dashboard";
        } else if (authentication.getAuthorities().toString().contains("RECEPTIONIST")) {
            return "redirect:/patients";
        }
        return "redirect:/login";
    }
}