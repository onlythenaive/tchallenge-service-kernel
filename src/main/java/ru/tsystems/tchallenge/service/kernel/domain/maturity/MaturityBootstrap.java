package ru.tsystems.tchallenge.service.kernel.domain.maturity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Lazy(false)
public class MaturityBootstrap {

    @Autowired
    private MaturityRepository maturityRepository;

    @PostConstruct
    public void init() {
        maturityRepository.save(maturity("STUDENT", "Студент, начало карьеры"));
    }

    private Maturity maturity(String id, String title) {
        Maturity maturity = new Maturity();
        maturity.setId(id);
        maturity.setTitle(title);
        return maturity;
    }
}
