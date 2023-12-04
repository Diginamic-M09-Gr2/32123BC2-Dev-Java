package fr.diginamic.projetspring.entities;

import jakarta.persistence.*;
import java.util.List;

/**
 * Représente un genre de film avec son type et la liste des films associés à ce genre.
 */
@Entity
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;

    @ManyToMany
    @JoinTable(
            name = "film_genre",
            joinColumns = @JoinColumn(name = "genre_id"),
            inverseJoinColumns = @JoinColumn(name = "film_id")
    )
    private List<Film> films;

    // Constructeurs

    /**
     * Constructeur par défaut.
     */
    public Genre() {
    }

    /**
     * Constructeur avec type de genre.
     *
     * @param type Le type de genre (ex: Action, Comédie, Drame, etc.).
     */
    public Genre(String type) {
        this.type = type;
    }

    // Getters et Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Film> getFilms() {
        return films;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }
}
