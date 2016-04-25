package com.pholser.junit.quickcheck.scratchpad.model.tree.visitor;

import com.pholser.junit.quickcheck.scratchpad.model.tree.Empty;
import com.pholser.junit.quickcheck.scratchpad.model.tree.Leaf;
import com.pholser.junit.quickcheck.scratchpad.model.tree.Node;
import com.pholser.junit.quickcheck.scratchpad.model.tree.TreeVisitor;

public class TreeDepthVisitor implements TreeVisitor {
    @Override public Integer visit(Empty empty) {
        return 0;
    }

    @Override public Integer visit(Leaf leaf) {
        return 0;
    }

    @Override public Integer visit(Node node) {
        Integer leftDepth = (Integer) node.left().accept(this);
        Integer rightDepth = (Integer) node.right().accept(this);
        return 1 + Math.max(leftDepth, rightDepth);
    }
}
