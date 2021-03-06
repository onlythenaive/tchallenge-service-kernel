package ru.tsystems.tchallenge.service.kernel.domain.admission;

import ru.tsystems.tchallenge.service.kernel.domain.essay.Essay;
import ru.tsystems.tchallenge.service.kernel.domain.forum.Forum;
import ru.tsystems.tchallenge.service.kernel.domain.maturity.Maturity;
import ru.tsystems.tchallenge.service.kernel.domain.shared.Sporadic;
import ru.tsystems.tchallenge.service.kernel.domain.specialization.Specialization;

import javax.persistence.*;

@Entity
public class Admission extends Sporadic {

    @Column
    private String email;

    @Column
    private String shortname;

    @ManyToOne
    private Forum forum;

    @ManyToOne
    private Maturity maturity;

    @ManyToOne
    private Specialization specialization;

    @OneToOne(cascade = CascadeType.ALL)
    private Essay essay;

    @Column
    private Integer challengeRequested;

    @Column
    private Integer essayProvided;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public Forum getForum() {
        return forum;
    }

    public void setForum(Forum forum) {
        this.forum = forum;
    }

    public Maturity getMaturity() {
        return maturity;
    }

    public void setMaturity(Maturity maturity) {
        this.maturity = maturity;
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }

    public Essay getEssay() {
        return essay;
    }

    public void setEssay(Essay essay) {
        this.essay = essay;
    }

    public Integer getChallengeRequested() {
        return challengeRequested;
    }

    public void setChallengeRequested(Integer challengeRequested) {
        this.challengeRequested = challengeRequested;
    }

    public Integer getEssayProvided() {
        return essayProvided;
    }

    public void setEssayProvided(Integer essayProvided) {
        this.essayProvided = essayProvided;
    }
}
