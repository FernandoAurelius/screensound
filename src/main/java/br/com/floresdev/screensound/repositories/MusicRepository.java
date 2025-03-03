package br.com.floresdev.screensound.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.floresdev.screensound.models.Artist;
import br.com.floresdev.screensound.models.Music;

public interface MusicRepository extends JpaRepository<Music, Long>{

    List<Music> findByArtist(Artist artist);
    
}
