package fr.diginamic.projetspring.services;

import fr.diginamic.projetspring.entities.Genre;
import fr.diginamic.projetspring.repositories.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service gérant les opérations liées à l'entité Genre.
 */
@Service
public class GenreService {

    private final GenreRepository genreRepository;

    /**
     * Constructeur du service Genre.
     *
     * @param genreRepository Le repository pour les opérations liées à l'entité Genre.
     */
    @Autowired
    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    /**
     * Enregistre un nouveau genre dans la base de données.
     *
     * @param genre Le genre à enregistrer.
     * @return Le genre enregistré.
     */
    public Genre saveGenre(Genre genre) {
        return genreRepository.save(genre);
    }

    /**
     * Récupère tous les genres présents dans la base de données.
     *
     * @return La liste de tous les genres.
     */
    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }

    /**
     * Récupère un genre par son identifiant.
     *
     * @param id L'identifiant du genre.
     * @return Le genre correspondant à l'identifiant.
     */
    public Genre getGenreById(Long id) {
        Optional<Genre> optionalGenre = genreRepository.findById(id);
        return optionalGenre.orElse(null);
    }

    /**
     * Met à jour un genre existant dans la base de données.
     *
     * @param id    L'identifiant du genre à mettre à jour.
     * @param genre Les nouvelles données du genre.
     * @return Le genre mis à jour.
     */
    public Genre updateGenre(Long id, Genre genre) {
        if (genreRepository.existsById(id)) {
            genre.setId(id);
            return genreRepository.save(genre);
        }
        return null;
    }

    /**
     * Supprime un genre par son identifiant.
     *
     * @param id L'identifiant du genre à supprimer.
     */
    public void deleteGenreById(Long id) {
        genreRepository.deleteById(id);
    }
}
