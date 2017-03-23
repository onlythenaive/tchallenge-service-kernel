package ru.tsystems.tchallenge.service.kernel.domain.solution;

import ru.tsystems.tchallenge.service.kernel.domain.shared.Sporadic;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class SolutionInput extends Sporadic {

    @Column
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
