package ru.tsystems.tchallenge.service.kernel.domain.essay;

import ru.tsystems.tchallenge.service.kernel.domain.shared.Sporadic;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Essay extends Sporadic {

    @Column
    private String firstname;

    @Column
    private String lastname;

    @Column
    private String linkedin;

    @Column
    private String portfolio;

    @Column
    private String website;

    @Column
    private String github;

    @Column
    private String bitbucket;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

    public String getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(String portfolio) {
        this.portfolio = portfolio;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }

    public String getBitbucket() {
        return bitbucket;
    }

    public void setBitbucket(String bitbucket) {
        this.bitbucket = bitbucket;
    }
}
