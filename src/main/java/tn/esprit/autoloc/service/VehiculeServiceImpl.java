package tn.esprit.autoloc.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.repository.VehiculeRepository;

import java.util.List;
import java.util.Optional;

/**
 * Implémentation du service Vehicule.
 * Respecte les principes de l'IoC (Inversion of Control) et de la DI (Dependency Injection) :
 * - Injection par constructeur via Lombok (@AllArgsConstructor).
 * - Immutabilité du repository grâce au mot-clé final.
 * - Aucune annotation @Autowired directe sur les champs.
 */
@Service
@AllArgsConstructor
public class VehiculeServiceImpl implements VehiculeService {

    private final VehiculeRepository vehiculeRepository;

    @Override
    public List<Vehicule> getAllVehicules() {
        return vehiculeRepository.findAll();
    }

    @Override
    public Optional<Vehicule> getVehiculeById(Long id) {
        return vehiculeRepository.findById(id);
    }

    @Override
    public Optional<Vehicule> getVehiculeByImmatriculation(String immatriculation) {
        return vehiculeRepository.findByImmatriculation(immatriculation);
    }

    @Override
    public List<Vehicule> getVehiculesByMarque(String marque) {
        return vehiculeRepository.findByMarqueIgnoreCase(marque);
    }

    @Override
    public Vehicule saveVehicule(Vehicule vehicule) {
        return vehiculeRepository.save(vehicule);
    }

    @Override
    public Vehicule updateVehicule(Long id, Vehicule vehiculeDetails) {
        return vehiculeRepository.findById(id)
            .map(existingVehicule -> {
                existingVehicule.setImmatriculation(vehiculeDetails.getImmatriculation());
                existingVehicule.setMarque(vehiculeDetails.getMarque());
                existingVehicule.setModele(vehiculeDetails.getModele());
                existingVehicule.setAgence(vehiculeDetails.getAgence());
                return vehiculeRepository.save(existingVehicule);
            })
            .orElseThrow(() -> new RuntimeException("Véhicule introuvable avec l'identifiant : " + id));
    }

    @Override
    public void deleteVehicule(Long id) {
        vehiculeRepository.deleteById(id);
    }
}
