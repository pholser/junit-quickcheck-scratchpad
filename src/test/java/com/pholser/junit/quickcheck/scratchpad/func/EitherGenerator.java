package com.pholser.junit.quickcheck.scratchpad.func;

import java.util.List;
import java.util.stream.Collectors;

import com.pholser.junit.quickcheck.generator.ComponentizedGenerator;
import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;

public class EitherGenerator extends ComponentizedGenerator<Either> {
    public EitherGenerator() {
        super(Either.class);
    }

    @Override public Either<?, ?> generate(
        SourceOfRandomness random,
        GenerationStatus status) {

        return random.nextBoolean()
            ? Either.makeLeft(componentGenerators().get(0).generate(random, status))
            : Either.makeRight(componentGenerators().get(1).generate(random, status));
    }

    @Override public List<Either> doShrink(
        SourceOfRandomness random,
        Either larger) {

        @SuppressWarnings("unchecked")
        Either<Object, Object> either = (Either<Object, Object>) larger;

        return either.map(
            left -> componentGenerators().get(0).shrink(random, left)
                .stream()
                .map(Either::makeLeft)
                .collect(Collectors.toList()),
            right -> componentGenerators().get(1).shrink(random, right)
                .stream()
                .map(Either::makeRight)
                .collect(Collectors.toList()));
    }

    @Override public int numberOfNeededComponents() {
        return 2;
    }
}
