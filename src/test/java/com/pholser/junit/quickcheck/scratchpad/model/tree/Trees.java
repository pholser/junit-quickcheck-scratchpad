package com.pholser.junit.quickcheck.scratchpad.model.tree;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import com.pholser.junit.quickcheck.scratchpad.model.tree.visitor.TreeStructureVisitor;
import org.junit.runner.RunWith;

@RunWith(JUnitQuickcheck.class)
public class Trees {
    @Property public void x(@From(TreeMaker.class) Tree t) {
        TreeStructureVisitor visitor = new TreeStructureVisitor();
        t.accept(visitor);

        System.out.println(visitor);
        System.out.println("=====");
    }
}
