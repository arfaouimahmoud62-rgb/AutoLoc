package tn.esprit.autoloc.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Client;
import tn.esprit.autoloc.repository.ClientRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * Implémentation du service Client.
 * Utilise l'injection par constructeur moderne recommandée par Spring (via Lombok @AllArgsConstructor).
 * Aucun @Autowired sur les champs n'est utilisé afin de garantir l'immutabilité et la testabilité.
 */
@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {

    // Dépendance finale injectée par constructeur
    private final ClientRepository clientRepository;

    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public Optional<Client> getClientById(Long id) {
        return clientRepository.findById(id);
    }

    @Override
    public Client saveClient(Client client) {
        if (client.getDateInscription() == null) {
            client.setDateInscription(LocalDate.now());
        }
        return clientRepository.save(client);
    }

    @Override
    public Client updateClient(Long id, Client clientDetails) {
        return clientRepository.findById(id)
            .map(existingClient -> {
                existingClient.setNom(clientDetails.getNom());
                existingClient.setPrenom(clientDetails.getPrenom());
                existingClient.setEmail(clientDetails.getEmail());
                existingClient.setTelephone(clientDetails.getTelephone());
                existingClient.setNumPermis(clientDetails.getNumPermis());
                return clientRepository.save(existingClient);
            })
            .orElseThrow(() -> new RuntimeException("Client introuvable avec l'identifiant : " + id));
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }
}
