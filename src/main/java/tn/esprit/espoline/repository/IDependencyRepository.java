package tn.esprit.espoline.repository;

import tn.esprit.espoline.model.Course;
import java.util.List;

public interface IDependencyRepository {
    List<Course> findAllCourses();
}
