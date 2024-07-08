package fr.diginamic.projetspring.controllers;

import fr.diginamic.projetspring.entities.Realisateur;
import fr.diginamic.projetspring.services.RealisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Contrôleur REST pour la gestion des réalisateurs.
 */
@RestController
@RequestMapping("/realisateurs") // ajouter /api/realisateurs si besoins
public class RealisateurController {

    /** Service gérant la logique métier des réalisateurs. */
    @Autowired
    private RealisateurService realisateurService;

    /**
     * Constructeur du contrôleur avec injection du service.
     *
     * @param realisateurService Service gérant la logique métier des réalisateurs.
     */

    /**
     * Endpoint pour obtenir la liste de tous les réalisateurs.
     *
     * @return La liste de tous les réalisateurs.
     */
    /**
     * Endpoint pour obtenir la liste de tous les réalisateurs avec pagination.
     *
     * @param pageable L'objet Pageable pour la pagination.
     * @return Une page de réalisateurs.
     */
    @GetMapping
    public Page<Realisateur> getAllRealisateurs(Pageable pageable) {
        return realisateurService.getAllRealisateurs(pageable);
    }

    @GetMapping("/{idRealisateur}")
    public ResponseEntity<Realisateur> getRealisateurById(@PathVariable("idRealisateur") Integer idRealisateur) {
        Optional<Realisateur> realisateur = realisateurService.getRealisateurById(idRealisateur);
        return realisateur.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Endpoint pour sauvegarder un nouveau réalisateur.
     *
     * @param realisateur Le réalisateur à sauvegarder.
     * @return Le réalisateur sauvegardé.
     */
    @PostMapping
    public Realisateur createRealisateur(@RequestBody Realisateur realisateur) {
        return realisateurService.createRealisateur(realisateur);
    }

    /**
     * Endpoint pour supprimer un réalisateur par son identifiant.
     *
     * @param idRealisateur Identifiant du réalisateur à supprimer.
     */

    @PutMapping("/{idRealisateur}")
    public ResponseEntity<Realisateur> updateRealisateur(@PathVariable("idRealisateur") Integer idRealisateur, @RequestBody Realisateur realisateur) {
        Realisateur updatedRealisateur = realisateurService.updateRealisateur(idRealisateur, realisateur);
        if (updatedRealisateur != null) {
            return ResponseEntity.ok(updatedRealisateur);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{idRealisateur}")
    public void deleteRealisateurById(@PathVariable("id") Integer idRealisateur) {
        realisateurService.deleteRealisateurById(idRealisateur);
    }

    // Implementation des requetes
    // Tache 7:  Extraire tous les films d’un réalisateur donné
    @GetMapping("/{idRealisateur}/films")
    public List<Object[]> getFilmsByRealisateurId(@PathVariable("idRealisateur") Integer idRealisateur) {
        return realisateurService.findFilmsByRealisateurId(idRealisateur);
    }
}
