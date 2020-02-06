package fr.spring.cinema.dao;


import fr.spring.cinema.entity.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film,Long> {
}
