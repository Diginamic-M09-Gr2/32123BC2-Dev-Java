package fr.diginamic.projetspring.repositories;

import fr.diginamic.projetspring.entities.Realisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

/**
 * Interface repository pour l'entité Réalisateur, utilisant Spring Data JPA.
 */
public interface RealisateurRepository extends JpaRepository<Realisateur, Long> {

    // Aucune méthode spécifique déclarée ici, car JpaRepository offre déjà des méthodes génériques pour les opérations CRUD.

    // Ajoutez d'autres méthodes déclaratives en fonction des besoins

    // Exemple : Récupérer tous les réalisateurs avec un certain nom
    List<Realisateur> findByNom(String nom);

    // Exemple : Récupérer tous les réalisateurs nés après une certaine date
    @Query("SELECT r FROM Realisateur r WHERE r.dateNaissance > :dateNaissance")
    List<Realisateur> findByDateNaissanceAfter(@Param("dateNaissance") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateNaissance);

    // Ajoutez d'autres méthodes déclaratives en fonction des besoins
}
