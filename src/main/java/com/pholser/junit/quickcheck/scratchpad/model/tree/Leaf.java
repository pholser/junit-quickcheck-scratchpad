package com.pholser.junit.quickcheck.scratchpad.model.tree;

import com.pholser.junit.quickcheck.scratchpad.model.tree.visitor.TreeStructureVisitor;

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

    @Override public String toString() {
        TreeStructureVisitor v = new TreeStructureVisitor();
        accept(v);
        return v.toString();
    }
}
