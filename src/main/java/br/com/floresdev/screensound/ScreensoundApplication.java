package br.com.floresdev.screensound;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.floresdev.screensound.repositories.ArtistRepository;
import br.com.floresdev.screensound.repositories.MusicRepository;
import br.com.floresdev.screensound.services.ArtistService;
import br.com.floresdev.screensound.services.MusicService;

@SpringBootApplication
public class ScreensoundApplication implements CommandLineRunner {
	
	@Autowired
	private ArtistRepository artistRepository;

	@Autowired
	private MusicRepository musicRepository;

	public static void main(String[] args) {
		SpringApplication.run(ScreensoundApplication.class, args);
	}

	@Override
	public void run(String... args) {
		UserInterface ui = new UserInterface(new ArtistService(artistRepository), new MusicService(musicRepository));
		ui.start();
	}

}
