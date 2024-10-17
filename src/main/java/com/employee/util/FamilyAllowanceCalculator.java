package com.employee.util;

public class FamilyAllowanceCalculator {
    public double calculateAllowance(int numberOfChildren, double salary) {
        double allowance = 0;

        if (numberOfChildren <= 0) {
            return 0;
        }

        if (salary < 6000) {
            allowance += calculateAllowanceForChildren(numberOfChildren, 300, 150);
        } else if (salary > 8000) {
            allowance += calculateAllowanceForChildren(numberOfChildren, 200, 110);
        }

        return allowance;
    }

    private double calculateAllowanceForChildren(int numberOfChildren, double firstThreeRate, double nextThreeRate) {
        double allowance = 0;

        if (numberOfChildren > 0) {
            allowance += Math.min(3, numberOfChildren) * firstThreeRate;
        }

        if (numberOfChildren > 3) {
            allowance += Math.min(3, numberOfChildren - 3) * nextThreeRate;
        }
        return allowance;
    }
}
