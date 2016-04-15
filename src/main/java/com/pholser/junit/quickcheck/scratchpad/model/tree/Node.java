package com.pholser.junit.quickcheck.scratchpad.model.tree;

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
}
