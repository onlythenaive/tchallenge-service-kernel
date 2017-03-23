package ru.tsystems.tchallenge.service.kernel.domain.difficulty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Lazy(false)
public class DifficultyBootstrap {

    @Autowired
    private DifficultyRepository difficultyRepository;

    @PostConstruct
    public void init() {
        difficultyRepository.save(difficulty("ELEMENTARY", "Элементарно"));
        difficultyRepository.save(difficulty("EASY", "Простые задачи"));
    }

    private Difficulty difficulty(String id, String title) {
        Difficulty difficulty = new Difficulty();
        difficulty.setId(id);
        difficulty.setTitle(title);
        return difficulty;
    }
}
