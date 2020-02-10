package fr.spring.cinema;

import fr.spring.cinema.entity.Film;
import fr.spring.cinema.entity.Salle;
import fr.spring.cinema.entity.Ticket;
import fr.spring.cinema.service.ICinemaInitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class CinemaApplication implements CommandLineRunner {

	@Autowired
	ICinemaInitService iCinemaInitService ;
	@Autowired
	RepositoryRestConfiguration restConfiguration;
	public static void main(String[] args) {
		SpringApplication.run(CinemaApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {

		restConfiguration.exposeIdsFor(Film.class, Salle.class);
//		iCinemaInitService.initVille();
//		iCinemaInitService.initCinema();
//		iCinemaInitService.initSalles();
//		iCinemaInitService.initPlaces();
//		iCinemaInitService.initSeances();
//		iCinemaInitService.initCategories();
//		iCinemaInitService.initFilms();
//		iCinemaInitService.initProjections();
//		iCinemaInitService.initTickets();

	}
}
