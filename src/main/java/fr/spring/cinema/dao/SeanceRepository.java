package fr.spring.cinema.dao;


import fr.spring.cinema.entity.Seance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeanceRepository extends JpaRepository<Seance,Long> {
}
