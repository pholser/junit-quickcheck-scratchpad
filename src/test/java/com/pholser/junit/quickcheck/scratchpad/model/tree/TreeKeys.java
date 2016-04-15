package com.pholser.junit.quickcheck.scratchpad.model.tree;

import com.pholser.junit.quickcheck.generator.GenerationStatus;

final class TreeKeys {
    static final GenerationStatus.Key<Integer> DEPTH =
        new GenerationStatus.Key<>("depth", Integer.class);

    private TreeKeys() {
        throw new UnsupportedOperationException();
    }
}
