package com.pholser.junit.quickcheck.scratchpad.regex;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import com.pholser.junit.quickcheck.scratchpad.regex.Structured.Matching;
import org.junit.runner.RunWith;

@RunWith(JUnitQuickcheck.class)
public class SSNTest {
    @Property public void wellFormedSSN(@Matching("\\d{3}-\\d{2}-\\d{4}") String ssn) {
        System.out.println(ssn);
    }
}
