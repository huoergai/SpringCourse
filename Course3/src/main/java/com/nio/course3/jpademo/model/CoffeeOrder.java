package com.nio.course3.jpademo.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 *  D&T: 2019/3/22 10:38
 *  Des：
 */
@Table(name = "T_order")
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CoffeeOrder
        implements Serializable
{
    @Id
    @GeneratedValue
    private Long         id;
    private String       consumer;
    @Column(nullable = false)
    private int          state;
    @Column(nullable = false)
    @CreationTimestamp
    private Date         createTime;
    @UpdateTimestamp
    private Date         updateTime;
    @ManyToMany
    @JoinTable(name = "T_order_coffee")
    private List<Coffee> coffees;
}
