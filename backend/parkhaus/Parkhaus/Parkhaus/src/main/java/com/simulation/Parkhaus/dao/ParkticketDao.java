package com.simulation.Parkhaus.dao;

import com.simulation.Parkhaus.model.Parkticket;

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

/**
 * Mit diesem Interface werden die Daten in die Datenbank eingetragen.
 */
public interface ParkticketDao {

    int insertParkticket(UUID id, Parkticket parkticket);

    default int insertParkticket(Parkticket parkticket){
        UUID id = UUID.randomUUID();
        return  insertParkticket(id, parkticket);
    }

    List<Parkticket> selectAllParkticket();

    Optional<Parkticket> selectParkticketById(UUID id);




    boolean deleteParkticketByZahl(String zahl);
}
