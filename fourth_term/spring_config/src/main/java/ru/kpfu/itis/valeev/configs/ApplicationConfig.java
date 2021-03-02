package ru.kpfu.itis.valeev.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.kpfu.itis.valeev.controllers.*;

@Configuration
public class ApplicationConfig {

    @Bean
    public Calculator additionCalculator() {
        return new AdditionCalculator();
    }

    @Bean
    public Calculator divisionCalculator() {
        return new DivisionCalculator();
    }

    @Bean
    public Calculator multiplicationCalculator() {
        return new MultiplicationCalculator();
    }

    @Bean
    public Calculator subtractionCalculator() {
        return new SubtractionCalculator();
    }

    @Bean
    public Calculator squaredSumCalculator() {
        return new SquaredSumCalculator(multiplicationCalculator());
    }
}
