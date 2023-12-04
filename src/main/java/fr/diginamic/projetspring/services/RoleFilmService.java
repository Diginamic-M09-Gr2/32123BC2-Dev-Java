package fr.diginamic.projetspring.services;

import fr.diginamic.projetspring.entities.RoleFilm;
import fr.diginamic.projetspring.repositories.RoleFilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service gérant les opérations liées à l'entité RoleFilm.
 */
@Service
public class RoleFilmService {

    private final RoleFilmRepository roleRepository;

    /**
     * Constructeur du service RoleFilm.
     *
     * @param roleRepository Le repository pour les opérations liées à l'entité RoleFilm.
     */
    @Autowired
    public RoleFilmService(RoleFilmRepository roleRepository) {
        this.roleRepository = roleRepository;
    }


    /**
     * Insère un rôle dans la base de données.
     */
    public static void insertFilm() {
        // Implémentation selon les besoins
    }

    /**
     * Récupère un rôle par son identifiant.
     *
     * @param id L'identifiant du rôle.
     * @return Le rôle correspondant à l'identifiant, ou un Optional vide s'il n'existe pas.
     */
    public Optional<RoleFilm> getRoleById(Long id) {
        return roleRepository.findById(id);
    }

    /**
     * Récupère tous les rôles.
     *
     * @return Une liste de tous les rôles.
     */
    public List<RoleFilm> getAllRoles() {
        return roleRepository.findAll();
    }

    /**
     * Enregistre un nouveau rôle dans la base de données.
     *
     * @param role Le rôle à enregistrer.
     * @return Le rôle enregistré.
     */
   public RoleFilm saveRoleFilm(RoleFilm role) {
        return roleRepository.save(role);
    }

    /**
     * Supprime un rôle par son identifiant.
     *
     * @param id L'identifiant du rôle à supprimer.
     */
    public void deleteRoleFilm(Long id) {
        roleRepository.deleteById(id);
    }

    /**
     * Récupère tous les rôles associés à un film.
     *
     * @param filmId L'identifiant du film.
     * @return Une liste de rôles associés au film, ou une liste vide s'il n'y en a pas.
     */
    public List<RoleFilm> getRolesByFilm(Long filmId) {
        // Implémentation selon les besoins
        return null;
    }

    public void deleteRole(Long id) {
    }

    // Ajoutez d'autres méthodes en fonction des besoins
}
