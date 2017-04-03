package org.university.development.service;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * This is for research purposes.
 */

@SpringBootApplication
@ComponentScan(basePackages = {"org.university.development"})
public class ApplicationRunner 
{
    public static void main(String[] args) 
    {
        SpringApplication.run(ApplicationRunner.class, args);
    }
}
