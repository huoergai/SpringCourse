package com.nio.course2;

import lombok.Builder;
import lombok.Data;

/*
 *  D&T: 2019/3/12 9:43
 *  Des：
 */
@Data
@Builder
public class User {
    private int    id;
    private String name;
}
