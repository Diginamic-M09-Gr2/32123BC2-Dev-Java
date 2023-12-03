package fr.diginamic.projetspring.controllers;

import fr.diginamic.projetspring.entities.Acteur;
import fr.diginamic.projetspring.services.ActeurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/acteurs")
public class ActeurController {

    private final ActeurService acteurService;

    @Autowired
    public ActeurController(ActeurService acteurService) {
        this.acteurService = acteurService;
    }

    @GetMapping
    public List<Acteur> getAllActeurs() {
        return acteurService.getAllActeurs();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Acteur> getActeurById(@PathVariable Long id) {
        Optional<Acteur> acteur = acteurService.getActeurById(id);

        return acteur.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Acteur saveActeur(@RequestBody Acteur acteur) {
        return acteurService.saveActeur(acteur);
    }

    @PutMapping("/{id}")
    public Acteur updateActeur(@PathVariable Long id, @RequestBody Acteur acteur) {
        return acteurService.updateActeur(id, acteur);
    }

    @DeleteMapping("/{id}")
    public void deleteActeur(@PathVariable Long id) {
        acteurService.deleteActeur(id);
    }
}