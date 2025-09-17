package com.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparatorSortingDemo {
    public static void main(String[] args) {
        List<Products> pr = new ArrayList<>();
        pr.add(new Products("Laptop", 50000, 5));
        pr.add(new Products("Phone", 20000, 3));
        pr.add(new Products("Tablet", 10000, 1));
        pr.add(new Products("Mouse", 500, 2));

        // Sort by name using NameComparator
        Collections.sort(pr, new NameComparator());

        System.out.println("Sorting by Name:");
        for (Products p : pr) {
            System.out.println(p);
        }

        // Optional: Sort by rating using RatingComparator
        Collections.sort(pr, new RatingComparator());

        System.out.println("\nSorting by Rating:");
        for (Products p : pr) {
            System.out.println(p);
        }
    }
}
