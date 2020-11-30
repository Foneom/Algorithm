package com.foneom.recursion;

import com.foneom.collections.tree.Tree;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Summ {

    public int sum(int n) {
        int tmp = 0;
        if (n > 0) {
            tmp = n + sum(n - 1);
        }
        return tmp;
    }

    public static void main(String[] args) {
    }
}
