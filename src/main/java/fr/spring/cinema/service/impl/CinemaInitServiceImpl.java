package fr.spring.cinema.service.impl;

import fr.spring.cinema.dao.*;
import fr.spring.cinema.entity.Cinema;
import fr.spring.cinema.entity.Place;
import fr.spring.cinema.entity.Salle;
import fr.spring.cinema.entity.Ville;
import fr.spring.cinema.service.ICinemaInitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
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

    }

    @Override
    public void initCategories() {

    }

    @Override
    public void initFilms() {

    }

    @Override
    public void initProjections() {

    }

    @Override
    public void initTickets() {

    }
}
