package ru.tsystems.tchallenge.service.kernel.domain.shared;

import javax.persistence.*;
import java.time.Instant;

@MappedSuperclass
public abstract class Sequential {

    @Id
    @GeneratedValue
    @Column
    private Long id;

    @Column
    private Instant createdAt;

    public Long getId() {
        return id;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    @PrePersist
    private void prePersist() {
        createdAt = Instant.now();
    }
}
