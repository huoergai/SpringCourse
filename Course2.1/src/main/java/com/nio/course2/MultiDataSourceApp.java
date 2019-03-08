package com.nio.course2;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

/*
 *  D&T: 2019/2/27 11:20
 *  Des：
 */
@SpringBootApplication
@Slf4j
public class MultiDataSourceApp
        implements CommandLineRunner
{
    public static void main(String[] args) {
        SpringApplication.run(MultiDataSourceApp.class, args);
    }

    @Override
    public void run(String... args)
            throws Exception
    {
    }
}
