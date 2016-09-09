package com.pholser.junit.quickcheck.scratchpad.db;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(JUnitQuickcheck.class)
public class RegExpirationJobs {
    @Property public void aProp(RegExpirationJobData data) {
        assertTrue(true);
    }
}
