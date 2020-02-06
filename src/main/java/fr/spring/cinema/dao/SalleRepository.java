package fr.spring.cinema.dao;


import fr.spring.cinema.entity.Salle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalleRepository extends JpaRepository<Salle,Long> {
}
