package com.pholser.junit.quickcheck.scratchpad.model.tree;

import com.pholser.junit.quickcheck.scratchpad.model.tree.visitor.TreeStructureVisitor;

public class Empty implements Tree {
    @Override public Object accept(TreeVisitor visitor) {
        return visitor.visit(this);
    }

    @Override public String toString() {
        TreeStructureVisitor v = new TreeStructureVisitor();
        accept(v);
        return v.toString();
    }
}
