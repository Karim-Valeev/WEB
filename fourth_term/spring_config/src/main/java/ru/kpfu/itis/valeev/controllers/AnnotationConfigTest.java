package ru.kpfu.itis.valeev.controllers;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.kpfu.itis.valeev.configs.ApplicationConfig;

public class AnnotationConfigTest {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        Calculator calculator1 = (Calculator) context.getBean("additionCalculator");
        Calculator calculator2 = (Calculator) context.getBean("multiplicationCalculator");
        Calculator calculator3 = (Calculator) context.getBean("squaredSumCalculator");

        System.out.println(calculator1.calculate(10, 20));
        System.out.println(calculator2.calculate(10, 20));
        System.out.println(calculator3.calculate(10, 20));

    }

}
