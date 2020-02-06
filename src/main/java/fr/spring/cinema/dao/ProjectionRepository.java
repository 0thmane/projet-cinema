package fr.spring.cinema.dao;


import fr.spring.cinema.entity.Projection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectionRepository extends JpaRepository<Projection,Long> {
}
