package org.university.development.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

/**
 * This is for research purposes.
 * TODO: investigate to change port without using an applicationcontext xml file
 * TODO: investigate how to set a base path without using an applicationcontext xml file
 *
 */

@SpringBootApplication
@ComponentScan(basePackages = {"org.unversity.development"})
@PropertySource(value = {"application.properties"})
public class ApplicationRunner 
{
    public static void main(String[] args) 
    {
        SpringApplication.run(ApplicationRunner.class, args);
    }
}
