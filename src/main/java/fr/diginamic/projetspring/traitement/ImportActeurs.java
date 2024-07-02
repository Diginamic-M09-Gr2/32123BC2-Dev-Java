package fr.diginamic.projetspring.traitement;

import fr.diginamic.projetspring.entities.Acteur;
import fr.diginamic.projetspring.services.ActeurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Classe permettant l'importation des acteurs depuis un fichier CSV.
 */
@Component
public class ImportActeurs {

    @Autowired
    private ActeurService acteurService;

    private final SimpleDateFormat sdf = new SimpleDateFormat("MMMM d yyyy");

    /**
     * Méthode principale pour importer les acteurs depuis un fichier CSV.
     */
    public void importActeurs() {
        Set<String> uniqueActeurIds = new HashSet<>();

        Path pathActeurs = Paths.get("src/main/resources/dataset/acteurs.csv");
        try {
            List<String> rowsActeurs = Files.readAllLines(pathActeurs);
            rowsActeurs.remove(0); // Supprime l'en-tête du fichier CSV
            for (String rowActeur : rowsActeurs) {
                System.out.println(rowActeur);
                String[] elements = rowActeur.split(";");
                String idIMDB = elements[0].trim();
                if (!uniqueActeurIds.contains(idIMDB)) {
                    Acteur acteur = createActeurFromElements(elements);
                    try {
                        acteurService.createActeur(acteur);
                        uniqueActeurIds.add(idIMDB);
                    } catch (DataIntegrityViolationException e) {
                        System.out.println("Duplicate ID: " + idIMDB);
                    }
                } else {
                    System.out.println("Duplicate ID: " + idIMDB);
                }
            }
            System.out.println("Unique IDs Set: " + uniqueActeurIds);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    /**
     * Crée un objet Acteur à partir des éléments d'une ligne CSV.
     *
     * @param elements Les éléments de la ligne CSV
     * @return L'acteur créé
     * @throws ParseException Si la date de naissance ne peut pas être parsée
     */
    private Acteur createActeurFromElements(String[] elements) throws ParseException {
        Acteur acteur = new Acteur();
        acteur.setIdIMDB(elements[0].trim());
        acteur.setNom(elements[1]);
        try {
            Date dateNaissance = sdf.parse(elements[2]);
            acteur.setDateNaissance(dateNaissance);
        } catch (ParseException e) {
            e.printStackTrace();
            throw e; // Relancer l'exception après l'avoir enregistrée
        }
        acteur.setLieuNaissance(elements[3]);
        acteur.setUrlProfile(elements[5]);
        return acteur;
    }
}
