package fr.diginamic.projetspring.traitement;

import fr.diginamic.projetspring.entities.Film;
import fr.diginamic.projetspring.entities.Genre;
import fr.diginamic.projetspring.services.FilmService;
import fr.diginamic.projetspring.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class ImportFilms {

    @Autowired
    private FilmService filmService;

    @Autowired
    private GenreService genreService;

    // Method to convert genre strings to Genre objects
    private Set<Genre> convertGenres(String genresString) {
        Set<Genre> genres = new HashSet<>();
        String[] genreTypes = genresString.split(",");

        for (String genreType : genreTypes) {
            Genre genre = genreService.findOrCreateGenreByType(genreType.trim());
            genres.add(genre);
        }

        return genres;
    }

    public void importFilms() {
        Set<String> uniqueFilmIds = new HashSet<>();

        Path pathFilms = Paths.get("src/main/resources/dataset/films.csv");
        try {
            List<String> rowFilms = Files.readAllLines(pathFilms);
            rowFilms.remove(0);

            for (String rowFilm : rowFilms) {
                System.out.println(rowFilm);
                String[] elements = rowFilm.split(";");
                if (elements.length < 10) {
                    System.out.println("Invalid data: " + rowFilm);
                    continue;
                }
                String idIMDB = elements[0].trim();
                // Check if ID already exists
                if (!uniqueFilmIds.contains(idIMDB)) {
                    Film film = createFilmFromElements(elements);
                    try {
                        filmService.createFilm(film);
                        uniqueFilmIds.add(idIMDB);
                    } catch (DataIntegrityViolationException e) {
                        System.out.println("Duplicate ID: " + idIMDB);
                    }
                } else {
                    System.out.println("Duplicate ID: " + idIMDB);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Film createFilmFromElements(String[] elements) {
        Film film = new Film();
        film.setIdIMDB(elements[0].trim());
        film.setNom(elements[1]);

        if (elements.length >= 3) {
            try {
                film.setAnneeSortie(Integer.valueOf(elements[2]));
            } catch (NumberFormatException e) {
                System.out.println("Error converting film data: " + elements);
                e.printStackTrace();
            }
        }

        film.setRating(elements[3]);
        film.setUrlProfile(elements[4]);
        film.setLieuTournage(elements[5]);

        if (elements.length >= 8) {
            String resume = elements[8];
            if (resume.length() > 255) {
                resume = resume.substring(0, 255);
            }
            film.setResume(resume);
        } else {
            film.setResume("");
        }

        // Convert genres and set them to the film
        if (elements.length >= 7) {
            String genresString = elements[6];
            Set<Genre> genres = convertGenres(genresString);
            film.setGenres(genres);
        }

        film.setLangue(elements[7]);
        film.setPays(elements[9]);

        return film;
    }
}
