package com.pholser.junit.quickcheck.scratchpad.nested;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.Ctor;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(JUnitQuickcheck.class)
public class PerformanceHistoryProperties {
    @Property(trials = 10) public void notEmpty(PerformanceHistory h) {
        assertFalse(h.empty());
    }

    @Property(trials = 10) public void alsoNotEmpty(
        @From(Ctor.class) PerformanceHistory h) {

        assertFalse(h.empty());
    }
}
