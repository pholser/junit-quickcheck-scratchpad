package com.pholser.junit.quickcheck.scratchpad.nested;

import java.time.LocalDate;
import java.util.HashMap;

import com.pholser.junit.quickcheck.generator.Gen;
import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;

public class PerformanceHistoryGenerator extends Generator<PerformanceHistory> {
    public PerformanceHistoryGenerator() {
        super(PerformanceHistory.class);
    }

    @SuppressWarnings("unchecked")
    @Override
    public PerformanceHistory generate(
        SourceOfRandomness random,
        GenerationStatus status) {

        Gen<HashMap> maps =
            gen().type(HashMap.class, LocalDate.class, Integer.class)
                .filter(m -> !m.isEmpty());

        return new PerformanceHistory(
            maps.generate(random, status),
            maps.generate(random, status));
    }
}
