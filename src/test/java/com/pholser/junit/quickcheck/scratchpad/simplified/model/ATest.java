package com.pholser.junit.quickcheck.scratchpad.simplified.model;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.runner.RunWith;

@RunWith(JUnitQuickcheck.class)
public class ATest {
    @Property public void test(@From(AGenerator.class) A a) {
        System.out.println(a);
    }
}
