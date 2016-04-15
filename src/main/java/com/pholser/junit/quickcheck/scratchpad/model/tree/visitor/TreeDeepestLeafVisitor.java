package com.pholser.junit.quickcheck.scratchpad.model.tree.visitor;

import java.util.AbstractMap;

import com.pholser.junit.quickcheck.scratchpad.model.tree.Empty;
import com.pholser.junit.quickcheck.scratchpad.model.tree.Leaf;
import com.pholser.junit.quickcheck.scratchpad.model.tree.Node;
import com.pholser.junit.quickcheck.scratchpad.model.tree.TreeVisitor;

public class TreeDeepestLeafVisitor implements TreeVisitor {
    @Override public AbstractMap.SimpleImmutableEntry<String, Integer> visit(Empty empty) {
        return new AbstractMap.SimpleImmutableEntry<>("", 0);
    }

    @Override public AbstractMap.SimpleImmutableEntry<String, Integer> visit(Leaf leaf) {
        return new AbstractMap.SimpleImmutableEntry<>(leaf.value(), 1);
    }

    @Override
    public AbstractMap.SimpleImmutableEntry<String, Integer> visit(Node node) {
        @SuppressWarnings("unchecked")
        AbstractMap.SimpleImmutableEntry<String, Integer> leftResult =
            (AbstractMap.SimpleImmutableEntry<String, Integer>) node.left().accept(this);

        @SuppressWarnings("unchecked")
        AbstractMap.SimpleImmutableEntry<String, Integer> rightResult =
            (AbstractMap.SimpleImmutableEntry<String, Integer>) node.right().accept(this);

        int leftDepth = leftResult.getValue();
        int rightDepth = rightResult.getValue();
        return leftDepth >= rightDepth
            ? new AbstractMap.SimpleImmutableEntry<>(leftResult.getKey(), 1 + leftDepth)
            : new AbstractMap.SimpleImmutableEntry<>(rightResult.getKey(), 1 + rightDepth);
    }
}
