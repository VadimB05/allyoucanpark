package com.example.demo.dao;

import java.util.UUID;
import java.util.List;
import com.example.demo.model.Benutzer;

public interface BenutzerDao {

    int insertBenutzer(UUID id, Benutzer benutzer);

    default int insertBenutzer(Benutzer benutzer) {
        UUID id = UUID.randomUUID();
        return insertBenutzer(id, benutzer);
    }

    List<Benutzer> selectAllBenutzer();
}
