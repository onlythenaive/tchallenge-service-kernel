package ru.tsystems.tchallenge.service.kernel.domain.specialization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Lazy(false)
public class SpecializationBootstrap {

    @Autowired
    private SpecializationRepository specializationRepository;

    @PostConstruct
    public void init() {
        specializationRepository.save(specialization("JAVADEV", "Разработчик Java"));
        specializationRepository.save(specialization("TESTER", "Инженер-тестировщик"));
    }

    private Specialization specialization(String id, String title) {
        Specialization specialization = new Specialization();
        specialization.setId(id);
        specialization.setTitle(title);
        return specialization;
    }
}
