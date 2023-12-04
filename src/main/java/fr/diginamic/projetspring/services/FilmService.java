package fr.diginamic.projetspring.services;

import fr.diginamic.projetspring.entities.Acteur;
import fr.diginamic.projetspring.entities.Film;
import fr.diginamic.projetspring.repositories.ActeurRepository;
import fr.diginamic.projetspring.repositories.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class FilmService {

    @Autowired
    private FilmRepository filmRepository;

    public static void insertFilm(Film films) {
    }

    public List<Film> getAllFilms() {
        return filmRepository.findAll();
    }

    public Optional<Film> getFilmById(Long id) {
        return filmRepository.findById(id);
    }

    public Film saveFilm(Film film) {
        return filmRepository.save(film);
    }

    public void deleteFilm(Long id) {
        filmRepository.deleteById(id);
    }

    // Fonctionnalités supplémentaires

    public List<Acteur> getActeursByFilm(Long filmId) {
        Optional<Film> film = filmRepository.findById(filmId);
        return film.map(Film::getActeurs)
                .orElse(Collections.emptyList());
    }

    public Film createFilm(Film film) {
        return film;
    }

    public Optional<Film> updateFilm(Long id, Film film) {
        return Optional.empty();
    }

    // Autres méthodes en fonction des besoins
}
