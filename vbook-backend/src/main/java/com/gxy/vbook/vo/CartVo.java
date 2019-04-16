package com.gxy.vbook.vo;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CartVo {
    private Integer bookId;
    private String name;
    private Double price;
    private Integer quantity;
}
