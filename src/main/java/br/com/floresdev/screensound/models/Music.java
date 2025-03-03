package br.com.floresdev.screensound.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Music {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @SuppressWarnings("unused")
    private Long id;

    private String name;

    @ManyToOne
    private Artist artist;

    public Music() {
    }

    public Music(String name, Artist artist) {
        this.name = name;
        this.artist = artist;
    }

    @Override
    public String toString() {
        return "Música: " + name + " | Artista: " + artist.getName();
    }

    public String getName() {
        return this.name;
    }

}
