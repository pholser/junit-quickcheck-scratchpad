package com.pholser.junit.quickcheck.scratchpad.model.tree;

import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;

public class NodeGenerator extends Generator<Node> {
    public NodeGenerator() {
        super(Node.class);
    }

    @Override public Node generate(SourceOfRandomness random, GenerationStatus status) {
        int depth = status.getValue(TreeKeys.DEPTH);

        if (depth == 1) {
            Generator<Tree> leafOrEmpty = gen().oneOf(Leaf.class, Empty.class);
            return new Node(
                leafOrEmpty.generate(random, status),
                leafOrEmpty.generate(random, status)
            );
        }

        Generator<Tree> subtree = gen().oneOf(Node.class, Leaf.class, Empty.class);
        status.setValue(TreeKeys.DEPTH, depth - 1);
        return new Node(
            subtree.generate(random, status),
            subtree.generate(random, status)
        );
    }

    @Override public boolean canRegisterAsType(Class<?> type) {
        return Tree.class.isAssignableFrom(type);
    }
}
