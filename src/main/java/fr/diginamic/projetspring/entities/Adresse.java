package fr.diginamic.projetspring.entities;


import jakarta.persistence.*;

import java.util.List;

@Entity
public class Adresse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Ou une autre stratégie de génération d'identifiant appropriée
    private Long id;

    private String ville;
    private String departement;
    private String etat;
    private String pays;

    //public Adresse(){}

    @OneToOne
    @JoinTable(
            name = "ads",
            joinColumns = @JoinColumn(name = "adresse_id"),
            inverseJoinColumns = @JoinColumn(name = "acteur_id")
    )
    private List<Acteur> acteurs;

    // constructeurs
    public Adresse(){}
    public Adresse(String ville, String departement, String etat, String pays) {
        this.ville = ville;
        this.departement = departement;
        this.etat = etat;
        this.pays = pays;
    }
    public List<Acteur> getActeurs() {
        return acteurs;
    }

    // getters/setters

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public void setActeurs(List<Acteur> acteurs) {
        this.acteurs = acteurs;
    }

// ...
}