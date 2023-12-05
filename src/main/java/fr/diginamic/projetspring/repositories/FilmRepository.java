package fr.diginamic.projetspring.repositories;

import fr.diginamic.projetspring.entities.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Interface repository pour l'entité Film, utilisant Spring Data JPA.
 */
@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {

    /**
     * Recherche les films associés à un acteur donné.
     *
     * @param acteurId Identifiant de l'acteur.
     * @return Liste des films associés à l'acteur.
     */
    List<Film> findFilmsByActeurId(Long acteurId);

    /**
     * Recherche les films sortis entre deux années données.
     *
     * @param debut Année de début.
     * @param fin   Année de fin.
     * @return Liste des films sortis entre les années données.
     */
    List<Film> findFilmsBetweenYears(int debut, int fin);

    /**
     * Recherche les films communs entre deux acteurs.
     *
     * @param acteurId1 Identifiant du premier acteur.
     * @param acteurId2 Identifiant du deuxième acteur.
     * @return Liste des films communs entre les deux acteurs.
     */
    @Query("SELECT f FROM Film f " +
            "JOIN RoleFilm r ON f.id = r.film.id " +
            "JOIN Acteur a ON r.acteur.id = a.id " +
            "WHERE a.id IN (:acteurId1, :acteurId2)")
    List<Film> findCommonFilmsByActeurs(@Param("acteurId1") Long acteurId1, @Param("acteurId2") Long acteurId2);

    /**
     * Recherche les films par le nom du genre.
     *
     * @param nomGenre Nom du genre.
     * @return Liste des films du genre spécifié.
     */
    List<Film> findFilmsByGenreNom(String nomGenre);
}
