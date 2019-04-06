package com.gxy.vbook.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
    private Integer id;

    private Integer userid;

    private Integer bookid;

    private Integer quantity;

}