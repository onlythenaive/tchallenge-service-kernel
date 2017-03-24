package ru.tsystems.tchallenge.service.kernel.domain.resolution;

import ru.tsystems.tchallenge.service.kernel.domain.admission.Admission;
import ru.tsystems.tchallenge.service.kernel.domain.shared.Sporadic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import java.util.UUID;

@Entity
public class Resolution extends Sporadic {

    @Column
    private String secret;

    @OneToOne
    private Admission admission;

    public String getSecret() {
        return secret;
    }

    public Admission getAdmission() {
        return admission;
    }

    public void setAdmission(Admission admission) {
        this.admission = admission;
    }

    @PrePersist
    protected void prePersist() {
        super.prePersist();
        secret = UUID.randomUUID().toString();
    }
}
