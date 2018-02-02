package com.pholser.junit.quickcheck.scratchpad.simplified.model;

import java.util.List;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.generator.java.util.ArrayListGenerator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;

public class AGenerator extends Generator<A> {
    private static final List<@From(BGenerator.class) B> LIST_OF_B = null;

    public AGenerator() {
        super(A.class);
    }

    @SuppressWarnings("unchecked")
    private Generator<List<B>> listOfB() {
        try {
            return (Generator<List<B>>) gen().field(getClass().getDeclaredField("LIST_OF_B"));
        } catch (NoSuchFieldException e) {
            throw new AssertionError(e);
        }
    }

    @Override
    public A generate(SourceOfRandomness random, GenerationStatus status) {
        String someString = gen().type(String.class).generate(random, status);
        int someInt = gen().type(int.class).generate(random, status);

        A a = new A(someString, someInt);

        a.setListOfB(listOfB().generate(random, status));
        return a;
    }
}
