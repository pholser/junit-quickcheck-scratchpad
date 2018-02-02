package com.pholser.junit.quickcheck.scratchpad.nested;

import java.time.LocalDate;
import java.util.HashMap;

import com.pholser.junit.quickcheck.generator.Size;

public class PerformanceHistory {
    private final HashMap<LocalDate, Integer> h1;
    private final HashMap<LocalDate, Integer> h2;

    public PerformanceHistory(
        @Size(min = 1, max = 5) HashMap<LocalDate, Integer> h1,
        @Size(min = 1, max = 5) HashMap<LocalDate, Integer> h2) {

        this.h1 = h1;
        this.h2 = h2;
    }

    public boolean empty() {
        return h1.isEmpty() && h2.isEmpty();
    }
}