package com.nio.course3.jpademo;

import com.nio.course3.jpademo.model.Coffee;
import com.nio.course3.jpademo.model.CoffeeOrder;
import com.nio.course3.jpademo.repository.CoffeeOrderRepository;
import com.nio.course3.jpademo.repository.CoffeeRepository;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Arrays;
import java.util.Collections;
import java.util.Locale;

import lombok.extern.slf4j.Slf4j;

/*
 *  D&T: 2019/3/22 10:51
 *  Des：
 */
@Slf4j
@SpringBootApplication
@EnableJpaRepositories
public class JpaApp
        implements ApplicationRunner
{
    @Autowired
    private CoffeeRepository      mCoffeeRepository;
    @Autowired
    private CoffeeOrderRepository mCoffeeOrderRepository;

    public static void main(String[] args) {
        SpringApplication.run(JpaApp.class, args);
    }

    @Override
    public void run(ApplicationArguments args)
            throws Exception
    {
        initOrder();
    }

    private void initOrder() {
        Coffee latte = Coffee.builder()
                             .name("long black")
                             .price(Money.of(CurrencyUnit.of(Locale.CHINA), 21))
                             .build();
        mCoffeeRepository.save(latte);
        log.info("latte=" + latte);

        Coffee cappuccino = Coffee.builder()
                                  .name("espresso")
                                  .price(Money.of(CurrencyUnit.of(Locale.CHINA), 30))
                                  .build();
        mCoffeeRepository.save(cappuccino);
        log.info("cappuccino=" + cappuccino);

        CoffeeOrder coffeeOrder = CoffeeOrder.builder()
                                             .consumer("niobe")
                                             .coffees(Collections.singletonList(latte))
                                             .build();
        mCoffeeOrderRepository.save(coffeeOrder);
        log.info("coffeeOrder=" + coffeeOrder);


        coffeeOrder = CoffeeOrder.builder()
                                 .consumer("mia")
                                 .coffees(Arrays.asList(latte, cappuccino))
                                 .build();
        mCoffeeOrderRepository.save(coffeeOrder);
        log.info("coffeeOrder=" + coffeeOrder);
    }
}
