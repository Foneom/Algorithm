package com.foneom.funcinterface;

import java.util.function.Predicate;

public class PredicateTest {
    public static void main(String[] args) {
        Predicate<Integer> predicate = x -> x > 0;
        System.out.println(predicate.test(-9));
    }
}
