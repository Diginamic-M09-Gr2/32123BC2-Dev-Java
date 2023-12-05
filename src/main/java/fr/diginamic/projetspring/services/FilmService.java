package fr.diginamic.projetspring.services;

import fr.diginamic.projetspring.entities.Film;
import fr.diginamic.projetspring.repositories.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import fr.diginamic.projetspring.entities.RoleFilm;

/**
 * Service gérant la logique métier liée aux films.
 */
@Service
public class FilmService {

    @Autowired
    private FilmRepository filmRepository;

    @Autowired
    private RoleFilmService roleFilmService; // Ajout de la variable roleFilmService

    /**
     * Récupère la liste de tous les films.
     *
     * @return La liste de tous les films.
     */
    public List<Film> getAllFilms() {
        return filmRepository.findAll();
    }

    /**
     * Récupère un film par son identifiant.
     *
     * @param id Identifiant du film à récupérer.
     * @return Le film correspondant à l'identifiant.
     */
    public Optional<Film> getFilmById(Long id) {
        return filmRepository.findById(id);
    }

    /**
     * Crée un nouveau film.
     *
     * @param film Le film à créer.
     * @return Le film créé.
     */
    public Film createFilm(Film film) {
        // Ajoutez ici la logique de création si nécessaire
        return filmRepository.save(film);
    }

    /**
     * Met à jour un film existant.
     *
     * @param id      Identifiant du film à mettre à jour.
     * @param newFilm Les nouvelles données du film.
     * @return Le film mis à jour.
     */
    public Optional<Film> updateFilm(Long id, Film newFilm) {
        return filmRepository.findById(id)
                .map(existingFilm -> {
                    // Ajoutez ici la logique de mise à jour si nécessaire
                    existingFilm.setTitre(newFilm.getTitre());
                    existingFilm.setAnneeSortie(newFilm.getAnneeSortie());
                    // Mettez à jour d'autres champs si nécessaire
                    return filmRepository.save(existingFilm);
                });
    }

    /**
     * Supprime un film par son identifiant.
     *
     * @param id Identifiant du film à supprimer.
     */
    public void deleteFilm(Long id) {
        // Ajoutez ici la logique de suppression si nécessaire
        filmRepository.deleteById(id);
    }

    /**
     * Récupère la liste des films associés à un acteur.
     *
     * @param acteurId Identifiant de l'acteur.
     * @return La liste des films associés à l'acteur.
     */
    public List<Film> getFilmsByActeur(Long acteurId) {
        // Ajoutez ici la logique pour récupérer les films associés à un acteur
        return filmRepository.findFilmsByActeurId(acteurId);
    }

    /**
     * Récupère la liste des rôles dans un film.
     *
     * @param filmId Identifiant du film.
     * @return La liste des rôles dans le film.
     */
    public List<RoleFilm> getRolesByFilm(Long filmId) {
        // Ajoutez ici la logique pour récupérer les rôles dans un film
        return roleFilmService.getRolesByFilm(filmId);
    }

    /**
     * Récupère la liste des films entre deux années.
     *
     * @param debut Année de début.
     * @param fin   Année de fin.
     * @return La liste des films entre les deux années.
     */
    public List<Film> getFilmsBetweenYears(int debut, int fin) {
        return filmRepository.findFilmsBetweenYears(debut, fin);
    }

    /**
     * Récupère la liste des films communs entre deux acteurs.
     *
     * @param acteurId1 Identifiant du premier acteur.
     * @param acteurId2 Identifiant du deuxième acteur.
     * @return La liste des films communs entre les deux acteurs.
     */
    public List<Film> findCommonFilmsByActeurs(Long acteurId1, Long acteurId2) {
        return filmRepository.findCommonFilmsByActeurs(acteurId1, acteurId2);
    }

    /**
     * Récupère la liste des films par le nom d'un genre.
     *
     * @param nomGenre Nom du genre.
     * @return La liste des films du genre spécifié.
     */
    public List<Film> findFilmsByGenreNom(String nomGenre) {
        return filmRepository.findFilmsByGenreNom(nomGenre);
    }
}
