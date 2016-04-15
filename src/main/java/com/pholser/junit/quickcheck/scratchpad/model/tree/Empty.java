package com.pholser.junit.quickcheck.scratchpad.model.tree;

public class Empty implements Tree {
    @Override public Object accept(TreeVisitor visitor) {
        return visitor.visit(this);
    }
}
