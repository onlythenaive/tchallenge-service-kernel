package ru.tsystems.tchallenge.service.kernel.domain.admission;

import ru.tsystems.tchallenge.service.kernel.domain.essay.EssayProperties;

public class AdmissionProperties {

    private String shortname;
    private String email;
    private String forum;
    private String maturity;
    private String specialization;
    private EssayProperties essay;
    private Boolean challengeRequested;
    private Boolean essayProvided;

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getForum() {
        return forum;
    }

    public void setForum(String forum) {
        this.forum = forum;
    }

    public String getMaturity() {
        return maturity;
    }

    public void setMaturity(String maturity) {
        this.maturity = maturity;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public EssayProperties getEssay() {
        return essay;
    }

    public void setEssay(EssayProperties essay) {
        this.essay = essay;
    }

    public Boolean getChallengeRequested() {
        return challengeRequested;
    }

    public void setChallengeRequested(Boolean challengeRequested) {
        this.challengeRequested = challengeRequested;
    }

    public Boolean getEssayProvided() {
        return essayProvided;
    }

    public void setEssayProvided(Boolean essayProvided) {
        this.essayProvided = essayProvided;
    }
}
