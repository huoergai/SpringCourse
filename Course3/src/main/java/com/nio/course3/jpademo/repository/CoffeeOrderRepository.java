package com.nio.course3.jpademo.repository;

import com.nio.course3.jpademo.model.CoffeeOrder;

import org.springframework.data.repository.CrudRepository;

/*
 *  D&T: 2019/3/22 10:50
 *  Des：
 */
public interface CoffeeOrderRepository
        extends CrudRepository<CoffeeOrder, Long> {}
