package com.pholser.junit.quickcheck.scratchpad.nested;

import java.time.LocalDate;
import java.util.HashMap;

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

        Generator<HashMap> maps =
            gen().type(HashMap.class, LocalDate.class, Integer.class);
        Generator<LocalDate> dates = gen().type(LocalDate.class);
        Generator<Integer> ints = gen().type(Integer.class);

        HashMap<LocalDate, Integer> map1 = maps.generate(random, status);
        HashMap<LocalDate, Integer> map2 = maps.generate(random, status);
        map1.put(
            dates.generate(random, status),
            ints.generate(random, status));
        map2.put(
            dates.generate(random, status),
            ints.generate(random, status));

        return new PerformanceHistory(map1, map2);
    }
}
