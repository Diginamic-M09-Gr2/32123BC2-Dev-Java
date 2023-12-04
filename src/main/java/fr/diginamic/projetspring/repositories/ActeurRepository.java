package fr.diginamic.projetspring.repositories;

import fr.diginamic.projetspring.entities.Acteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ActeurRepository extends JpaRepository<Acteur, Long> {

    // Requête personnalisée pour récupérer les films par nom d'acteur
    @Query("SELECT f.nom, f.anneeSortie FROM Film f " +
            "JOIN RoleFilm r ON f.id = r.film.id " +
            "JOIN Acteur a ON r.acteur.id = a.id " +
            "WHERE a.nom = :nomActeur")
    List<Object[]> findFilmsByActeurNom(@Param("nomActeur") String nomActeur);

    // Autres méthodes pour les requêtes restantes
}
