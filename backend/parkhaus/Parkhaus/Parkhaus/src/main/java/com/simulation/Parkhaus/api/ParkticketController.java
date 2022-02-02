package com.simulation.Parkhaus.api;

import com.simulation.Parkhaus.model.Parkticket;
import com.simulation.Parkhaus.service.ParkticketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
/**
 * Vorlesung: Software Engineering (WS 2021/22)
 * Theorieabgabe
 * Aufgabe: allYouCanPark - Parkhaus Backend
 * Thema: MainActivity
 *
 * @author Vadim Balysev
 * @date 01.02.2021
 */

/**
 * Diese Klasse wird vom Frontend angesprochen
 * definiert die Pfade und leitet die Zugriffsanfragen weiter an die Backendlogik
 */
@RequestMapping("api/v1/parkticket")
@RestController
public class ParkticketController {

    private final ParkticketService parkticketService;

    @Autowired
    public ParkticketController(ParkticketService parkticketService) {
        this.parkticketService = parkticketService;
    }

    @PostMapping
    public void addParkticket(@RequestBody Parkticket parkticket){
        parkticketService.addParkticket(parkticket);
    }

    @GetMapping
    public List<Parkticket> getAllParkticket(){
        return parkticketService.getAllParkticket();
    }

    @GetMapping(path = "/id")
    public Parkticket getParkticketById(@PathVariable("id") UUID id) {
        return parkticketService.getParkticketById(id)
                .orElse(null);
    }

    @GetMapping("/anzahl")
    public int getParkticketCount() {
        return parkticketService.getCount();
    }

    @DeleteMapping("/löschen")
    public boolean deleteParkticket(@RequestParam String ticketzahl){
        return parkticketService.deleteParkticket(ticketzahl);
    }
}
