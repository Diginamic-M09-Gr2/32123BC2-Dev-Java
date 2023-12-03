package fr.diginamic.projetspring.services;

import fr.diginamic.projetspring.entities.Acteur;
import fr.diginamic.projetspring.entities.Adresse;
import fr.diginamic.projetspring.repositories.ActeurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActeurService {

    private final ActeurRepository acteurRepository;

    @Autowired
    public ActeurService(ActeurRepository acteurRepository) {
        this.acteurRepository = acteurRepository;
    }
    public Acteur processActeurFromCSV(String[] csvData) {
        Adresse adresse = parseLieuNaissance(csvData[3]);

        return new Acteur(
                csvData[0], // Ajoutez la valeur correspondant à l'identifiant IMDb (à ajuster en fonction du format réel)
                csvData[1], // Ajoutez la valeur correspondant à l'identité
                csvData[2], // Ajoutez la valeur correspondant à la date de naissance
                adresse
        );
    }

    private Adresse parseLieuNaissance(String lieuNaissance) {
        // Séparer les composants de la chaîne en utilisant la virgule comme séparateur
        String[] components = lieuNaissance.split(",");

        Adresse adresse = new Adresse();

        if (components.length == 4) {
            // Cas : Ville, Département, État, Pays
            adresse.setVille(components[0].trim());
            adresse.setDepartement(components[1].trim());
            adresse.setEtat(components[2].trim());
            adresse.setPays(components[3].trim());
        } else if (components.length == 1) {
            // Cas : Pays
            adresse.setPays(components[0].trim());
        } else if (components.length == 3) {
            // Cas : Ville, Département, Pays
            adresse.setVille(components[0].trim());
            adresse.setDepartement(components[1].trim());
            adresse.setPays(components[2].trim());
        } else if (components.length == 2) {
            // Cas : Ville, Pays
            adresse.setVille(components[0].trim());
            adresse.setPays(components[1].trim());
        }

        return adresse;
    }

    public List<Acteur> getAllActeurs() {
        return acteurRepository.findAll();
    }

    public Optional<Acteur> getActeurById(Long id) {
        return acteurRepository.findById(id);
    }

    public Acteur saveActeur(Acteur acteur) {
        // Logique de création de l'acteur (par exemple, validation des données, etc.)
        return acteurRepository.save(acteur);
    }

    public Acteur updateActeur(Long id, Acteur newActeur) {
        // Logique de mise à jour de l'acteur
        Optional<Acteur> existingActeur = acteurRepository.findById(id);

        if (existingActeur.isPresent()) {
            Acteur updatedActeur = existingActeur.get();

            // Mettez à jour les champs nécessaires avec les nouvelles valeurs
            updatedActeur.setIdentite(newActeur.getIdentite());
            updatedActeur.setDateNaissance(newActeur.getDateNaissance());
            // ... d'autres champs

            return acteurRepository.save(updatedActeur);
        }

        return null; // Ou lancez une exception appropriée si nécessaire
    }
    public List<Acteur> getActeursByLieuNaissance(String ville, String pays) {
        return acteurRepository.findByLieuNaissance(ville, pays);
    }

    public void deleteActeur(Long id) {
        acteurRepository.deleteById(id);
    }
}