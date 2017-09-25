package com.oab;

public class Employee {
    private String name;
    private double salary;
    private int seniority;

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Employee && name.equals(((Employee) obj).name);
    }
}
