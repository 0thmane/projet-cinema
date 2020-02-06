package fr.spring.cinema.dao;


import fr.spring.cinema.entity.Categorie;
import fr.spring.cinema.entity.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieRepository extends JpaRepository<Categorie,Long> {
}
