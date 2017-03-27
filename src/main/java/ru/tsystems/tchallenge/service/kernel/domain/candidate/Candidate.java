package ru.tsystems.tchallenge.service.kernel.domain.candidate;

import ru.tsystems.tchallenge.service.kernel.domain.essay.Essay;
import ru.tsystems.tchallenge.service.kernel.domain.shared.Sequential;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.util.UUID;

@Entity
public class Candidate extends Sequential {

    @Column
    private String email;

    @Column
    private String login;

    @Column
    private String secretHash;

    @Column
    private String shortname;

    @OneToOne
    private Essay essay;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSecretHash() {
        return secretHash;
    }

    public void setSecretHash(String secretHash) {
        this.secretHash = secretHash;
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public Essay getEssay() {
        return essay;
    }

    public void setEssay(Essay essay) {
        this.essay = essay;
    }

    @Override
    protected void prePersist() {
        super.prePersist();
        secretHash = UUID.randomUUID().toString();
    }
}
