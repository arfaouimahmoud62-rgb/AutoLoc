package tn.esprit.espoline.scope;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) // Portée Prototype (une instance par injection/demande)
public class PrototypeComponent {

    private final String id = UUID.randomUUID().toString();

    public String getId() {
        return id;
    }
}
