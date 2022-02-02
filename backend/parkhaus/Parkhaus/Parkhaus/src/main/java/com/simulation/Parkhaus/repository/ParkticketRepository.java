package com.simulation.Parkhaus.repository;

import com.simulation.Parkhaus.model.Parkticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

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


@Repository
public interface ParkticketRepository extends JpaRepository<Parkticket, UUID> {
    Optional<Parkticket> findParkticketByTicketzahl(String ticketzahl);
}
