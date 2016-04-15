package com.pholser.junit.quickcheck.scratchpad.model.tree;

import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;

import static com.pholser.junit.quickcheck.scratchpad.model.tree.TreeKeys.*;

public class TreeMaker extends Generator<Tree> {
    public TreeMaker() {
        super(Tree.class);
    }

    @Override public Tree generate(SourceOfRandomness random, GenerationStatus status) {
        int depth = status.size() / 2;
        switch (depth) {
            case 0:
                return gen().type(Empty.class).generate(random, status);
            case 1:
                return gen().type(Leaf.class).generate(random, status);
            default:
                status.setValue(DEPTH, depth);
                return gen().type(Node.class).generate(random, status);
        }
    }

    @Override public boolean canRegisterAsType(Class<?> type) {
        return false;
    }
}
