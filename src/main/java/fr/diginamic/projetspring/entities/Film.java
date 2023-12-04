package fr.diginamic.projetspring.entities;

import jakarta.persistence.*;
import java.util.List;

/**
 * Représente un film avec ses caractéristiques et les personnes impliquées dans sa création.
 */
@Entity
public class Film {

    /** Identifiant unique du film. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Nom du film. */
    private String nom;

    /** Date de sortie du film. */
    private Integer anneeSortie;

    /** Note du film. */
    private String rating;

    /** URL du profil du film. */
    private String urlProfile;

    /** Lieu de tournage du film. */
    private String lieuTournage;

    /** Langue du film. */
    private String langue;

    /** Genres du film. */
    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;

    /** Résumé du film. */
    private String resume;

    /** Pays d'origine du film. */
    private String pays;

    /** Réalisateur du film. */
    @ManyToOne
    @JoinColumn(name = "realisateur_id")
    private Realisateur realisateur;

    /** Liste des acteurs qui ont joué dans le film. */
    @OneToMany(mappedBy = "film")
    private List<Acteur> acteurs;

    // Constructeurs
    /**
     * Constructeur par défaut.
     */
    public Film() {
    }

    /**
     * Constructeur avec nom, réalisateur et liste d'acteurs.
     *
     * @param nom       Nom du film.
     * @param realisateur Réalisateur du film.
     * @param acteurs   Liste des acteurs qui ont joué dans le film.
     */
    public Film(String nom, Realisateur realisateur, List<Acteur> acteurs) {
        this.nom = nom;
        this.realisateur = realisateur;
        this.acteurs = acteurs;
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

    public Integer getAnneeSortie() {
        return anneeSortie;
    }

    public void setAnneeSortie(Integer anneeSortie) {
        this.anneeSortie = anneeSortie;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getUrlProfile() {
        return urlProfile;
    }

    public void setUrlProfile(String urlProfile) {
        this.urlProfile = urlProfile;
    }

    public String getLieuTournage() {
        return lieuTournage;
    }

    public void setLieuTournage(String lieuTournage) {
        this.lieuTournage = lieuTournage;
    }

    public String getLangue() {
        return langue;
    }

    public void setLangue(String langue) {
        this.langue = langue;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public Realisateur getRealisateur() {
        return realisateur;
    }

    public void setRealisateur(Realisateur realisateur) {
        this.realisateur = realisateur;
    }

    public List<Acteur> getActeurs() {
        return acteurs;
    }

    public void setActeurs(List<Acteur> acteurs) {
        this.acteurs = acteurs;
    }
}
