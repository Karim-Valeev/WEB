package ru.kpfu.itis.valeev.controllers;

public class SquaredSumCalculator implements Calculator {
    Calculator helpingCalculator;

    public SquaredSumCalculator(Calculator helpingCalculator){
        this.helpingCalculator = helpingCalculator;
    }
    @Override
    public double calculate(double x1, double x2) {
        double first_term = helpingCalculator.calculate(x1,x1);
        double second_term = helpingCalculator.calculate(2, helpingCalculator.calculate(x1, x2));
        double third_term = helpingCalculator.calculate(x2, x2);
        return first_term + second_term + third_term;
    }
}
