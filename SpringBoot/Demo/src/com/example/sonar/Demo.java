package com.example.sonar;

import java.util.ArrayList;
import java.util.List;

public class Demo {

    // Code smell: hardcoded credentials
    private static final String PASSWORD = "admin123";

    public static void main(String[] args) {
        System.out.println("SonarQube Demo Starting...");

        // Bug: possible division by zero
        int result = divide(10, 0);
        System.out.println("Result = " + result);

        // Code smell: unused variable
        String unused = "This variable is never used";

        // Code smell: empty catch block
        try {
            riskyMethod();
        } catch (Exception e) {
            // ignored
        }
    }

    public static int divide(int a, int b) {
        return a / b; // Potential bug: ArithmeticException
    }

    public static void riskyMethod() throws Exception {
        List<String> list = new ArrayList<>();
        list.add("hello");
        list.get(5); // Bug: IndexOutOfBoundsException
    }
}