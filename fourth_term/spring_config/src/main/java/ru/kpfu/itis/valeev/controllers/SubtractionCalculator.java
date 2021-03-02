package ru.kpfu.itis.valeev.controllers;

public class SubtractionCalculator implements Calculator {
    @Override
    public double calculate(double x1, double x2) {
        return x1-x2;
    }
}
