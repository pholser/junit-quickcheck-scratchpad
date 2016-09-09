package com.pholser.junit.quickcheck.scratchpad.db;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.runner.RunWith;

@RunWith(JUnitQuickcheck.class)
public class RegExpirationJobsTest {
    @Property public void aProp(RegExpirationJobData data) {
        System.out.println(data);
    }
}
