package br.com.floresdev.screensound;

import java.util.Scanner;

import br.com.floresdev.screensound.models.ArtistType;
import br.com.floresdev.screensound.services.ArtistService;
import br.com.floresdev.screensound.services.MusicService;

public class UserInterface {

    @SuppressWarnings("FieldMayBeFinal")
    private static Scanner sc = new Scanner(System.in);

    @SuppressWarnings("FieldMayBeFinal")
    private ArtistService artistService;

    @SuppressWarnings("FieldMayBeFinal")
    private MusicService musicService;

    public UserInterface(ArtistService artistService, MusicService musicService) {
        this.artistService = artistService;
        this.musicService = musicService;
    }

    public void start() {
        String repeat = "y";

        while (repeat.equalsIgnoreCase("y")) {
            String menu = """





            Bem-vindo ao ScreenSound!

                1 - Cadastrar artista
                2 - Cadastrar música
                3 - Listar músicas
                4 - Buscar músicas por artista
                5 - Pesquisar dados sobre um artista
                
                0 - Sair

            Por favor, escolha uma opção acima:\s""";

            System.out.print(menu);
            Integer choice = Integer.valueOf(sc.nextLine());
            switch (choice) {
                case 1 -> {
                    artistService.addArtist(getArtistName(), getArtistType());
                    enterToContinue();
                }
                case 2 -> {
                    musicService.addMusic(
                        getMusicName(), artistService.getArtist(getArtistName())
                    );
                    enterToContinue();
                }
                case 3 -> {
                    musicService.listMusics();
                    enterToContinue();
                }
                case 4 -> {
                    musicService.searchMusicByArtist(
                        artistService.getArtist(getArtistName())
                    );
                    enterToContinue();
                }
                case 5 -> {
                    artistService.getArtistInformation(getArtistName());
                    enterToContinue();
                }
                case 0 -> repeat = "n";
            }
        }
    }

    private String getArtistName() {
        System.out.print("Digite o nome do artista: ");
        String artistName = sc.nextLine();
        return artistName;
    }

    public static ArtistType getArtistType() {
        System.out.print("Digite o tipo do artista: ");
        String type = sc.nextLine();
        return ArtistType.fromString(type);
    }

    private String getMusicName() {
        System.out.print("Digite o nome da música: ");
        String musicName = sc.nextLine();
        return musicName;
    }

    private void enterToContinue() {
        System.out.print("Pressione enter para continuar...");
        sc.nextLine();
    }
    
}
