package fr.diginamic.projetspring.repositories;

import fr.diginamic.projetspring.entities.RoleFilm;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface RoleFilmRepository extends JpaRepository<RoleFilm, Long> {
    // Ajoutez des méthodes personnalisées si nécessaire

}