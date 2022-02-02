package com.example.demo.api;

import com.example.demo.model.Benutzer;
import com.example.demo.service.BenutzerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/benutzer")
@RestController
public class BenutzerController {

    private final BenutzerService benutzerService;

    @Autowired
    public BenutzerController(BenutzerService benutzerService) {
        this.benutzerService = benutzerService;
    }

    @PostMapping
    public void addBenutzer(@RequestBody Benutzer benutzer) {
        benutzerService.addBenutzer(benutzer);
    }

    @GetMapping()
    public List<Benutzer> getAllBenutzer() {
        return benutzerService.getAllBenutzer();
    }

    @DeleteMapping("/löschen")
    public boolean deleteBenutzer(@RequestParam String username) {
        return benutzerService.deleteBenutzer(username);
    }
}
