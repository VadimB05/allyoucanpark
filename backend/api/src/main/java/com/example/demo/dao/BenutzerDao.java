package com.example.demo.dao;

import java.util.UUID;
import java.util.List;
import com.example.demo.model.Benutzer;

public interface BenutzerDao {

    int insertBenutzer(UUID userid, Benutzer benutzer);

    default int insertBenutzer(Benutzer benutzer) {
        UUID userid = UUID.randomUUID();
        return insertBenutzer(userid, benutzer);
    }

    List<Benutzer> selectAllBenutzer();

    boolean deleteBenutzer(String username);
}
