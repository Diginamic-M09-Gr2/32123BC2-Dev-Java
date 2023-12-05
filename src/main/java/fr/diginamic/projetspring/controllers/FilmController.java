package fr.diginamic.projetspring.controllers;

import fr.diginamic.projetspring.entities.Film;
import fr.diginamic.projetspring.services.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Contrôleur REST pour la gestion des films.
 */
@RestController
@RequestMapping("/films")
public class FilmController {

    @Autowired
    private FilmService filmService;

    /**
     * Endpoint pour obtenir la liste de tous les films.
     *
     * @return La liste de tous les films.
     */
    @GetMapping
    public ResponseEntity<List<Film>> getAllFilms() {
        List<Film> films = filmService.getAllFilms();
        return new ResponseEntity<>(films, HttpStatus.OK);
    }

    /**
     * Endpoint pour obtenir un film par son identifiant.
     *
     * @param filmId Identifiant du film à récupérer.
     * @return Le film correspondant à l'identifiant.
     */
    @GetMapping("/{filmId}")
    public ResponseEntity<Film> getFilmById(@PathVariable("filmId") Long filmId) {
        Optional<Film> film = filmService.getFilmById(filmId);
        return film.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Endpoint pour créer un nouveau film.
     *
     * @param film Le film à créer.
     * @return Le film créé.
     */
    @PostMapping
    public ResponseEntity<Film> createFilm(@RequestBody Film film) {
        Film createdFilm = filmService.createFilm(film);
        return new ResponseEntity<>(createdFilm, HttpStatus.CREATED);
    }

    /**
     * Endpoint pour mettre à jour un film existant.
     *
     * @param filmId Identifiant du film à mettre à jour.
     * @param film   Les nouvelles données du film.
     */
    @PutMapping("/{filmId}")
    @ResponseStatus(HttpStatus.OK)
    public void updateFilm(@PathVariable("filmId") Long filmId, @RequestBody Film film) {
        filmService.updateFilm(filmId, film);
    }

    /**
     * Endpoint pour supprimer un film par son identifiant.
     *
     * @param filmId Identifiant du film à supprimer.
     */
    @DeleteMapping("/{filmId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteFilm(@PathVariable Long filmId) {
        filmService.deleteFilm(filmId);
    }

    // Ajoutez d'autres méthodes selon vos besoins
}
