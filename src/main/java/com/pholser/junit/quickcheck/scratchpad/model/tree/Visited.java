package com.pholser.junit.quickcheck.scratchpad.model.tree;

public interface Visited<V> {
    Object accept(V visitor);
}
