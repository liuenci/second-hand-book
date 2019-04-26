package com.gxy.vbook.pojo;

import lombok.*;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DonateBook {
    private Integer id;
    private Integer userId;
    private String name;
    private String author;
    private Double originalPrice;
    private Integer discount;
    private Date createTime;
}
