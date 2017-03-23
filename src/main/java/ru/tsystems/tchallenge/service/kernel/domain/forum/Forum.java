package ru.tsystems.tchallenge.service.kernel.domain.forum;

import ru.tsystems.tchallenge.service.kernel.domain.maturity.Maturity;
import ru.tsystems.tchallenge.service.kernel.domain.shared.Sequential;
import ru.tsystems.tchallenge.service.kernel.domain.specialization.Specialization;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Forum extends Sequential {

    @Column
    private String textcode;

    @Column
    private String title;

    @Column
    private String description;

    @Column
    private String introduction;

    @ManyToMany
    private Collection<Maturity> maturities = new ArrayList<>();

    @ManyToMany
    private Collection<Specialization> specializations = new ArrayList<>();

    @Column
    private Instant since;

    @Column
    private Instant until;

    public String getTextcode() {
        return textcode;
    }

    public void setTextcode(String textcode) {
        this.textcode = textcode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public Collection<Maturity> getMaturities() {
        return maturities;
    }

    public Collection<Specialization> getSpecializations() {
        return specializations;
    }

    public Instant getSince() {
        return since;
    }

    public void setSince(Instant since) {
        this.since = since;
    }

    public Instant getUntil() {
        return until;
    }

    public void setUntil(Instant until) {
        this.until = until;
    }
}
