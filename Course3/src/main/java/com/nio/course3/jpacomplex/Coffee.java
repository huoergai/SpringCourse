package com.nio.course3.jpacomplex;

import org.hibernate.annotations.Type;
import org.joda.money.Money;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 *  D&T: 2019/3/22 17:01
 *  Des：
 */
@Entity
@Table(name = "t_menu_x")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Coffee
        extends BaseEntity
        implements Serializable
{
    private String name;
    @Type(type = "org.jadira.usertype.moneyandcurrency.joda.PersistentMoneyAmount",
          parameters = {@org.hibernate.annotations.Parameter(name = "currencyCode",
                                                             value = "CNY")})
    private Money  price;
}
