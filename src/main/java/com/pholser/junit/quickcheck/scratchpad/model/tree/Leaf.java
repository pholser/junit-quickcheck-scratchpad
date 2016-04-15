package com.pholser.junit.quickcheck.scratchpad.model.tree;

public class Leaf implements Tree {
    private final String value;

    public Leaf(String value) {
        this.value = value;
    }

    @Override public Object accept(TreeVisitor visitor) {
        return visitor.visit(this);
    }

    public String value() {
        return value;
    }
}
