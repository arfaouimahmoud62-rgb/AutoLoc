package tn.esprit.autoloc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.autoloc.domain.Client;

import java.util.Optional;

/**
 * Repository Spring Data JPA pour l'entité Client.
 * Fournit automatiquement les opérations CRUD et de pagination.
 */
@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    // Méthode de requête personnalisée dérivée (Query Method)
    Optional<Client> findByEmail(String email);

    boolean existsByEmail(String email);
}
