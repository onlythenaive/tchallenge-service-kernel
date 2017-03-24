package ru.tsystems.tchallenge.service.kernel.utility;

import java.time.Instant;

public final class Convertions {

    public static String timestamp(Instant instant) {
        return instant.toString();
    }

    public static Boolean flag(Integer flag) {
        return flag != null && flag != 0;
    }

    public static Integer flag(Boolean flag) {
        return (flag != null && flag) ? 1 : 0;
    }

    private Convertions() {

    }
}
