package com.pholser.junit.quickcheck.scratchpad.simplified.model;

import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;

public class BGenerator extends Generator<B> {
    public BGenerator() {
        super(B.class);
    }

    @Override
    public B generate(SourceOfRandomness random, GenerationStatus status) {
        String someString = gen().type(String.class).generate(random, status);
        int someInt = gen().type(int.class).generate(random, status);

        return new B(someString, someInt);
    }
}
