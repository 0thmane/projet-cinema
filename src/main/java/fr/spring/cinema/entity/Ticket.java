package fr.spring.cinema.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Ticket implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomClient;
    private double prix;
    @Column(unique = false,nullable = true)
    private Integer codePayement;
    private boolean reserve;
    @ManyToOne
    private ProjectionFilm projectionFilm;
    @ManyToOne
    private Place place;

    public Ticket() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public Integer getCodePayement() {
        return codePayement;
    }

    public void setCodePayement(Integer codePayement) {
        this.codePayement = codePayement;
    }

    public boolean isReserve() {
        return reserve;
    }

    public void setReserve(boolean reserve) {
        this.reserve = reserve;
    }

    public ProjectionFilm getProjectionFilm() {
        return projectionFilm;
    }

    public void setProjectionFilm(ProjectionFilm projectionFilm) {
        this.projectionFilm = projectionFilm;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return Objects.equals(id, ticket.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", nomClient='" + nomClient + '\'' +
                ", prix='" + prix + '\'' +
                ", codePayement=" + codePayement +
                ", reserve=" + reserve +
                '}';
    }
}
