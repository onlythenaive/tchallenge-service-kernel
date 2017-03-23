package ru.tsystems.tchallenge.service.kernel.domain.expectation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Lazy(false)
public class ExpectationBootstrap {

    @Autowired
    private ExpectationRepository expectationRepository;

    @PostConstruct
    public void init() {
        expectationRepository.save(expectation("SINGLESELECT", "Выбор единственного правильного решения"));
        expectationRepository.save(expectation("MULTISELECT", "Выбор нескольких правильных решений"));
        expectationRepository.save(expectation("SMALLINPUT", "Написание открытого решения"));
    }

    private Expectation expectation(String id, String title) {
        Expectation expectation = new Expectation();
        expectation.setId(id);
        expectation.setTitle(title);
        return expectation;
    }
}
