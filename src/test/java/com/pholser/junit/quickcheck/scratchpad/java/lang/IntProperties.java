package com.pholser.junit.quickcheck.scratchpad.java.lang;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

@RunWith(JUnitQuickcheck.class)
public class IntProperties {
    @Property public void positivity(@Positive int i) {
        assertThat(i, greaterThan(0));
    }
}
