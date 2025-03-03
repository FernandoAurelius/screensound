package br.com.floresdev.screensound.services;

import br.com.floresdev.screensound.models.Artist;
import br.com.floresdev.screensound.models.Music;
import br.com.floresdev.screensound.repositories.MusicRepository;

public class MusicService {

    @SuppressWarnings("FieldMayBeFinal")
    private MusicRepository repository;

    public MusicService(MusicRepository musicRepository) {
        this.repository = musicRepository;
    }

    public void addMusic(String name, Artist artist) {
        try {
            Music music = new Music(name, artist);
            repository.save(music);
            System.out.println("Música adicionada com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro adicionando música: " + e.getMessage());
        }
    }

    public void listMusics() {
        try {
            repository.findAll().forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("Erro listando músicas: " + e.getMessage());
        }
    }

    public void searchMusicByArtist(Artist artist) {
        try {
            repository.findByArtist(artist).forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("Erro buscando músicas por artista: " + e.getMessage());
        }
    }

}
