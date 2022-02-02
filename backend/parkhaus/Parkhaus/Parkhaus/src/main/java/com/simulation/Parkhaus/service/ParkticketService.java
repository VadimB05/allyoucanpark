package com.simulation.Parkhaus.service;

import com.simulation.Parkhaus.dao.ParkticketDao;
import com.simulation.Parkhaus.model.Parkticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
/**
 * Vorlesung: Software Engineering (WS 2021/22)
 * Theorieabgabe
 * Aufgabe: allYouCanPark - Parkhaus Backend
 * Thema: MainActivity
 *
 * @author Vadim Balysev
 * @date 02.02.2021
 */



@Service
public class ParkticketService {

    private final ParkticketDao parkticketDao;

    @Autowired
    public ParkticketService(@Qualifier("ParkticketDataDao") ParkticketDao parkticketDao) {
        this.parkticketDao = parkticketDao;
    }

    public int addParkticket(Parkticket parkticket){
        return parkticketDao.insertParkticket(parkticket);
    }

    public List<Parkticket> getAllParkticket(){
        return parkticketDao.selectAllParkticket();
    }

    public Optional<Parkticket> getParkticketById(UUID id){
        return parkticketDao.selectParkticketById(id);
    }

    public int getCount() {
        return parkticketDao.selectAllParkticket().size();
    }


    public boolean deleteParkticket(String ticketzahl) {
        return parkticketDao.deleteParkticketByZahl(ticketzahl);
    }
}
