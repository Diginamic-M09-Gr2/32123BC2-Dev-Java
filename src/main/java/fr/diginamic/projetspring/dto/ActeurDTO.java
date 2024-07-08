package fr.diginamic.projetspring.dto;

import java.util.Date;

public class ActeurDTO {
    private Integer acteurId;
    private String idIMDB;
    private String nom;
    private Date dateNaissance;
    private String lieuNaissance;
    private String urlProfile;

    // Getters and Setters
    public Integer getActeurId() {
        return acteurId;
    }

    public void setActeurId(Integer acteurId) {
        this.acteurId = acteurId;
    }

    public String getIdIMDB() {
        return idIMDB;
    }

    public void setIdIMDB(String idIMDB) {
        this.idIMDB = idIMDB;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
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
}
