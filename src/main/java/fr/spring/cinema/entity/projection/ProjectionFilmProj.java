package fr.spring.cinema.entity.projection;

import fr.spring.cinema.entity.*;
import org.springframework.data.rest.core.config.Projection;

import java.util.Collection;
import java.util.Date;

@Projection(name = "p1",types = ProjectionFilm.class)
public interface ProjectionFilmProj {
    public Double getPrix();
    public Date getDateProjection();
    public Film getFilm();
    public Salle getSalle();
    public Seance getSeance();
    public Collection<Ticket> getTickets();


}
