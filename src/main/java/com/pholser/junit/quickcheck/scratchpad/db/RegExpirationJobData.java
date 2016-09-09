package com.pholser.junit.quickcheck.scratchpad.db;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.common.base.MoreObjects;

import static java.util.stream.Collectors.*;

public class RegExpirationJobData {
    private final List<Map<String, Object>> oneDayInvites;
    private final List<BigDecimal> mmis;

    public RegExpirationJobData(List<Map<String, Object>> oneDayInvites) {
        this.oneDayInvites = oneDayInvites;
        mmis = new ArrayList<>(
            oneDayInvites.stream()
                .map(i -> (BigDecimal) i.get("EMPI"))
                .collect(toList()));
    }

    public List<Map<String, Object>> getOneDayInvites() {
        return oneDayInvites;
    }

    public List<BigDecimal> getMmis() {
        return mmis;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(getClass())
            .add("oneDayInvites", oneDayInvites)
            .add("mmis", mmis)
            .toString();
    }
}
