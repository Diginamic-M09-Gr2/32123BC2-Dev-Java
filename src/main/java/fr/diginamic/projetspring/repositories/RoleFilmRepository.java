package fr.diginamic.projetspring.repositories;

import fr.diginamic.projetspring.entities.RoleFilm;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Interface repository pour l'entité RoleFilm, utilisant Spring Data JPA.
 */
public interface RoleFilmRepository extends JpaRepository<RoleFilm, Long> {

    // Aucune méthode spécifique déclarée ici, car JpaRepository offre déjà des méthodes génériques pour les opérations CRUD.

    // Exemple : Récupérer tous les rôles associés à un acteur
    List<RoleFilm> findByActeurId(Long acteurId);

    // Exemple : Récupérer tous les rôles associés à un film
    List<RoleFilm> findByFilmId(Long filmId);

    // Exemple : Récupérer tous les rôles associés à un acteur dans un film
    List<RoleFilm> findByActeurIdAndFilmId(Long acteurId, Long filmId);

    // Ajoutez d'autres méthodes déclaratives en fonction des besoins
}
