package fr.diginamic.projetspring.controllers;

import fr.diginamic.projetspring.entities.Film;
import fr.diginamic.projetspring.entities.RoleFilm;
import fr.diginamic.projetspring.services.FilmService;
import fr.diginamic.projetspring.services.RoleFilmService;
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
@RequestMapping("/api/films")
public class FilmController {

    /** Service gérant la logique métier des films. */
    private final FilmService filmService;

    /** Service gérant la logique métier des rôles dans les films. */
    private final RoleFilmService roleFilmService;

    /**
     * Constructeur du contrôleur avec injection des services.
     *
     * @param filmService    Service gérant la logique métier des films.
     * @param roleFilmService Service gérant la logique métier des rôles dans les films.
     */
    @Autowired
    public FilmController(FilmService filmService, RoleFilmService roleFilmService) {
        this.filmService = filmService;
        this.roleFilmService = roleFilmService;
    }

    // Opérations CRUD pour les films

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
     * @param id Identifiant du film à récupérer.
     * @return Le film correspondant à l'identifiant.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Film> getFilmById(@PathVariable("id") Long id) {
        Optional<Film> optionalFilm = filmService.getFilmById(id);
        return optionalFilm.map(film -> new ResponseEntity<>(film, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
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
     * @param id   Identifiant du film à mettre à jour.
     * @param film Les nouvelles données du film.
     * @return Le film mis à jour.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Film> updateFilm(@PathVariable("id") Long id, @RequestBody Film film) {
        Optional<Film> optionalUpdatedFilm = filmService.updateFilm(id, film);
        return optionalUpdatedFilm.map(updatedFilm -> new ResponseEntity<>(updatedFilm, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Endpoint pour supprimer un film par son identifiant.
     *
     * @param id Identifiant du film à supprimer.
     * @return Réponse indiquant le succès de l'opération.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFilm(@PathVariable("id") Long id) {
        filmService.deleteFilm(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Opérations spécifiques

    /**
     * Endpoint pour obtenir la liste des films associés à un acteur.
     *
     * @param acteurId Identifiant de l'acteur.
     * @return La liste des films associés à l'acteur.
     */
    @GetMapping("/acteur/{acteurId}")
    public ResponseEntity<List<Film>> getFilmsByActeur(@PathVariable("acteurId") Long acteurId) {
        List<Film> films = filmService.getFilmsByActeur(acteurId);
        return new ResponseEntity<>(films, HttpStatus.OK);
    }

    /**
     * Endpoint pour obtenir la liste des rôles dans un film.
     *
     * @param filmId Identifiant du film.
     * @return La liste des rôles dans le film.
     */
    @GetMapping("/roles/{filmId}")
    public ResponseEntity<List<RoleFilm>> getRolesByFilm(@PathVariable("filmId") Long filmId) {
        List<RoleFilm> roles = roleFilmService.getRolesByFilm(filmId);
        return new ResponseEntity<>(roles, HttpStatus.OK);
    }

    // Ajoutez d'autres méthodes selon vos besoins
}
