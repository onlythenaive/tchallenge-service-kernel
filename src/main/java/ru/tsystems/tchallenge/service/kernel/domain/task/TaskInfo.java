package ru.tsystems.tchallenge.service.kernel.domain.task;

import ru.tsystems.tchallenge.service.kernel.domain.solution.SolutionOptionInfo;

import java.util.Collection;

public class TaskInfo {

    private String title;
    private String introduction;
    private String question;
    private Collection<SolutionOptionInfo> solutionOptions;
    private Collection<String> categories;
    private Integer complexity;
    private String difficulty;
    private String expectation;

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

    public Collection<SolutionOptionInfo> getSolutionOptions() {
        return solutionOptions;
    }

    public void setSolutionOptions(Collection<SolutionOptionInfo> solutionOptions) {
        this.solutionOptions = solutionOptions;
    }

    public Collection<String> getCategories() {
        return categories;
    }

    public void setCategories(Collection<String> categories) {
        this.categories = categories;
    }

    public Integer getComplexity() {
        return complexity;
    }

    public void setComplexity(Integer complexity) {
        this.complexity = complexity;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getExpectation() {
        return expectation;
    }

    public void setExpectation(String expectation) {
        this.expectation = expectation;
    }
}
