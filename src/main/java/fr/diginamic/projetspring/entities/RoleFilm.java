package fr.diginamic.projetspring.entities;

import jakarta.persistence.*;

/**
 * Représente le rôle d'un acteur dans un film, avec le personnage joué.
 */
@Entity
public class RoleFilm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String personnage;

    @ManyToOne
    @JoinColumn(name = "acteur_id")
    private Acteur acteur;

    @ManyToOne
    @JoinColumn(name = "film_id")
    private Film film;

    // Constructeurs

    /**
     * Constructeur par défaut.
     */
    public RoleFilm() {
    }

    /**
     * Constructeur avec acteur, film et personnage.
     *
     * @param acteur     L'acteur qui joue le rôle.
     * @param film       Le film dans lequel le rôle est joué.
     * @param personnage Le personnage joué par l'acteur dans le film.
     */
    public RoleFilm(Acteur acteur, Film film, String personnage) {
        this.acteur = acteur;
        this.film = film;
        this.personnage = personnage;
    }

    // Getters et Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Acteur getActeur() {
        return acteur;
    }

    public void setActeur(Acteur acteur) {
        this.acteur = acteur;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public String getPersonnage() {
        return personnage;
    }

    public void setPersonnage(String personnage) {
        this.personnage = personnage;
    }
}
