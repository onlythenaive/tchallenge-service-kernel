package ru.tsystems.tchallenge.service.kernel.domain.task;

import ru.tsystems.tchallenge.service.kernel.domain.category.Category;
import ru.tsystems.tchallenge.service.kernel.domain.difficulty.Difficulty;
import ru.tsystems.tchallenge.service.kernel.domain.expectation.Expectation;
import ru.tsystems.tchallenge.service.kernel.domain.shared.Sequential;
import ru.tsystems.tchallenge.service.kernel.domain.snippet.Snippet;
import ru.tsystems.tchallenge.service.kernel.domain.solution.SolutionInput;
import ru.tsystems.tchallenge.service.kernel.domain.solution.SolutionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Task extends Sequential {

    @Column
    private String title;

    @Column
    private String introduction;

    @Column
    private String question;

    @OneToMany
    private Collection<Snippet> snippets = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    private Collection<SolutionOption> solutionOptions = new ArrayList<>();

    @OneToOne
    private SolutionInput solutionInput;

    @ManyToMany
    private Collection<Category> categories = new ArrayList<>();

    @Column
    private Integer complexity;

    @ManyToOne
    private Difficulty difficulty;

    @ManyToOne
    private Expectation expectation;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Collection<Snippet> getSnippets() {
        return snippets;
    }

    public Collection<SolutionOption> getSolutionOptions() {
        return solutionOptions;
    }

    public SolutionInput getSolutionInput() {
        return solutionInput;
    }

    public void setSolutionInput(SolutionInput solutionInput) {
        this.solutionInput = solutionInput;
    }

    public Collection<Category> getCategories() {
        return categories;
    }

    public Integer getComplexity() {
        return complexity;
    }

    public void setComplexity(Integer complexity) {
        this.complexity = complexity;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public Expectation getExpectation() {
        return expectation;
    }

    public void setExpectation(Expectation expectation) {
        this.expectation = expectation;
    }
}
