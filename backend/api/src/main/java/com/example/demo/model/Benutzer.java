package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Benutzer {

    private final UUID userid;
    private final String username;
    private final String passwort;

    public Benutzer(@JsonProperty("userid") UUID userid,
                    @JsonProperty("username") String username,
                    @JsonProperty("passwort") String passwort)
    {
        this.userid = userid;
        this.username = username;
        this.passwort = passwort;
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
