package fr.diginamic.projetspring.traitement;

import fr.diginamic.projetspring.entities.Realisateur;
import fr.diginamic.projetspring.services.RealisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class ImportRealisateurs {

    @Autowired
    private RealisateurService realisateurService;

    private final SimpleDateFormat sdf = new SimpleDateFormat("MMMM d yyyy");

    public void importRealisateurs() {
        Set<String> uniqueRealisateurIds = new HashSet<>();

        Path pathRealisateurs = Paths.get("src/main/resources/dataset//realisateurs.csv");
        try {
            List<String> rowsRealisateurs = Files.readAllLines(pathRealisateurs);
            rowsRealisateurs.remove(0);
            for (String rowRealisateur : rowsRealisateurs) {
                System.out.println(rowRealisateur);
                String[] elements = rowRealisateur.split(";");
                String idIMDB = elements[0].trim();
                if (!uniqueRealisateurIds.contains(idIMDB)) {
                    Realisateur realisateur = createRealisateurFromElements(elements);
                    try {
                        realisateurService.createRealisateur(realisateur);
                        uniqueRealisateurIds.add(idIMDB);
                    } catch (DataIntegrityViolationException e) {
                        System.out.println("Duplicate ID: " + idIMDB);
                    }
                } else {
                    System.out.println("Duplicate ID: " + idIMDB);
                }
            }
            System.out.println("Unique IDs Set: " + uniqueRealisateurIds);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    private Realisateur createRealisateurFromElements(String[] elements) throws ParseException {
        Realisateur realisateur = new Realisateur();
        realisateur.setIdIMDB(elements[0].trim());
        realisateur.setNom(elements[1]);
        try {
            Date dateNaissance = sdf.parse(elements[2]);
            realisateur.setDateNaissance(dateNaissance);
        } catch (ParseException e) {
        }
        realisateur.setLieuNaissance(elements[3]);
        realisateur.setUrlProfile(elements[4]);
        return realisateur;
    }
}
