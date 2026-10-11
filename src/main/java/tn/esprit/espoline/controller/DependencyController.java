package tn.esprit.espoline.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.espoline.model.Course;
import tn.esprit.espoline.service.IDependencyService;

import java.util.List;

@RestController
@RequestMapping("/courses")
@AllArgsConstructor // Injection par constructeur moderne via Lombok sans @Autowired
public class DependencyController {

    private final IDependencyService dependencyService;

    @GetMapping
    public List<Course> getAllCourses() {
        return dependencyService.getAllCourses();
    }

    @GetMapping("/mock")
    public List<Course> getMockCourses() {
        return dependencyService.getMockCourses();
    }

    @GetMapping("/scopes")
    public String checkScopes() {
        return dependencyService.testScopes();
    }
}
