package fr.spring.cinema.service.impl;

import fr.spring.cinema.dao.*;
import fr.spring.cinema.entity.*;
import fr.spring.cinema.service.ICinemaInitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

@Service
@Transactional
public class CinemaInitServiceImpl implements ICinemaInitService {

    @Autowired
    private VilleRepository villeRepository ;
    @Autowired
    private CinemaRepository cinemaRepository;
    @Autowired
    private SalleRepository salleRepository ;
    @Autowired
    private PlaceRepository placeRepository;
    @Autowired
    private ProjectionRepository projectionRepository ;
    @Autowired
    private SeanceRepository seanceRepository ;
    @Autowired
    private CategorieRepository categorieRepository ;
    @Autowired
    private TicketRepository ticketRepository ;
    @Autowired
    private FilmRepository filmRepository ;

    @Override
    public void initVille() {

        Stream.of("Paris", "Aubervilliers", "Rosny", "Villemomble", "Chelle").
                forEach(v ->{
                    Ville ville = new Ville();
                    ville.setName(v);
                    villeRepository.save(ville);
                } );
    }

    @Override
    public void initCinema() {
        villeRepository.findAll().forEach(ville->{
            Stream.of("UGC","Pathé gaumont","aixos").forEach(nameCinema -> {
                Cinema cinema = new  Cinema();
                cinema.setName(nameCinema);
                cinema.setVille(ville);
                cinema.setNombreDeSalle(3+(int)(Math.random()*5));
                cinemaRepository.save(cinema);
            });
        });

    }

    @Override
    public void initSalles() {

        cinemaRepository.findAll().forEach(cinema->{
            for(int i=0 ;i<cinema.getNombreDeSalle() ; i++){
                Salle salle = new  Salle();
                salle.setName("Salle "+(i+1));
                salle.setCinema(cinema);
                salle.setNombreDePlace(10+(int)(Math.random()*20));
                salleRepository.save(salle);
            }

        });
    }

    @Override
    public void initPlaces() {
        salleRepository.findAll().forEach(salle->{
            for(int i=0 ;i<salle.getNombreDePlace() ; i++){
                Place place = new  Place();
                place.setName("place N° "+(i+1));
                place.setNumero(i+1);
                place.setSalle(salle);
                placeRepository.save(place);
            }

        });
    }

    @Override
    public void initSeances() {
        Stream.of("12:00","15:00","17:00","19:00","21:00").forEach(heure->{
            DateFormat df = new SimpleDateFormat("HH:mm");
            Seance seance = new Seance();
            try {
                seance.setHeureDebut(df.parse(heure));
                seanceRepository.save(seance);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        });

    }

    @Override
    public void initCategories() {

        Stream.of("Histoire","Action","Fiction","Thriller").forEach(cat->{
            Categorie categorie = new Categorie();
            categorie.setName(cat);
            categorieRepository.save(categorie);
        });
    }

    @Override
    public void initFilms() {
        double[] durre = new double[]{1d,1.5,2d,2.5,3d};
        List<Categorie> categorieList = categorieRepository.findAll() ;
        Stream.of("Parasite","Joker","Once Upon a Time","Les Miserables","Avengers Endgame","Star Wars : episode 9","Le chant du loup","Ad Astral")
                .forEach(nameFilm ->{
                    Film film = new Film();
                    film.setTitre(nameFilm);
                    film.setDescription(nameFilm);
                    film.setDuree(durre[new Random().nextInt(durre.length)]);
                    film.setPhoto(nameFilm.replaceAll(" ","")+".jpeg");
                    film.setCategorie(categorieList.get(new Random().nextInt(categorieList.size())));
                    filmRepository.save(film) ;

                });
    }

    @Override
    public void initProjections() {
        double[] prices = new double[]{ 5d, 7d, 9d};
        List<Film> films = filmRepository.findAll();
        villeRepository.findAll().forEach(ville -> {
            ville.getCinemas().forEach(cinema->{
                cinema.getSalles().forEach(salle ->{
                        seanceRepository.findAll().forEach(seance->{
                            int index = new Random().nextInt(films.size());
                            ProjectionFilm projectionFilm = new ProjectionFilm();
                            projectionFilm.setDateProjection(new Date());
                            projectionFilm.setFilm(films.get(index));
                            projectionFilm.setPrix(prices[new Random().nextInt(prices.length)]);
                            projectionFilm.setSalle(salle);
                            projectionFilm.setSeance(seance);
                            projectionRepository.save(projectionFilm);
                        });

                });
            });

        });

    }

    @Override
    public void initTickets() {
        projectionRepository.findAll().forEach(p ->{
           p.getSalle().getPlaces().forEach(place->{
               Ticket ticket = new Ticket() ;
               ticket.setPlace(place);
               ticket.setPrix(p.getPrix());
               ticket.setProjectionFilm(p);
               ticket.setReserve(false);
               ticketRepository.save(ticket);
           });

        });

    }
}
