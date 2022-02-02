package com.simulation.Parkhaus.dao;

import com.simulation.Parkhaus.model.Parkticket;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 *
 */
@Repository("ParkticketDataDao")
public class ParkticketDataService implements ParkticketDao{

    private static List<Parkticket> DB = new ArrayList<>();

    @Override
    public int insertParkticket(UUID id, Parkticket parkticket) {
        DB.add(new Parkticket(id, parkticket.getZahl()));
        return 1;
    }

    @Override
    public List<Parkticket> selectAllParkticket() {
        return DB;
    }

    @Override
    public Optional<Parkticket> selectParkticketById(UUID id) {
        return DB.stream()
                .filter(parkticket -> parkticket.getId().equals(id))
                .findFirst();
    }

    /**
     * In dieser Methode wird ein Ticket aus der Datenbank entfernt über die id.
     * @param id
     * @return
     */
    @Override
    public int deleteParkticketById(UUID id) {
        Optional<Parkticket> parkticketMaybe = selectParkticketById(id);
        if(parkticketMaybe.isEmpty()){
            return 0;
        }
        DB.remove(parkticketMaybe.get());
        return 1;
    }

    /**
     * In dieser Methode zeigt, wenn der Index von dem Ticket größer = 0 ist, dann
     * haben wir das Ticket gefunden und wird zu einem neuen Hinzugefügt.
     * @param id
     * @param parkticket
     * @return
     */
    @Override
    public int updateParkticketById(UUID id, Parkticket parkticket) {
        return selectParkticketById(id)
                .map(p ->{
                    int indexOfParkticketToDelete = DB.lastIndexOf(parkticket);
                    if (indexOfParkticketToDelete >= 0){
                        DB.set(indexOfParkticketToDelete, parkticket);
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }


}
