package ru.tsystems.tchallenge.service.kernel.domain.shared;

import ru.tsystems.tchallenge.service.kernel.utility.Convertions;

import java.time.Instant;

public abstract class Mapper {

    protected Boolean flag(Integer flag) {
        return Convertions.flag(flag);
    }

    protected Integer flag(Boolean flag) {
        return Convertions.flag(flag);
    }

    protected String timestamp(Instant instant) {
        return Convertions.timestamp(instant);
    }
}
