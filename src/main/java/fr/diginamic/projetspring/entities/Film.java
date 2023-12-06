package fr.diginamic.projetspring.entities;

import jakarta.persistence.*;
import java.util.List;

/**
 * Représente un film avec ses caractéristiques et les personnes impliquées dans sa création.
 */
@Entity
@Table(name = "films")
public class Film {

    /**
     * Identifiant unique du film.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer filmId;

    /** Nom du film. */
    private String nom;

    /** Identifiant IMDB du film. */
    private String idIMDB;

    /** Titre du film. */

    /** Année de sortie du film. */
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
    private String genres;

    /** Résumé du film. */
    private String resume;

    /** Pays d'origine du film. */
    private String pays;

    /** Réalisateur du film. */
    @ManyToOne
    @JoinColumn(name = "realisateur_id")
    private Realisateur realisateur;

    /** Liste des rôles que l'acteur a joués dans des films. */
    @OneToMany(mappedBy = "film", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<RoleFilm> rolefilm;

    /**
     * Constructeur par défaut.
     */
    public Film() {
    }

    /**
     * Constructeur avec les attributs principaux du film.
     *
     * @param filmId      Identifiant unique du film.
     * @param anneeSortie Année de sortie du film.
     * @param langue      Langue du film.
     * @param lieuTournage Lieu de tournage du film.
     * @param nom         Nom du film.
     * @param pays        Pays d'origine du film.
     * @param rating      Note du film.
     * @param resume      Résumé du film.
     * @param urlProfile  URL du profil du film.
     * @param genres      Genres du film.
     */
    public Film(Integer filmId, Integer anneeSortie, String langue, String lieuTournage, String nom, String pays, String rating, String resume, String urlProfile, String genres) {
        this.filmId = filmId;
        this.anneeSortie = anneeSortie;
        this.langue = langue;
        this.lieuTournage = lieuTournage;
        this.nom = nom;
        this.pays = pays;
        this.rating = rating;
        this.resume = resume;
        this.urlProfile = urlProfile;
        this.genres = genres;
    }

    /**
     * Obtient le titre du film.
     *
     * @return Le titre du film.
     */

    /**
     * Définit le titre du film.
     *
     * @param titre Le titre du film.
     */
    /**
     * Obtient l'année de sortie du film.
     *
     * @return L'année de sortie du film.
     */
    public Integer getAnneeSortie() {
        return anneeSortie;
    }

    /**
     * Définit l'année de sortie du film.
     *
     * @param anneeSortie L'année de sortie du film.
     */
    public void setAnneeSortie(Integer anneeSortie) {
        this.anneeSortie = anneeSortie;
    }

    // Ajoutez d'autres getters et setters au besoin

    /**
     * Représentation textuelle du film.
     *
     * @return Une chaîne de caractères représentant le film.
     */
    @Override
    public String toString() {
        return "Film{" +
                "filmId=" + filmId +
                ", nom='" + nom + '\'' +
                ", idIMDB='" + idIMDB + '\'' +
                ", anneeSortie=" + anneeSortie +
                ", rating='" + rating + '\'' +
                ", urlProfile='" + urlProfile + '\'' +
                ", lieuTournage='" + lieuTournage + '\'' +
                ", langue='" + langue + '\'' +
                ", genres='" + genres + '\'' +
                ", resume='" + resume + '\'' +
                ", pays='" + pays + '\'' +
                ", realisateur=" + realisateur +
                '}';
    }
}
