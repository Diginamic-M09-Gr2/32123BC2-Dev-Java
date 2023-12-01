package fr.diginamic.projetspring.repositories;

import fr.diginamic.projetspring.entities.Acteur;
import fr.diginamic.projetspring.entities.Film;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FilmRepository extends JpaRepository<Film, Long> {

    // ... d'autres méthodes de repository

    List<Film> findByActeursContains(Acteur acteur);
}