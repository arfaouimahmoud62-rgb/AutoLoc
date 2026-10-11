package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Vehicule;

import java.util.List;
import java.util.Optional;

/**
 * Interface de la couche métier (Service) pour la gestion des véhicules.
 */
public interface VehiculeService {

    List<Vehicule> getAllVehicules();

    Optional<Vehicule> getVehiculeById(Long id);

    Optional<Vehicule> getVehiculeByImmatriculation(String immatriculation);

    List<Vehicule> getVehiculesByMarque(String marque);

    Vehicule saveVehicule(Vehicule vehicule);

    Vehicule updateVehicule(Long id, Vehicule vehiculeDetails);

    void deleteVehicule(Long id);
}
