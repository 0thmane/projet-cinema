package fr.spring.cinema.entity.projection;

import fr.spring.cinema.entity.Place;
import fr.spring.cinema.entity.ProjectionFilm;
import fr.spring.cinema.entity.Ticket;
import org.springframework.data.rest.core.config.Projection;

import javax.persistence.*;

@Projection(name = "p2",types = Ticket.class)
public interface TicketsProj {


    public Long getId();
    public String getNomClient();
    public double getPrix();
    public Integer getCodePayement();
    public boolean isReserve();
    public Place getPlace();
}
