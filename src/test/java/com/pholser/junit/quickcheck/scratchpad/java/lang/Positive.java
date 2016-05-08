package com.pholser.junit.quickcheck.scratchpad.java.lang;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import com.pholser.junit.quickcheck.generator.GeneratorConfiguration;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

@Target({ ANNOTATION_TYPE, PARAMETER, FIELD, TYPE_USE })
@Retention(RUNTIME)
@GeneratorConfiguration
public @interface Positive {
}
