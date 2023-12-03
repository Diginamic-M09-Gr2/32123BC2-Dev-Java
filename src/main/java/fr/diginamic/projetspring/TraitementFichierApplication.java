package fr.diginamic.projetspring;

import fr.diginamic.projetspring.entities.*;
import fr.diginamic.projetspring.services.ActeurService;
import fr.diginamic.projetspring.services.FilmService;
import fr.diginamic.projetspring.services.RealisateurService;
import fr.diginamic.projetspring.services.RoleFilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EntityScan(basePackages = "fr.diginamic.projetspring.entities")
public class TraitementFichierApplication implements CommandLineRunner {

    @Autowired
    private ActeurService acteurService;

    @Autowired
    private RealisateurService realisateurService;

    @Autowired
    private RoleFilmService roleFilmService;

    @Autowired
    private FilmService filmService;

    public static void main(String[] args) {
        SpringApplication.run(TraitementFichierApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // ...

        Path pathFilms = Paths.get("C:/dev-java/films.csv");
        List<String> rowFilms = Files.readAllLines(pathFilms);
        rowFilms.remove(0);
        for (String rowFilm : rowFilms) {
            System.out.println(rowFilm);
            String[] elements = rowFilm.split(";");
            Film films = new Film();
            films.setNom(elements[1]);
            films.setRating(elements[3]);
            films.setLieuTournage(elements[4]);
            List<Genre> genres = parseGenres(elements[5]);
            films.setGenres(genres);
            films.setLangue(elements[6]);
            films.setResume(elements[7]);
            films.setPays(elements[8]);
            filmService.saveFilm(films);
        }
    }


    private List<Genre> parseGenres(String genresString) {
        List<Genre> genres = new ArrayList<>();
        String[] genreArray = genresString.split(","); // Supposons que les genres soient séparés par des virgules

        for (String genreName : genreArray) {
            // Pour chaque genre dans le tableau, créez un objet Genre et ajoutez-le à la liste
            Genre genre = new Genre();
            genre.setType(genreName.trim()); // Assurez-vous de supprimer les espaces inutiles
            genres.add(genre);
        }

        return genres;
    }
}
