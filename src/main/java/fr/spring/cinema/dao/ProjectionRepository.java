package fr.spring.cinema.dao;


import fr.spring.cinema.entity.ProjectionFilm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin("http://localhost:4200")
public interface ProjectionRepository extends JpaRepository<ProjectionFilm,Long> {
}
