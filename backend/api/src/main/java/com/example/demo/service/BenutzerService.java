package com.example.demo.service;

import com.example.demo.dao.BenutzerDao;
import com.example.demo.model.Benutzer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BenutzerService {

    private final BenutzerDao benutzerDao;

    @Autowired
    public BenutzerService(@Qualifier("fakeDao") BenutzerDao benutzerDao) {
        this.benutzerDao = benutzerDao;
    }

    public int addBenutzer(Benutzer benutzer) {
        return benutzerDao.insertBenutzer(benutzer);
    }

    public List<Benutzer> getAllBenutzer() {
        return benutzerDao.selectAllBenutzer();
    }

    public boolean deleteBenutzer(String username) {
        return benutzerDao.deleteBenutzer(username);
    }
}
