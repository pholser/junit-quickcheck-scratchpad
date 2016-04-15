package com.pholser.junit.quickcheck.scratchpad.model.tree;

import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;

public class EmptyGenerator extends Generator<Empty> {
    public EmptyGenerator() {
        super(Empty.class);
    }

    @Override public Empty generate(SourceOfRandomness random, GenerationStatus status) {
        return new Empty();
    }

    @Override public boolean canRegisterAsType(Class<?> type) {
        return Tree.class.isAssignableFrom(type);
    }
}
