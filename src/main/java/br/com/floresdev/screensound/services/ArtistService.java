package br.com.floresdev.screensound.services;

import java.io.IOException;

import org.apache.http.HttpException;

import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;

import br.com.floresdev.screensound.UserInterface;
import br.com.floresdev.screensound.models.Artist;
import br.com.floresdev.screensound.models.ArtistType;
import br.com.floresdev.screensound.repositories.ArtistRepository;

public class ArtistService {

    @SuppressWarnings("FieldMayBeFinal")
    private ArtistRepository repository;

    public ArtistService(ArtistRepository artistRepository) {
        this.repository = artistRepository;
    }

    public void addArtist(String name, ArtistType type) {
        try {
            if (repository.findByNameContainingIgnoreCase(name) != null) {
                System.out.println("Artista já cadastrado!");
                return;
            }
            Artist artist = new Artist(name, type);
            repository.save(artist);
            System.out.println("Artista cadastrado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro no cadastro de artista: " + e.getMessage());
        }
    }

    public void getArtistInformation(String artistName) {
        try (Client geminiClient = Client.builder().apiKey("The API Key goes here").build();) {
            String prompt = String.format("""
                Dê um resumo objetivo e sem introduções, de maneira breve e clara, sobre o artista
                %s e suas obras musicais mais populares, para um aplicativo de buscas de música. 
                Não se introduza, não faça afirmações como 'Claro, aqui estão algumas informações...',
                apenas responda com um breve resumo do artista.
            """, artistName);

            GenerateContentResponse response = geminiClient.models.generateContent(
                "gemini-2.0-flash", prompt, null
            );
            
            System.out.println("Sumário do artista: " + response.text());
        } catch (IOException e) {
            System.out.println("Erro na comunicação com a API: " + e.getMessage());
        } catch (HttpException e) {
            System.out.println("Erro no protocolo HTTP: " + e.getMessage());
        }
    }

    public Artist getArtist(String name) {
        Artist artist = repository.findByNameContainingIgnoreCase(name);
        if (artist == null) {
            System.out.print("Artista não encontrado! Por favor, informe o tipo do artista para cadastro:\s");
            addArtist(name, UserInterface.getArtistType());
            return repository.findByNameContainingIgnoreCase(name);
        }
        return artist;
    }

}
