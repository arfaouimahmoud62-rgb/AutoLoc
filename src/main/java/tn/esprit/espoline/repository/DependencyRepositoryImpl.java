package tn.esprit.espoline.repository;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import tn.esprit.espoline.model.Course;

import java.util.Arrays;
import java.util.List;

@Repository
@Primary // Implémentation par défaut utilisée pour la résolution des ambiguïtés
public class DependencyRepositoryImpl implements IDependencyRepository {

    @Override
    public List<Course> findAllCourses() {
        return Arrays.asList(
            new Course(1L, "Architecture des SI & Spring Boot", "ASI-01", 4),
            new Course(2L, "Inversion de Contrôle & Injection de Dépendances", "ASI-02", 3),
            new Course(3L, "Conception Orientée Objet & Design Patterns", "COO-01", 5)
        );
    }
}
