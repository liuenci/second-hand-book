package com.gxy.vbook.vo;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderItemVo {
    private Integer bookId;
    private String bookName;
    private Double price;
    private Integer quantity;
}
