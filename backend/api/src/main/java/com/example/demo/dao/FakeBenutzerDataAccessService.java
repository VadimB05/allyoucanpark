package com.example.demo.dao;

import com.example.demo.model.Benutzer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository("fakeDao")
public class FakeBenutzerDataAccessService implements BenutzerDao {

    private static List<Benutzer> DB = new ArrayList<>();

    @Override
    public int insertBenutzer(UUID id, Benutzer benutzer) {
        DB.add(new Benutzer(id, benutzer.getName()));
        return 0;
    }

    @Override
    public List<Benutzer> selectAllBenutzer() {
        return DB;
    }
}
