package ru.tsystems.tchallenge.service.kernel.domain.forum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import ru.tsystems.tchallenge.service.kernel.domain.maturity.Maturity;
import ru.tsystems.tchallenge.service.kernel.domain.maturity.MaturityBootstrap;
import ru.tsystems.tchallenge.service.kernel.domain.maturity.MaturityRepository;
import ru.tsystems.tchallenge.service.kernel.domain.specialization.Specialization;
import ru.tsystems.tchallenge.service.kernel.domain.specialization.SpecializationBootstrap;
import ru.tsystems.tchallenge.service.kernel.domain.specialization.SpecializationRepository;

import javax.annotation.PostConstruct;
import java.time.Instant;

@Component
@Lazy(false)
public class ForumBootstrap {

    @Autowired
    private SpecializationBootstrap specializationBootstrap;

    @Autowired
    private MaturityBootstrap maturityBootstrap;

    @Autowired
    private ForumRepository forumRepository;

    @Autowired
    private SpecializationRepository specializationRepository;

    @Autowired
    private MaturityRepository maturityRepository;

    @PostConstruct
    public void init() {
        forumRepository.save(joker2016());
        forumRepository.save(it2017());
    }

    private Forum joker2016() {
        Forum forum = new Forum();
        forum.setTextcode("joker2016");
        forum.setTitle("Joker 2016");
        forum.setDescription("Для гостей и участников конференции Joker 2016");
        forum.setIntroduction("Добро пожаловать на крупнейшую Java-конференцию в России!");
        forum.setSince(Instant.parse("2016-10-14T09:00:00.00Z"));
        forum.setUntil(Instant.parse("2016-10-14T17:30:00.00Z"));
        forum.getMaturities().add(maturity("STUDENT"));
        forum.getSpecializations().add(specialization("JAVADEV"));
        forum.getSpecializations().add(specialization("TESTER"));
        return forum;
    }

    private Forum it2017() {
        Forum forum = new Forum();
        forum.setTextcode("it2017");
        forum.setTitle("Найти IT 2017");
        forum.setDescription("Для гостей и участников конференции Найти IT 2017");
        forum.setIntroduction("Добро пожаловать на ежегодную конференцию для молодых специалистов и выпускников в IT-области.");
        forum.setSince(Instant.parse("2017-04-01T09:00:00.00Z"));
        forum.setUntil(Instant.parse("2017-04-01T17:30:00.00Z"));
        forum.getMaturities().add(maturity("STUDENT"));
        forum.getSpecializations().add(specialization("JAVADEV"));
        forum.getSpecializations().add(specialization("TESTER"));
        return forum;
    }

    private Maturity maturity(String id) {
        return maturityRepository.findOne(id);
    }

    private Specialization specialization(String id) {
        return specializationRepository.findOne(id);
    }
}
