package fr.diginamic.projetspring.traitement;

import fr.diginamic.projetspring.entities.Acteur;
import fr.diginamic.projetspring.entities.Film;
import fr.diginamic.projetspring.entities.RoleFilm;
import fr.diginamic.projetspring.services.ActeurService;
import fr.diginamic.projetspring.services.FilmService;
import fr.diginamic.projetspring.services.RoleFilmService;
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
public class ImportRoleFilms {

    @Autowired
    private ActeurService acteurService;

    @Autowired
    private FilmService filmService;

    @Autowired
    private RoleFilmService roleFilmService;

    public void importRoleFilms() {
        Set<String> uniqueRoleFilmIds = new HashSet<>();

        Path pathRoleFilm = Paths.get("src/main/resources/dataset//roles.csv");
        try {
            List<String> rowRoleFilm = Files.readAllLines(pathRoleFilm);
            rowRoleFilm.remove(0);

            for (String rowRoleFilms : rowRoleFilm) {
                System.out.println(rowRoleFilms);
                String[] elements = rowRoleFilms.split(";");
                if (elements.length >= 3) {
                    String acteurIdIMDB = elements[1].trim();
                    String filmIdIMDB = elements[0].trim();
                    String roleId = acteurIdIMDB + "_" + filmIdIMDB;

                    if (!uniqueRoleFilmIds.contains(roleId)) {
                        Acteur acteur = acteurService.findByIdIMDB(acteurIdIMDB);
                        Film film = filmService.findByIdIMDB(filmIdIMDB);

                        if (acteur != null && film != null) {
                            RoleFilm role = createRoleFilmFromElements(acteur, film, elements);
                            try {
                                roleFilmService.createRoleFilm(role);
                                uniqueRoleFilmIds.add(roleId);
                            } catch (DataIntegrityViolationException e) {
                                System.out.println("Duplicate Role ID: " + roleId);
                            }
                        } else {
                            System.out.println("Invalid Acteur or Film ID");
                        }
                    } else {
                        System.out.println("Duplicate Role ID: " + roleId);
                    }
                } else {
                    System.out.println("Insufficient elements in the CSV row");
                }
            }

            System.out.println("Unique Role IDs Set: " + uniqueRoleFilmIds);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private RoleFilm createRoleFilmFromElements(Acteur acteur, Film film, String[] elements) {
        RoleFilm role = new RoleFilm();
        role.setActeur(acteur);
        role.setFilm(film);
        role.setPersonnage(elements[2]);
        return role;
    }
}
