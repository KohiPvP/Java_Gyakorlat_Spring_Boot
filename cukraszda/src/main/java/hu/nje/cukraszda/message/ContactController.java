package hu.nje.cukraszda.message;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/kapcsolat")
public class ContactController {

    private final ContactMessageRepository contactMessageRepository;

    public ContactController(ContactMessageRepository contactMessageRepository) {
        this.contactMessageRepository = contactMessageRepository;
    }

    // űrlap megjelenítése
    @GetMapping
    public String showForm(Model model) {
        if (!model.containsAttribute("contactForm")) {
            model.addAttribute("contactForm", new ContactForm());
        }
        return "kapcsolat"; // templates/kapcsolat.html
    }

    // űrlap feldolgozása
    @PostMapping
    public String submitForm(
            @Valid @ModelAttribute("contactForm") ContactForm contactForm,
            BindingResult bindingResult,
            Model model
    ) {
        // szerver oldali validáció
        if (bindingResult.hasErrors()) {
            return "kapcsolat";
        }

        // entitás feltöltése
        ContactMessage message = new ContactMessage();
        message.setNev(contactForm.getNev());
        message.setEmail(contactForm.getEmail());
        message.setTargy(contactForm.getTargy());
        message.setUzenet(contactForm.getUzenet());
        message.setLetrehozva(LocalDateTime.now());

        // mentés adatbázisba
        contactMessageRepository.save(message);

        // sikerüzenet + új üres form
        model.addAttribute("successMessage", "Üzenetét sikeresen elküldte!");
        model.addAttribute("contactForm", new ContactForm());

        return "kapcsolat";
    }
}