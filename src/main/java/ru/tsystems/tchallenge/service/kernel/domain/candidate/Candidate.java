package ru.tsystems.tchallenge.service.kernel.domain.candidate;

import ru.tsystems.tchallenge.service.kernel.domain.shared.Sequential;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Candidate extends Sequential {

    @Column
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
