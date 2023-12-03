package fr.diginamic.projetspring.repositories;

import fr.diginamic.projetspring.entities.Acteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface ActeurRepository extends JpaRepository<Acteur, Long> {
    // Ajoutez des méthodes personnalisées si nécessaire
    @Query("SELECT a FROM Acteur a WHERE a.adresse.ville = ?1 AND a.adresse.pays = ?2")
    List<Acteur> findByLieuNaissance(String ville, String pays);
}
