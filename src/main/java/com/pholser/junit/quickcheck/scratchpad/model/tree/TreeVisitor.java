package com.pholser.junit.quickcheck.scratchpad.model.tree;

public interface TreeVisitor {
    Object visit(Empty empty);

    Object visit(Leaf leaf);

    Object visit(Node node);
}
