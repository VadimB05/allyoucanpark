package com.simulation.Parkhaus.dao;

import com.simulation.Parkhaus.model.Parkticket;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**

 */

@Repository("ParkticketDataDao")
public class ParkticketDataService implements ParkticketDao{

    private static List<Parkticket> DB = new ArrayList<>();

    @Override
    public int insertParkticket(UUID id, Parkticket parkticket) {
        DB.add(new Parkticket(id, parkticket.getZahl()));
        return 1;
    }


}
