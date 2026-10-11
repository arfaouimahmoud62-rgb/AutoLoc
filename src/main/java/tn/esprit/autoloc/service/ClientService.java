package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Client;

import java.util.List;
import java.util.Optional;

/**
 * Interface métier (Service) pour la gestion des clients.
 * Principe de conception IoC / DIP : on dépend d'abstractions, pas d'implémentations concrètes.
 */
public interface ClientService {

    List<Client> getAllClients();

    Optional<Client> getClientById(Long id);

    Client saveClient(Client client);

    Client updateClient(Long id, Client clientDetails);

    void deleteClient(Long id);
}
