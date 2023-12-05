package fr.diginamic.projetspring.entities;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Acteur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private LocalDate dateNaissance;
    private String lieuNaissance;
    private String urlProfile;

    @OneToMany(mappedBy = "acteur")
    private List<RoleFilm> roles;

    public Acteur() {
    }

    // Modifiez le constructeur pour prendre en compte la liste de rôles
    public Acteur(String nom, List<RoleFilm> roles) {
        this.nom = nom;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getLieuNaissance() {
        return lieuNaissance;
    }

    public void setLieuNaissance(String lieuNaissance) {
        this.lieuNaissance = lieuNaissance;
    }

    public String getUrlProfile() {
        return urlProfile;
    }

    public void setUrlProfile(String urlProfile) {
        this.urlProfile = urlProfile;
    }

    public List<RoleFilm> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleFilm> roles) {
        this.roles = roles;
    }

    /**
     * Insère un acteur dans la base de données.
     *
     * @param acteur L'acteur à insérer.
     */
    public void insertActeur(Acteur acteur) {
        // Logique pour insérer l'acteur dans la base de données.
    }
}
