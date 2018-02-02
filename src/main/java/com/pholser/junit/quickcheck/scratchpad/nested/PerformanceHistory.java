package com.pholser.junit.quickcheck.scratchpad.nested;

import java.time.LocalDate;
import java.util.HashMap;

public class PerformanceHistory {
    private final HashMap<LocalDate, Integer> h1;
    private final HashMap<LocalDate, Integer> h2;

    public PerformanceHistory(
        HashMap<LocalDate, Integer> h1,
        HashMap<LocalDate, Integer> h2) {

        this.h1 = h1;
        this.h2 = h2;
    }

    public boolean empty() {
        return h1.isEmpty() && h2.isEmpty();
    }
}