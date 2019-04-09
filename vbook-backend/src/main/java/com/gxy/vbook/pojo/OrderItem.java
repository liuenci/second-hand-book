package com.gxy.vbook.pojo;

import lombok.*;

import java.math.BigDecimal;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderItem {
    private Integer id;

    private Integer userid;

    private String orderno;

    private Integer bookid;

    private Integer quantity;

    private Double totalprice;
}