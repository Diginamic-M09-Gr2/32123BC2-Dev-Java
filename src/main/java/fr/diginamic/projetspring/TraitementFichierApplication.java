/*package fr.diginamic.projetspring;

import fr.diginamic.projetspring.entities.Acteur;
import fr.diginamic.projetspring.entities.Film;
import fr.diginamic.projetspring.entities.Realisateur;
import fr.diginamic.projetspring.entities.RoleFilm;
import fr.diginamic.projetspring.services.ActeurService;
import fr.diginamic.projetspring.services.FilmService;
import fr.diginamic.projetspring.services.RealisateurService;
import fr.diginamic.projetspring.services.RoleFilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class TraitementFichierApplication implements CommandLineRunner {

    @Autowired
    private ActeurService acteurService;
    private RealisateurService realisateurService;
    private RoleFilmService roleFilmService;
    private FilmService filmService;// doit ajouter les autres services

    public static void main(String[] args) {
        SpringApplication.run(TraitementFichierApplication.class, args);
    }


    /* Alimentation de la base de données à partir de fichiers CSV
    @Override
    public void run(String... args) throws Exception {
        Path pathActeurs = Paths.get("C:/dev-java/acteurs.csv");  // Import acteurs.csv
        List<String> rowsActeurs = Files.readAllLines(pathActeurs);
        rowsActeurs.remove(0);
        for (String rowActeur: rowsActeurs){
            System.out.println(rowActeur);
            String[] elements = rowActeur.split(";");
            Acteur acteurs = new Acteur();
            acteurs.setNom(elements[1]);

            acteurs.setLieuNaissance(elements[3]);
            acteurs.setUrlProfile(elements[5]);
            acteurService.saveActeur(acteurs);
        }
        Path pathFilms = Paths.get("C:/dev-java/films.csv");  // Import films.csv
        List<String> rowFilms = Files.readAllLines(pathFilms);
        rowFilms.remove(0);
        for (String rowFilm: rowFilms){
            System.out.println(rowFilm);
            String[] elements = rowFilm.split(";");
            Film films = new Film();
            films.setNom(elements[1]);

            films.setRating(elements[3]);
            films.setLieuTournage(elements[4]);
            films.setGenres(elements[5]);
            films.setLangue(elements[6]);
            films.setResume(elements[7]);
            films.setPays(elements[8]);
            filmService.saveFilm(films);
        }
        Path pathRealisateurs = Paths.get("C:/dev-java/realisateurs.csv");  // Import realisateurs.csv
        List<String> rowRealisateurs = Files.readAllLines(pathRealisateurs);
        rowRealisateurs.remove(0);
        for (String rowRealisateur : rowRealisateurs){
            System.out.println(rowRealisateur);
            String[] elements = rowRealisateur.split(";");
            Realisateur realisateurs = new Realisateur();
            realisateurs.setNom(elements[1]);

            realisateurs.setLieuNaissance(elements[3]);
            realisateurs.setUrlProfile(elements[4]);
            realisateurService.saveRealisateur(realisateurs);
        }

        Path pathRoleFilm = Paths.get("C:/dev-java/roles.csv");  // Import roles.csv !! role changer à FilmRole pour prévenir confusion entre Role et Role(class Java)
        List<String> rowRoleFilm = Files.readAllLines(pathRoleFilm);
        rowRoleFilm.remove(0);
        for (String rowRoleFilms : rowRoleFilm){
            System.out.println(rowRoleFilm);
            String[] elements = rowRoleFilms.split(";");
            RoleFilm role = new RoleFilm();
            role.setPersonnage(elements[2]);
            roleFilmService.saveRoleFilm(role);
        }
        /*Path pathFilm_Realisateurs = Paths.get("C:/dev-java/film_realisateurs.csv");  // Import film_realisateurs.csv
        List<String> rowFilm_Realisateurs = Files.readAllLines(pathFilm_Realisateurs);
        rowFilmRoles.remove(0);
        for (String rowFilm_Realisateur : rowFilm_Realisateurs){
            System.out.println(rowFilm_Realisateurs);
            String[] elements = rowFilm_Realisateurs.split(";");
            Film_Realisateurs film_realisateur = new Film_Realisateurs();
            film_realisateur.setNom(elements[0]);
            film_realisateur.setRealisateur(elements[1]);
            Film_RealisateurService.insertFilm(film_realisateur);
        }
    }
*/