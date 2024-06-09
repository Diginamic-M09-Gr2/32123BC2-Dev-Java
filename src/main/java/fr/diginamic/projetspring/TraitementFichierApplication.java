package fr.diginamic.projetspring;

import fr.diginamic.projetspring.traitement.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TraitementFichierApplication implements CommandLineRunner {

    @Autowired
    private ImportFilms importFilms;
    @Autowired
    private ImportActeurs importActeurs;
    @Autowired
    private ImportRealisateurs importRealisateurs;
    @Autowired
    private ImportRealisateurFilms importRealisateurFilms;
    @Autowired
    private ImportRoleFilms importRoleFilms;

    public static void main(String[] args) {
        SpringApplication.run(TraitementFichierApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        importActeurs.importActeurs();
        importFilms.importFilms();
        importRealisateurs.importRealisateurs();
        importRealisateurFilms.importFilmRealisateurs();
        //importRoleFilms.importRoleFilms();
    }
}
