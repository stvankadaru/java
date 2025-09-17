package com.comparator;

import java.util.Comparator;

public class RatingComparator implements Comparator<Products> {
    @Override
    public int compare(Products p1, Products p2) {
        return Double.compare(p2.rating, p1.rating); // Descending order
    }
}
