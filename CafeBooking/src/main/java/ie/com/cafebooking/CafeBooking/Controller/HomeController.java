package ie.com.cafebooking.CafeBooking.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String viewHomePage() {
        return "index";
    }

    @GetMapping("/sign_in")
    public String viewLoginPage() {
        return "sign_in";
    }

    @GetMapping("/sign_up_form")
    public String viewRegistrationPage() {
        return "sign_up_form";
    }

    @GetMapping("/contact")
    public String showContactPage() {
        return "contact";
    }
}
