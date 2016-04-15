package com.pholser.junit.quickcheck.scratchpad.model.tree.visitor;

import java.util.ArrayList;
import java.util.List;

import com.pholser.junit.quickcheck.scratchpad.model.tree.Empty;
import com.pholser.junit.quickcheck.scratchpad.model.tree.Leaf;
import com.pholser.junit.quickcheck.scratchpad.model.tree.Node;
import com.pholser.junit.quickcheck.scratchpad.model.tree.TreeVisitor;

import static java.lang.System.*;
import static java.util.Collections.*;
import static java.util.stream.Collectors.*;

public class TreeStructureVisitor implements TreeVisitor {
    private final List<String> lines = new ArrayList<>();

    private int depth;

    @Override public Void visit(Empty empty) {
        addLine("Empty");

        --depth;
        return null;
    }

    @Override public Void visit(Leaf leaf) {
        addLine("Leaf");

        --depth;
        return null;
    }

    @Override public Void visit(Node node) {
        addLine("Node");

        ++depth;
        node.left().accept(this);

        ++depth;
        node.right().accept(this);

        --depth;
        return null;
    }

    @Override public String toString() {
        return lines.stream().collect(joining(getProperty("line.separator")));
    }

    private void addLine(String label) {
        lines.add(repeat(" ", depth * 2) + label + ':' + String.valueOf(depth));
    }

    private static String repeat(String s, int times) {
        return nCopies(times, s).stream().collect(joining());
    }
}
