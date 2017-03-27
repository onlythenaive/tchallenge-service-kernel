package ru.tsystems.tchallenge.service.kernel.domain.admission;

import java.time.Instant;

public class AdmissionInfo {

    private String id;
    private String shortname;
    private String email;
    private String forum;
    private Boolean challengeRequested;
    private Boolean essayProvided;
    private String createdAt;
    private String resolution;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
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

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }
}
