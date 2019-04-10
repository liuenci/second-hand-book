package com.gxy.vbook.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.util.Date;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Order {
    private Integer id;

    private Integer userId;

    private String orderno;

    private Double totalPrice;

    private Date createtime;
}