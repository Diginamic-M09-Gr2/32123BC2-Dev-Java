package fr.diginamic.projetspring.repositories;

import fr.diginamic.projetspring.entities.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

/**
 * Interface repository pour l'entité Film, utilisant Spring Data JPA.
 */
public interface FilmRepository extends JpaRepository<Film, Long> {

    // Recherche de films par nom d'acteur
    List<Film> findByActeursNom(String nomActeur);

    // Recherche de films par nom
    List<Film> findByNom(String nom);

    // Requête personnalisée pour récupérer les rôles par titre de film
    @Query("SELECT a.nom, rf.personnage FROM Acteur a " +
            "JOIN RoleFilm rf ON a.id = rf.acteur.id " +
            "JOIN Film f ON rf.film.id = f.id " +
            "WHERE f.nom = :nom")
    List<Object[]> findRolesByFilmTitre(@Param("nom") String nom);

    // Requête personnalisée pour récupérer les films par nom d'acteur
    @Query("SELECT f.nom, f.anneeSortie FROM Film f " +
            "JOIN RoleFilm r ON f.id = r.film.id " +
            "JOIN Acteur a ON r.acteur.id = a.id " +
            "WHERE a.nom = :nomActeur")
    List<Object[]> findFilmsByActeurNom(@Param("nomActeur") String nomActeur);

    // Requête personnalisée pour récupérer les acteurs par films entre deux années
    @Query("SELECT a.nom FROM Acteur a " +
            "JOIN RoleFilm r ON a.id = r.acteur.id " +
            "JOIN Film f ON r.film.id = f.id " +
            "WHERE f.anneeSortie BETWEEN :debut AND :fin")
    List<String> findActeursByFilmsBetweenYears(@Param("debut") LocalDate debut, @Param("fin") LocalDate fin);

    // Autres méthodes pour les requêtes restantes

    // Vous pouvez également ajouter d'autres méthodes définies par Spring Data JPA si nécessaire
}
