package fr.diginamic.projetspring.entities;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Acteur {
    // Ajoutez les annotations pour la clé primaire et la génération automatique de l'ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String idImdb;
    private String identite;
    private String dateNaissance;

    private final Adresse lieuNaissance;



    // d'autres champs et méthodes si nécessaires

    // constructeurs

    public Acteur(String idImdb, String identite, String dateNaissance, Adresse lieuNaissance) {
        this.idImdb = idImdb;
        this.identite = identite;
        this.dateNaissance = dateNaissance;
        this.lieuNaissance = lieuNaissance;
    }

    // getters/setters

    public String getIdImdb() {
        return idImdb;
    }

    public void setIdImdb(String idImdb) {
        this.idImdb = idImdb;
    }

    public String getIdentite() {
        return identite;
    }

    public void setIdentite(String identite) {
        this.identite = identite;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public Adresse getLieuNaissance() {
        return lieuNaissance;
    }



    // ...
}