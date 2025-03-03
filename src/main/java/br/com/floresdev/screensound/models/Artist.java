package br.com.floresdev.screensound.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


@Entity
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @SuppressWarnings("unused")
    private Long id;

    private String name;

    private ArtistType type;

    @OneToMany(mappedBy = "artist", cascade = jakarta.persistence.CascadeType.ALL, fetch = FetchType.EAGER)
    @SuppressWarnings("FieldMayBeFinal")
    private List<Music> musics = new ArrayList<>();

    public Artist() {
    }

    public Artist(String name, ArtistType type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Artist: ").append(name).append(" (").append(type).append(")\n");
        
        if (musics != null && !musics.isEmpty()) {
            sb.append("Musics:\n");
            for (Music music : musics) {
                sb.append("  - ").append(music.getName()).append("\n");
            }
        } else {
            sb.append("No musics registered for this artist.\n");
        }
        
        return sb.toString();
    }


    public String getName() {
        return name;
    }

}
