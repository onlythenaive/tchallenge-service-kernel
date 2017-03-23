package ru.tsystems.tchallenge.service.kernel.domain.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import ru.tsystems.tchallenge.service.kernel.domain.category.Category;
import ru.tsystems.tchallenge.service.kernel.domain.category.CategoryBootstrap;
import ru.tsystems.tchallenge.service.kernel.domain.category.CategoryRepository;
import ru.tsystems.tchallenge.service.kernel.domain.difficulty.Difficulty;
import ru.tsystems.tchallenge.service.kernel.domain.difficulty.DifficultyBootstrap;
import ru.tsystems.tchallenge.service.kernel.domain.difficulty.DifficultyRepository;
import ru.tsystems.tchallenge.service.kernel.domain.expectation.Expectation;
import ru.tsystems.tchallenge.service.kernel.domain.expectation.ExpectationBootstrap;
import ru.tsystems.tchallenge.service.kernel.domain.expectation.ExpectationRepository;
import ru.tsystems.tchallenge.service.kernel.domain.solution.SolutionInput;
import ru.tsystems.tchallenge.service.kernel.domain.solution.SolutionOption;

import javax.annotation.PostConstruct;

@Component
@Lazy(false)
public class TaskBootstrap {

    @Autowired
    private ExpectationRepository expectationRepository;

    @Autowired
    private ExpectationBootstrap expectationBootstrap;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryBootstrap categoryBootstrap;

    @Autowired
    private DifficultyRepository difficultyRepository;

    @Autowired
    private DifficultyBootstrap difficultyBootstrap;

    @Autowired
    private TaskRepository taskRepository;

    @PostConstruct
    public void init() {
        taskRepository.save(task1());
    }

    private Task task1() {
        Task task = new Task();
        task.setTitle("Работа в Сиэттле.");
        task.setQuestion("Сколько нужно мойщиков окон, чтобы справиться с работой в Сиэттле?");
        task.setExpectation(expectation("SINGLESELECT"));
        task.getSolutionOptions().add(option("A", "Много", true));
        task.getSolutionOptions().add(option("B", "Очень много", false));
        task.getCategories().add(category("COMMON"));
        task.setDifficulty(difficulty("EASY"));
        task.setComplexity(3);
        return task;
    }

    private Category category(String id) {
        return categoryRepository.findOne(id);
    }

    private Difficulty difficulty(String id) {
        return difficultyRepository.findOne(id);
    }

    private Expectation expectation(String id) {
        return expectationRepository.findOne(id);
    }

    private SolutionInput input(String content) {
        SolutionInput input = new SolutionInput();
        input.setContent(content);
        return input;
    }

    private SolutionOption option(String textcode, String content, Boolean correct) {
        SolutionOption option = new SolutionOption();
        option.setTextcode(textcode);
        option.setContent(content);
        option.setCorrect(correct ? 1 : 0);
        return option;
    }
}
