package com.pholser.junit.quickcheck.scratchpad.java.lang;

import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;

import static java.util.Arrays.*;

public class MakeInts extends Generator<Integer> {
    public MakeInts() {
        super(asList(Integer.class, int.class));
    }

    private Positive positive;

    @Override public Integer generate(
        SourceOfRandomness random,
        GenerationStatus status) {

        int value = random.nextInt();
        return positive != null ? Math.abs(value) : value;
    }

    public void configure(Positive positive) {
        this.positive = positive;
    }
}
