package ru.tsystems.tchallenge.service.kernel.domain.shared;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import java.time.Instant;
import java.util.UUID;

@MappedSuperclass
public abstract class Sporadic {

    @Id
    @Column
    private String id;

    @Column
    private Instant createdAt;

    public String getId() {
        return id;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    @PrePersist
    protected void prePersist() {
        id = UUID.randomUUID().toString();
        createdAt = Instant.now();
    }
}
