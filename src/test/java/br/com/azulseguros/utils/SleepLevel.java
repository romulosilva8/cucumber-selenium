package br.com.azulseguros.utils;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public enum SleepLevel {
    TARTARUGA(20000),
    SUPERLENTO(10000),
    LENTO(8000),
    NORMAL(5000),
    RAPIDO(3000),
    SUPERRAPIDO(2000),
    SUPERSONICO(1000);

    private long value;

    SleepLevel(long level) {
        this.value = level;
    }

    public Duration getValue(TimeUnit timeUnit) {
        switch (timeUnit) {
            case SECONDS:
                return Duration.ofSeconds(value/1000);
            case MILLISECONDS:
            default:
                return Duration.ofMillis(value);
        }
    }

}
