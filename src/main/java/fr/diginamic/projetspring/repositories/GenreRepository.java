package fr.diginamic.projetspring.repositories;

import fr.diginamic.projetspring.entities.Film;
import fr.diginamic.projetspring.entities.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GenreRepository extends JpaRepository<Genre, Long> {

    // Requête personnalisée pour récupérer les films par nom de genre
    @Query("SELECT f FROM Film f " +
            "WHERE f.genre.type = :nomGenre")
    List<Film> findFilmsByGenreType(@Param("nomGenre") String nomGenre);

    // Autres méthodes pour les requêtes restantes
}
