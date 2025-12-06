package hu.nje.cukraszda.controller;

import hu.nje.cukraszda.database.Suti;
import hu.nje.cukraszda.database.SutiRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CrudController {
    @Autowired private SutiRepo sutiRepo;

    // Az admin oldalról lehet elérni
    @GetMapping("/admin/crud")
    public String crud(Model model) {
        model.addAttribute("sutik", sutiRepo.findAll());
        model.addAttribute("new_suti", new Suti());
        return "crud";
    }

    @PostMapping(value = "/admin/crud/save")
    public String saveSuti(@ModelAttribute("new_suti") Suti suti) {
        sutiRepo.save(suti);
        return "redirect:/admin/crud";
    }

    @GetMapping("/admin/crud/edit/{id}")
    public String editSuti(@PathVariable(name = "id") int id, Model model) {
        model.addAttribute("suti", sutiRepo.findById(id));
        return "crud_edit";
    }

    @PostMapping(value = "/admin/crud/edit")
    public String modositDolgozo(@ModelAttribute Suti suti) {
        sutiRepo.save(suti);
        return "redirect:/admin/crud";
    }

    @GetMapping("/admin/crud/delete/{id}")
    public String deleteSuti(@PathVariable(name = "id") int id) {
        sutiRepo.deleteById(id);
        return "redirect:/admin/crud";
    }
}
