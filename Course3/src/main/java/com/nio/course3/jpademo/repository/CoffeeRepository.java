package com.nio.course3.jpademo.repository;

import com.nio.course3.jpademo.model.Coffee;

import org.springframework.data.repository.CrudRepository;

/*
 *  D&T: 2019/3/22 10:48
 *  Des：
 */
public interface CoffeeRepository
        extends CrudRepository<Coffee, Long> {}
