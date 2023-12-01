package fr.diginamic.projetspring.services;

import fr.diginamic.projetspring.entities.Realisateur;
import fr.diginamic.projetspring.repositories.RealisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service gérant les opérations liées à l'entité Realisateur.
 */
@Service
public class RealisateurService {

    private final RealisateurRepository realisateurRepository;

    /**
     * Constructeur du service Realisateur.
     *
     * @param realisateurRepository Le repository pour les opérations liées à l'entité Realisateur.
     */
    @Autowired
    public RealisateurService(RealisateurRepository realisateurRepository) {
        this.realisateurRepository = realisateurRepository;
    }

    /**
     * Insère un réalisateur dans la base de données.
     *
     * @param realisateur Le réalisateur à insérer.
     */
    public static void insertFilm(Realisateur realisateur) {
        // Implémentation selon les besoins
    }

    /**
     * Récupère tous les réalisateurs.
     *
     * @return Une liste de tous les réalisateurs.
     */
    public List<Realisateur> getAllRealisateurs() {
        return realisateurRepository.findAll();
    }

    /**
     * Récupère un réalisateur par son identifiant.
     *
     * @param id L'identifiant du réalisateur.
     * @return Le réalisateur correspondant à l'identifiant, ou un Optional vide s'il n'existe pas.
     */
    public Optional<Realisateur> getRealisateurById(Long id) {
        return realisateurRepository.findById(id);
    }

    /**
     * Enregistre un nouveau réalisateur dans la base de données.
     *
     * @param realisateur Le réalisateur à enregistrer.
     * @return Le réalisateur enregistré.
     */
    public Realisateur saveRealisateur(Realisateur realisateur) {
        return realisateurRepository.save(realisateur);
    }

    /**
     * Supprime un réalisateur par son identifiant.
     *
     * @param id L'identifiant du réalisateur à supprimer.
     */
    public void deleteRealisateurById(Long id) {
        realisateurRepository.deleteById(id);
    }

    // Ajoutez d'autres méthodes en fonction des besoins
}
