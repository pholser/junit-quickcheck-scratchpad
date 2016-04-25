package com.pholser.junit.quickcheck.scratchpad.model.tree;

import com.pholser.junit.quickcheck.scratchpad.model.tree.visitor.TreeStructureVisitor;

public class Node implements Tree {
    private final Tree left;
    private final Tree right;

    public Node(Tree left, Tree right) {
        this.left = left;
        this.right = right;
    }

    @Override public Object accept(TreeVisitor visitor) {
        return visitor.visit(this);
    }

    public Tree left() {
        return left;
    }

    public Tree right() {
        return right;
    }

    @Override public String toString() {
        TreeStructureVisitor v = new TreeStructureVisitor();
        accept(v);
        return v.toString();
    }
}
