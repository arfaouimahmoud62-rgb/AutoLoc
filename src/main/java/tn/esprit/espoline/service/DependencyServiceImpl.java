package tn.esprit.espoline.service;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import tn.esprit.espoline.model.Course;
import tn.esprit.espoline.repository.IDependencyRepository;
import tn.esprit.espoline.scope.PrototypeComponent;
import tn.esprit.espoline.scope.SingletonComponent;

import java.util.List;

@Service
public class DependencyServiceImpl implements IDependencyService {

    // Injection du repository par défaut (résolution via @Primary)
    private final IDependencyRepository primaryRepository;

    // Injection explicite du repository mock (résolution via @Qualifier)
    private final IDependencyRepository mockRepository;

    private final SingletonComponent singletonBean1;
    private final SingletonComponent singletonBean2;

    // ObjectProvider pour instancier des beans Prototype sur demande
    private final ObjectProvider<PrototypeComponent> prototypeProvider;

    // Injection par constructeur explicite avec @Qualifier (pratique recommandée Spring Boot 3+)
    public DependencyServiceImpl(
            IDependencyRepository primaryRepository,
            @Qualifier("mockRepo") IDependencyRepository mockRepository,
            SingletonComponent singletonBean1,
            SingletonComponent singletonBean2,
            ObjectProvider<PrototypeComponent> prototypeProvider) {
        this.primaryRepository = primaryRepository;
        this.mockRepository = mockRepository;
        this.singletonBean1 = singletonBean1;
        this.singletonBean2 = singletonBean2;
        this.prototypeProvider = prototypeProvider;
    }

    @Override
    public List<Course> getAllCourses() {
        return primaryRepository.findAllCourses();
    }

    @Override
    public List<Course> getMockCourses() {
        return mockRepository.findAllCourses();
    }

    @Override
    public String testScopes() {
        PrototypeComponent proto1 = prototypeProvider.getObject();
        PrototypeComponent proto2 = prototypeProvider.getObject();

        return String.format(
            "SINGLETON: instance1=%s | instance2=%s (Même instance: %b) <br/> " +
            "PROTOTYPE: instance1=%s | instance2=%s (Instances différentes: %b)",
            singletonBean1.getId(), singletonBean2.getId(), singletonBean1.getId().equals(singletonBean2.getId()),
            proto1.getId(), proto2.getId(), !proto1.getId().equals(proto2.getId())
        );
    }
}
