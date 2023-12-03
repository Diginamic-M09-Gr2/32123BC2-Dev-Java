package fr.diginamic.projetspring.repositories;

import fr.diginamic.projetspring.entities.Realisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RealisateurRepository extends JpaRepository<Realisateur, Long> {
// Ajoutez des méthodes personnalisées si nécessaire
}