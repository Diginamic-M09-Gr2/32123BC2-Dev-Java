package fr.diginamic.projetspring.controllers;

import fr.diginamic.projetspring.entities.Film;
import fr.diginamic.projetspring.entities.RoleFilm;
import fr.diginamic.projetspring.services.ActeurService;
import fr.diginamic.projetspring.services.FilmService;
import fr.diginamic.projetspring.services.RoleFilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/films")
public class FilmController {

    private final FilmService filmService;
    private final ActeurService acteurService;
    private final RoleFilmService roleFilmService;

    @Autowired
    public FilmController(FilmService filmService, ActeurService acteurService, RoleFilmService roleFilmService) {
        this.filmService = filmService;
        this.acteurService = acteurService;
        this.roleFilmService = roleFilmService;
    }

    // Opérations CRUD pour les films

    @GetMapping
    public ResponseEntity<List<Film>> getAllFilms() {
        List<Film> films = filmService.getAllFilms();
        return new ResponseEntity<>(films, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Film> getFilmById(@PathVariable Long id) {
        Optional<Film> optionalFilm = filmService.getFilmById(id);
        return optionalFilm.map(film -> new ResponseEntity<>(film, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Film> createFilm(@RequestBody Film film) {
        Film createdFilm = filmService.createFilm(film);
        return new ResponseEntity<>(createdFilm, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Film> updateFilm(@PathVariable Long id, @RequestBody Film film) {
        Optional<Film> optionalUpdatedFilm = filmService.updateFilm(id, film);
        return optionalUpdatedFilm.map(updatedFilm -> new ResponseEntity<>(updatedFilm, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFilm(@PathVariable Long id) {
        filmService.deleteFilm(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Opérations spécifiques

    @GetMapping("/roles/{filmId}")
    public ResponseEntity<List<RoleFilm>> getRolesByFilm(@PathVariable Long filmId) {
        List<RoleFilm> roles = roleFilmService.getRolesByFilm(filmId);
        return new ResponseEntity<>(roles, HttpStatus.OK);
    }

    // Ajoutez d'autres méthodes selon vos besoins
}
