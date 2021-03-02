package ru.kpfu.itis.valeev.controllers;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlConfigurationTest {
    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("context.xml");

        Calculator calculator1 = (Calculator) applicationContext.getBean("additionCalculator");
        Calculator calculator2 = (Calculator) applicationContext.getBean("multiplicationCalculator");
        Calculator calculator3 = (Calculator) applicationContext.getBean("squaredSumCalculator");

        System.out.println(calculator1.calculate(10, 20));
        System.out.println(calculator2.calculate(10, 20));
        System.out.println(calculator3.calculate(10, 20));

    }
}
