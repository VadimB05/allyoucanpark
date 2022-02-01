package com.simulation.Parkhaus.service;

import com.simulation.Parkhaus.dao.ParkticketDao;
import com.simulation.Parkhaus.model.Parkticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


/**
 * Zufalls generierte id für das Parkticket
 */
@Service
public class ParkticketService {

    private final ParkticketDao parkticketDao;

    @Autowired
    public ParkticketService(@Qualifier("ParticketDataDao") ParkticketDao parkticketDao) {
        this.parkticketDao = parkticketDao;
    }

    public int addParkticket(Parkticket parkticket){
        return parkticketDao.insertParkticket(parkticket);
    }
}
