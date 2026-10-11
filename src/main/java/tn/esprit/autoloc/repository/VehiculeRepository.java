package tn.esprit.autoloc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.autoloc.domain.Vehicule;

import java.util.List;
import java.util.Optional;

/**
 * Repository Spring Data JPA pour l'entité Vehicule.
 */
@Repository
public interface VehiculeRepository extends JpaRepository<Vehicule, Long> {

    Optional<Vehicule> findByImmatriculation(String immatriculation);

    List<Vehicule> findByMarqueIgnoreCase(String marque);
}
