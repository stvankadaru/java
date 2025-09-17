package com.comparator;

import java.util.Comparator;

public class NameComparator implements Comparator<Products> {
    @Override
    public int compare(Products p1, Products p2) {
        return p1.name.compareTo(p2.name);
    }
}
