package ru.tsystems.tchallenge.service.kernel.domain.snippet;

import ru.tsystems.tchallenge.service.kernel.domain.shared.Sporadic;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Snippet extends Sporadic {

    @Column
    private Integer lineup;

    public Integer getLineup() {
        return lineup;
    }

    public void setLineup(Integer lineup) {
        this.lineup = lineup;
    }
}
