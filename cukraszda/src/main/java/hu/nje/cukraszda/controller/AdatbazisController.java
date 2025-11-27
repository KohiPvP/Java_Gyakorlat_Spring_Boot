package hu.nje.cukraszda.controller;

import hu.nje.cukraszda.database.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AdatbazisController {
    private final ArRepo arRepository;
    private final SutiRepo sutiRepository;
    private final TartalomRepo tartalomRepository;

    public AdatbazisController(ArRepo arRepository, SutiRepo sutiRepository, TartalomRepo tartalomRepository) {
        this.arRepository = arRepository;
        this.sutiRepository = sutiRepository;
        this.tartalomRepository = tartalomRepository;
    }

    @GetMapping("/adatbazis")
    public String showAdatbazis(Model model) {
        List<Ar> arak = new ArrayList<>();
        arRepository.findAll().forEach(arak::add);
        List<Suti> sutik = new ArrayList<>();
        sutiRepository.findAll().forEach(sutik::add);
        List<Tartalom> tartalmak = new ArrayList<>();
        tartalomRepository.findAll().forEach(tartalmak::add);

        model.addAttribute("arak", arak);
        model.addAttribute("sutik", sutik);
        model.addAttribute("tartalmak", tartalmak);

        return "adatbazis";
    }
}
