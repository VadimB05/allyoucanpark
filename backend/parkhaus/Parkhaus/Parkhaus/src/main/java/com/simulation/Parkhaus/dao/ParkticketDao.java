package com.simulation.Parkhaus.dao;

import com.simulation.Parkhaus.model.Parkticket;

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
}
