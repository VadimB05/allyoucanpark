package com.simulation.Parkhaus.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;
/**
 * Vorlesung: Software Engineering (WS 2021/22)
 * Theorieabgabe
 * Aufgabe: allYouCanPark - Parkhaus Backend
 * Thema: MainActivity
 *
 * @author Vadim Balysev
 * @date 01.02.2021
 */

/**
 * In dieser Klasse werden die Attribute definiert
 * Diese Klasse repräsentiert auch Getter für id und ticketzahl
 */
@Entity
public class Parkticket {

    @Id
    private final UUID id;
    private final String ticketzahl;

    public Parkticket() {
        this.id = null;
        this.ticketzahl = null;
    }

    public Parkticket(@JsonProperty("id") UUID id,
                      @JsonProperty("ticketzahl") String ticketzahl) {
        this.id = id;
        this.ticketzahl = ticketzahl;
    }

    public UUID getId() {
        return id;
    }

    public String getTicketzahl() {
        return ticketzahl;
    }
}
