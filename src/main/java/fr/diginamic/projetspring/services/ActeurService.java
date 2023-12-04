package fr.diginamic.projetspring.services;

import fr.diginamic.projetspring.entities.Acteur;
import fr.diginamic.projetspring.repositories.ActeurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service gérant les opérations liées à l'entité Acteur.
 */
@Service
public class ActeurService {

    private ActeurRepository acteurRepository;

    /**
     * Constructeur du service Acteur.
     *
     * @param acteurRepository Le repository Spring Data JPA pour l'entité Acteur.
     */
    @Autowired
    public ActeurService(ActeurRepository acteurRepository) {
        this.acteurRepository = acteurRepository;
    }

    /**
     * Récupère tous les acteurs.
     *
     * @return Une liste de tous les acteurs.
     */
    public List<Acteur> getAllActeurs() {
        return acteurRepository.findAll();
    }

    /**
     * Récupère un acteur par son identifiant.
     *
     * @param id L'identifiant de l'acteur.
     * @return L'acteur correspondant à l'identifiant, ou null s'il n'existe pas.
     */
    public Acteur getActeurById(Long id) {
        return acteurRepository.findById(id).orElse(null);
    }

    /**
     * Crée un nouvel acteur.
     *
     * @param acteur L'acteur à créer.
     * @return L'acteur créé.
     */
    public Acteur saveActeur(Acteur acteur) {
        // Logique de création de l'acteur (par exemple, validation des données, etc.)
        return acteurRepository.save(acteur);
    }

    /**
     * Met à jour un acteur existant.
     *
     * @param id     L'identifiant de l'acteur à mettre à jour.
     * @param acteur Les nouvelles données de l'acteur.
     * @return L'acteur mis à jour, ou null si l'acteur avec l'ID spécifié n'existe pas.
     */
    public Acteur updateActeur(Long id, Acteur acteur) {
        // Logique de mise à jour de l'acteur (par exemple, vérification de l'existence de l'acteur, validation des données, etc.)
        if (acteurRepository.existsById(id)) {
            acteur.setId(id);
            return acteurRepository.save(acteur);
        }
        return null; // Ou lancez une exception appropriée si nécessaire
    }

    /**
     * Supprime un acteur par son identifiant.
     *
     * @param id L'identifiant de l'acteur à supprimer.
     */
    public void deleteActeur(Long id) {
        acteurRepository.deleteById(id);
    }

    // Ajoutez d'autres méthodes au besoin

    // Getter et Setter pour acteurRepository
    public ActeurRepository getActeurRepository() {
        return acteurRepository;
    }

    public void setActeurRepository(ActeurRepository acteurRepository) {
        this.acteurRepository = acteurRepository;
    }
}
