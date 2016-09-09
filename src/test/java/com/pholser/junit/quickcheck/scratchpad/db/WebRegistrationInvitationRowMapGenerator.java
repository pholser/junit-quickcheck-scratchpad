package com.pholser.junit.quickcheck.scratchpad.db;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;

public class WebRegistrationInvitationRowMapGenerator extends Generator<Map> {
    private Map<String, Generator<?>> COLUMN_NAME_MAP;

    public WebRegistrationInvitationRowMapGenerator() {
        super(Map.class);
    }

    private void initColumnNames() {
        if (COLUMN_NAME_MAP == null) {
            COLUMN_NAME_MAP = new HashMap<>();
            COLUMN_NAME_MAP.put("UUID", gen().type(UUID.class));
            COLUMN_NAME_MAP.put("CREATE_DTS", gen().type(Date.class));
            COLUMN_NAME_MAP.put("EMPI", gen().type(BigDecimal.class));
            COLUMN_NAME_MAP.put("EMAIL", gen().type(String.class));
            COLUMN_NAME_MAP.put("ATTEMPTS", gen().type(BigDecimal.class));
            COLUMN_NAME_MAP.put("TRANSACTION_STS", gen().type(InvitationRegistrationStatus.class));
            COLUMN_NAME_MAP.put("UPDATED_DTS", gen().type(Date.class));
            COLUMN_NAME_MAP.put("RESENT_DTS", gen().type(Date.class));
            COLUMN_NAME_MAP.put("RESENT_USER_ID", gen().type(String.class));
            COLUMN_NAME_MAP.put("ERROR_CD", gen().type(String.class));
            COLUMN_NAME_MAP.put("ERROR_MSG", gen().type(String.class));
            COLUMN_NAME_MAP.put("USER_ID", gen().type(String.class));
        }
    }

    @Override
    public Map<String, Object> generate(SourceOfRandomness random, GenerationStatus status) {
        initColumnNames();

        Map<String, Object> results = new HashMap<>();
        for (Map.Entry<String, Generator<?>> entry : COLUMN_NAME_MAP.entrySet()) {
            Object value = entry.getValue().generate(random, status);
            String key = entry.getKey();
            if ("UUID".equals(key) || "TRANSACTION_STS".equals(key)) {
                value = value.toString();
            }

            results.put(key, value);
        }

        return results;
    }
}
