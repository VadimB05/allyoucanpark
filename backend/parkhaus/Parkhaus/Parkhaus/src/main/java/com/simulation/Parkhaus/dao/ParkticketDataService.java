package com.simulation.Parkhaus.dao;

import com.simulation.Parkhaus.model.Parkticket;
import com.simulation.Parkhaus.repository.ParkticketRepository;
import org.springframework.stereotype.Repository;

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
 * @date 01.02.2021
 */


@Repository("ParkticketDataDao")
public class ParkticketDataService implements ParkticketDao {


    private final ParkticketRepository parkticketRepository;

    public ParkticketDataService(ParkticketRepository parkticketRepository) {
        this.parkticketRepository = parkticketRepository;
    }

    @Override
    public int insertParkticket(UUID id, Parkticket parkticket) {
        Parkticket parkticket1 = new Parkticket(UUID.randomUUID(), parkticket.getTicketzahl());
        parkticketRepository.save(parkticket1);
        return 1;
    }

    @Override
    public List<Parkticket> selectAllParkticket() {
        return parkticketRepository.findAll();
    }

    @Override
    public Optional<Parkticket> selectParkticketById(UUID id) {
        return parkticketRepository.findById(id);
    }

    /**
     * In dieser Methode wird ein Ticket aus der Datenbank entfernt über die Ticketzahl.
     * @param ticketzahl
     * @return
     */
    @Override
    public boolean deleteParkticketByZahl(String ticketzahl) {
        Parkticket parkticket = parkticketRepository.findParkticketByTicketzahl(ticketzahl).get();
        parkticketRepository.delete(parkticket);
        return true;
    }


}
