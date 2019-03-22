package com.nio.course3.jpademo.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;
import org.joda.money.Money;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 *  D&T: 2019/3/22 10:20
 *  Des：
 */
@Entity
@Table(name = "T_menu")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Coffee
        implements Serializable
{
    @Id
    @GeneratedValue
    private Long   id;
    @Column
    @Type(type = "org.jadira.usertype.moneyandcurrency.joda.PersistentMoneyAmount",
          parameters = {@org.hibernate.annotations.Parameter(name = "currencyCode",
                                                             value = "CNY")})
    private Money  price;
    private String name;
    @Column(updatable = false)
    @CreationTimestamp
    private Date   createTimeStamp;
    @UpdateTimestamp
    private Date   updateTimeStamp;
}
