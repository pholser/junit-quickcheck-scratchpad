package com.pholser.junit.quickcheck.scratchpad.regex;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import com.mifmif.common.regex.Generex;
import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.generator.GeneratorConfiguration;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

public class Structured extends Generator<String> {
    private Matching matching;

    public Structured() {
        super(String.class);
    }

    @Override public String generate(
        SourceOfRandomness random,
        GenerationStatus status) {

        Generex regex = new Generex(
                matching != null ? matching.value() : ".*",
                random.toJDKRandom());
        return regex.random(0, status.size());
    }

    public void configure(Matching matching) {
        this.matching = matching;
    }

    @Target({ PARAMETER, FIELD, ANNOTATION_TYPE, TYPE_USE })
    @Retention(RUNTIME)
    @GeneratorConfiguration
    public @interface Matching {
        String value();
    }
}
