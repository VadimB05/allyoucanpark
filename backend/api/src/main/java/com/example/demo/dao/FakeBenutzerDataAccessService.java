package com.example.demo.dao;

import com.example.demo.model.Benutzer;
import com.example.demo.model.BenutzerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository("fakeDao")
public class FakeBenutzerDataAccessService implements BenutzerDao {

    private final BenutzerRepository benutzerRepository;

    @Autowired
    public FakeBenutzerDataAccessService(BenutzerRepository benutzerRepository) {
        this.benutzerRepository = benutzerRepository;
    }

    @Override
    public int insertBenutzer(UUID userid, Benutzer benutzer) {
        Benutzer benutzer1 = new Benutzer(userid, benutzer);
        benutzerRepository.save(benutzer1);
        return 0;
    }

    @Override
    public List<Benutzer> selectAllBenutzer() {
        return benutzerRepository.findAll();
    }

    @Override
    public boolean deleteBenutzer(String username) {
        Benutzer benutzer = benutzerRepository.findBenutzerByUsername(username).get();
        benutzerRepository.delete(benutzer);

        return true;
    }
}
