package com.simulation.Parkhaus.dao;

import com.simulation.Parkhaus.model.Parkticket;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 *
 */
public interface ParkticketDao {

    int insertParkticket(UUID id, Parkticket parkticket);

    default int insertParkticket(Parkticket parkticket){
        UUID id = UUID.randomUUID();
        return  insertParkticket(id, parkticket);
    }

    List<Parkticket> selectAllParkticket();

    Optional<Parkticket> selectParkticketById(UUID id);

    int deleteParkticketById(UUID id);
    int updateParkticketById(UUID id, Parkticket parkticket);
}
