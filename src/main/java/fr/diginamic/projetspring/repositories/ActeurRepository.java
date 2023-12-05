package fr.diginamic.projetspring.repositories;

import fr.diginamic.projetspring.entities.Acteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import fr.diginamic.projetspring.entities.Film;
import fr.diginamic.projetspring.entities.Genre;

import java.util.Date;
import java.util.List;

/**
 * Interface repository pour l'entité Acteur, utilisant Spring Data JPA.
 * Cette interface définit les méthodes permettant d'interagir avec la base de données
 * pour l'entité Acteur.
 */
public interface ActeurRepository extends JpaRepository<Acteur, Long> {

    /**
     * Recherche les acteurs communs entre deux films donnés.
     *
     * @param film1 Premier film
     * @param film2 Deuxième film
     * @return Liste des acteurs communs entre les deux films
     */
    @Query("SELECT a FROM Acteur a " +
            "JOIN RoleFilm r1 ON a = r1.acteur " +
            "JOIN RoleFilm r2 ON a = r2.acteur " +
            "WHERE r1.film = :film1 AND r2.film = :film2")
    List<Acteur> findCommonActeursByFilms(@Param("film1") Film film1, @Param("film2") Film film2);

    /**
     * Recherche les acteurs ayant joué le plus dans des films d'un genre spécifique.
     *
     * @param genre Genre de films
     * @return Liste des acteurs triés par le nombre de films joués dans le genre spécifié
     */
    @Query("SELECT a FROM Acteur a " +
            "JOIN RoleFilm r ON a = r.acteur " +
            "JOIN Film f ON r.film = f " +
            "WHERE f.genre = :genre " +
            "GROUP BY a " +
            "ORDER BY COUNT(a) DESC")
    List<Acteur> findActeursByMostPlayedGenre(@Param("genre") Genre genre);

    /**
     * Recherche tous les acteurs ayant un nom donné.
     *
     * @param nom Nom de l'acteur
     * @return Liste des acteurs ayant le nom spécifié
     */
    List<Acteur> findAllByNom(String nom);

    /**
     * Recherche tous les acteurs ayant un lieu de naissance donné.
     *
     * @param lieuNaissance Lieu de naissance de l'acteur
     * @return Liste des acteurs nés dans le lieu spécifié
     */
    List<Acteur> findAllByLieuNaissance(String lieuNaissance);

    /**
     * Recherche tous les acteurs ayant une date de naissance donnée.
     *
     * @param dateNaissance Date de naissance de l'acteur
     * @return Liste des acteurs nés à la date spécifiée
     */
    List<Acteur> findAllByDateNaissance(Date dateNaissance);

    /**
     * Recherche tous les acteurs ayant une URL de profil donnée.
     *
     * @param urlProfile URL du profil de l'acteur
     * @return Liste des acteurs ayant l'URL de profil spécifiée
     */
    List<Acteur> findAllByUrlProfile(String urlProfile);

    /**
     * Vérifie l'existence d'un acteur avec l'identifiant spécifié.
     *
     * @param acteurId Identifiant de l'acteur
     * @return True si l'acteur existe, sinon False
     */
    boolean existsById(Integer acteurId);
}
