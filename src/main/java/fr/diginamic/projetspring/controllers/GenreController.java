package fr.diginamic.projetspring.controllers;

import fr.diginamic.projetspring.entities.Genre;
import fr.diginamic.projetspring.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Contrôleur REST pour la gestion des genres.
 */
@RestController
@RequestMapping("/genres")
public class GenreController {

    private final GenreService genreService;

    /**
     * Constructeur du contrôleur avec injection du service.
     *
     * @param genreService Service gérant la logique métier des genres.
     */
    @Autowired
    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    // Endpoint pour récupérer tous les genres
    @GetMapping
    public ResponseEntity<List<Genre>> getAllGenres() {
        List<Genre> genres = genreService.getAllGenres();
        return new ResponseEntity<>(genres, HttpStatus.OK);
    }

    // Endpoint pour récupérer un genre par son ID
    @GetMapping("/{id}")
    public ResponseEntity<Genre> getGenreById(@PathVariable Long id) {
        Genre genre = genreService.getGenreById(id);
        return new ResponseEntity<>(genre, HttpStatus.OK);
    }

    // Endpoint pour créer un nouveau genre
    @PostMapping
    public ResponseEntity<Genre> createGenre(@RequestBody Genre genre) {
        Genre newGenre = genreService.saveGenre(genre); // Correction ici
        return new ResponseEntity<>(newGenre, HttpStatus.CREATED);
    }

    // Endpoint pour mettre à jour un genre existant
    @PutMapping("/{id}")
    public ResponseEntity<Genre> updateGenre(@PathVariable Long id, @RequestBody Genre genre) {
        Genre updatedGenre = genreService.updateGenre(id, genre);
        return new ResponseEntity<>(updatedGenre, HttpStatus.OK);
    }

    // Endpoint pour supprimer un genre
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGenre(@PathVariable Long id) {
        genreService.deleteGenreById(id); // Correction ici
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
