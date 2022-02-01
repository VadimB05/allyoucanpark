package com.simulation.Parkhaus.api;

import com.simulation.Parkhaus.model.Parkticket;
import com.simulation.Parkhaus.service.ParkticketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
