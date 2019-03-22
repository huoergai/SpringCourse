package com.nio.course3.jpacomplex;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Enumerated;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OrderBy;

/*
 *  D&T: 2019/3/22 17:21
 *  Des：
 */
public class CoffeeOrder
        extends BaseEntity
        implements Serializable
{
    private String       consumer;
    @OrderBy("id")
    @JoinTable(name = "t_order_coffee_x")
    @ManyToMany
    private List<Coffee> coffees;
    @Enumerated
    private OrderStatus  status;
}
