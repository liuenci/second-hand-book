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

    private Double price;

    private Integer userid;

    private Byte status;
}