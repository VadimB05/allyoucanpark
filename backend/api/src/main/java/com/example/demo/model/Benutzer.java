package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Benutzer {

    @Id
    private final UUID userid;

    private final String username;
    private final String passwort;

    public Benutzer() {
        this.userid = null;
        this.username = null;
        this.passwort = null;
    }

    public Benutzer(@JsonProperty("userid") UUID userid,
                    @JsonProperty("username") String username,
                    @JsonProperty("passwort") String passwort)
    {
        this.userid = userid;
        this.username = username;
        this.passwort = passwort;
    }

    public Benutzer(UUID id, Benutzer benutzer) {
        this.userid = id;
        this.passwort = benutzer.getPasswort();
        this.username = benutzer.getUsername();
    }

    public UUID getUserid() {
        return userid;
    }

    public String getUsername() {
        return username;
    }

    public String getPasswort() {
        return passwort;
    }
}