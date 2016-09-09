package com.pholser.junit.quickcheck.scratchpad.db;

import java.util.List;
import java.util.Map;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;

public class RegExpirationJobDataGenerator extends Generator<RegExpirationJobData> {
    private static List<@From(WebRegistrationInvitationRowMapGenerator.class) Map<String, Object>> TYPE;

    public RegExpirationJobDataGenerator() {
        super(RegExpirationJobData.class);
    }

    @Override
    public RegExpirationJobData generate(SourceOfRandomness random, GenerationStatus status) {
        Generator<List<Map<String, Object>>> rowsGen =
            (Generator<List<Map<String, Object>>>) gen().field(getClass(), "TYPE");
        return new RegExpirationJobData(rowsGen.generate(random, status));
    }
}
