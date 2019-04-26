package com.gxy.vbook.pojo;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Book {
    private Integer id;
    private String name;
    private String author;
    private String type;
    private Double originalPrice;
    private Integer discount;
    private Double price;
    private Integer userId;
    private Integer status;
}