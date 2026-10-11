package tn.esprit.espoline.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import tn.esprit.espoline.model.Course;

import java.util.Collections;
import java.util.List;

@Repository("mockRepo")
@Qualifier("mockRepo") // Qualificateur explicite pour la désambiguïsation (@Qualifier)
public class MockDependencyRepositoryImpl implements IDependencyRepository {

    @Override
    public List<Course> findAllCourses() {
        return Collections.singletonList(
            new Course(99L, "Cours de Test (Mock)", "TEST-00", 1)
        );
    }
}
