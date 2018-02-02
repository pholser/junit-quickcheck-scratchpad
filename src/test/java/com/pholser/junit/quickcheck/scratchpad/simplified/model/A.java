package com.pholser.junit.quickcheck.scratchpad.simplified.model;

import java.util.List;

public class A {
    private final String someString;
    private final int someInt;
    private List<B> listOfB;

    public A(String someString, int someInt) {
        this.someString = someString;
        this.someInt = someInt;
    }

    public void setListOfB(List<B> listOfB) {
        this.listOfB = listOfB;
    }
}
