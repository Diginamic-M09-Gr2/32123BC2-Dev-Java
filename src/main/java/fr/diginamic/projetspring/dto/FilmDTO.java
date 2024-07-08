package fr.diginamic.projetspring.dto;

import fr.diginamic.projetspring.entities.Genre;

import java.util.Set;

/**
 * DTO representing a Film with its characteristics and associated genres.
 */
public class FilmDTO {

    private Integer filmId;
    private String nom;
    private String idIMDB;
    private Integer anneeSortie;
    private String rating;
    private String urlProfile;
    private String lieuTournage;
    private String langue;
    private String resume;
    private String pays;
    private Set<Genre> genres;

    // Constructors

    public FilmDTO() {
    }

    public FilmDTO(Integer filmId, String nom, String idIMDB, Integer anneeSortie, String rating, String urlProfile,
                   String lieuTournage, String langue, String resume, String pays, Set<Genre> genres) {
        this.filmId = filmId;
        this.nom = nom;
        this.idIMDB = idIMDB;
        this.anneeSortie = anneeSortie;
        this.rating = rating;
        this.urlProfile = urlProfile;
        this.lieuTournage = lieuTournage;
        this.langue = langue;
        this.resume = resume;
        this.pays = pays;
        this.genres = genres;
    }

    // Getters and Setters

    public Integer getFilmId() {
        return filmId;
    }

    public void setFilmId(Integer filmId) {
        this.filmId = filmId;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getIdIMDB() {
        return idIMDB;
    }

    public void setIdIMDB(String idIMDB) {
        this.idIMDB = idIMDB;
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

    public Set<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }

    // toString method

    @Override
    public String toString() {
        return "FilmDTO{" +
                "filmId=" + filmId +
                ", nom='" + nom + '\'' +
                ", idIMDB='" + idIMDB + '\'' +
                ", anneeSortie=" + anneeSortie +
                ", rating='" + rating + '\'' +
                ", urlProfile='" + urlProfile + '\'' +
                ", lieuTournage='" + lieuTournage + '\'' +
                ", langue='" + langue + '\'' +
                ", resume='" + resume + '\'' +
                ", pays='" + pays + '\'' +
                ", genres=" + genres +
                '}';
    }
}
