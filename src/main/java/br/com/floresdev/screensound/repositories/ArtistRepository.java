package br.com.floresdev.screensound.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.floresdev.screensound.models.Artist;

public interface ArtistRepository extends JpaRepository<Artist, Long> {

    /**
     * Finds an artist by name using case-insensitive partial matching.
     * @param name The name to search for
     * @return The matching Artist object or null if no artist is found
     */
    Artist findByNameContainingIgnoreCase(String name);
}
