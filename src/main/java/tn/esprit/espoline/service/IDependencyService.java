package tn.esprit.espoline.service;

import tn.esprit.espoline.model.Course;
import java.util.List;

public interface IDependencyService {
    List<Course> getAllCourses();
    List<Course> getMockCourses();
    String testScopes();
}
