package fr.diginamic.projetspring.repositories;

import fr.diginamic.projetspring.entities.RoleFilm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Interface repository pour l'entité RoleFilm, utilisant Spring Data JPA.
 */
public interface RoleFilmRepository extends JpaRepository<RoleFilm, Integer> {

    /**
     * Récupère la liste des rôles associés à un film spécifié.
     *
     * @param filmId Identifiant du film.
     * @return La liste des rôles dans le film spécifié.
     */
    @Query("SELECT rf FROM RoleFilm rf JOIN rf.film f WHERE f.filmId = :filmId")
    List<RoleFilm> findAllByFilmId(@Param("filmId") Integer filmId);

    /**
     * Récupère la liste des rôles associés à un acteur spécifié.
     *
     * @param acteurId Identifiant de l'acteur.
     * @return La liste des rôles de l'acteur spécifié.
     */
    @Query("SELECT rf FROM RoleFilm rf JOIN rf.acteur a WHERE a.acteurId = :acteurId")
    List<RoleFilm> findAllByActeurId(@Param("acteurId") Integer acteurId);

    /**
     * Récupère la liste des rôles associés à un film spécifié.
     *
     * @param filmId Identifiant du film.
     * @return La liste des rôles dans le film spécifié.
     */
    List<RoleFilm> findRolesByFilmId(Long filmId);
}
