package com.pholser.junit.quickcheck.scratchpad.nested;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(JUnitQuickcheck.class)
public class PerformanceHistoryProperties {
    @Property(trials = 10) public void notEmpty(PerformanceHistory h) {
        assertFalse(h.empty());
    }
}
