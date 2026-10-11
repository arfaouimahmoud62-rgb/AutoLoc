package tn.esprit.autoloc.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.service.VehiculeService;

import java.util.List;

/**
 * Contrôleur REST pour la gestion des véhicules.
 * Architecture en couches Spring Boot avec injection de dépendances par constructeur.
 */
@RestController
@RequestMapping("/vehicule")
@AllArgsConstructor
public class VehiculeController {

    private final VehiculeService vehiculeService;

    // Récupérer tous les véhicules
    // GET http://localhost:8080/vehicule
    @GetMapping
    public List<Vehicule> getAllVehicules() {
        return vehiculeService.getAllVehicules();
    }

    // Récupérer un véhicule par son identifiant
    // GET http://localhost:8080/vehicule/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Vehicule> getVehiculeById(@PathVariable Long id) {
        return vehiculeService.getVehiculeById(id)
            .map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Filtrer par marque
    // GET http://localhost:8080/vehicule/search?marque=Renault
    @GetMapping("/search")
    public List<Vehicule> getVehiculesByMarque(@RequestParam String marque) {
        return vehiculeService.getVehiculesByMarque(marque);
    }

    // Créer un véhicule
    // POST http://localhost:8080/vehicule
    @PostMapping
    public ResponseEntity<Vehicule> createVehicule(@RequestBody Vehicule vehicule) {
        Vehicule created = vehiculeService.saveVehicule(vehicule);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    // Mettre à jour un véhicule
    // PUT http://localhost:8080/vehicule/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Vehicule> updateVehicule(@PathVariable Long id, @RequestBody Vehicule vehiculeDetails) {
        try {
            Vehicule updated = vehiculeService.updateVehicule(id, vehiculeDetails);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Supprimer un véhicule
    // DELETE http://localhost:8080/vehicule/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVehicule(@PathVariable Long id) {
        vehiculeService.deleteVehicule(id);
        return ResponseEntity.noContent().build();
    }
}
