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
    private String prenom;

    @ManyToOne
    @JoinColumn(name = "film_id")
    private Film film;

    @OneToMany(mappedBy = "acteur")
    private List<RoleFilm> roles;

    private LocalDate dateNaissance;

    // Constructeurs
    public Acteur() {
    }

    public Acteur(String nom, String prenom, Film film) {
        this.nom = nom;
        this.prenom = prenom;
        this.film = film;
    }

    // Getters et setters
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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public List<RoleFilm> getRoles() {
        return roles;
    }

    public void setDateNaissance(String element) {
    }

    public void setLieuNaissance(String element) {
    }

    public void setUrlProfil(String element) {
    }

    public void insertActeurs(Acteur acteurs) {
    }
}
