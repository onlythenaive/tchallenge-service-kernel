package ru.tsystems.tchallenge.service.kernel.domain.solution;

import ru.tsystems.tchallenge.service.kernel.domain.shared.Sporadic;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class SolutionOption extends Sporadic {

    @Column
    private String textcode;

    @Column
    private String content;

    @Column
    private Integer correct;

    public String getTextcode() {
        return textcode;
    }

    public void setTextcode(String textcode) {
        this.textcode = textcode;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getCorrect() {
        return correct;
    }

    public void setCorrect(Integer correct) {
        this.correct = correct;
    }
}
