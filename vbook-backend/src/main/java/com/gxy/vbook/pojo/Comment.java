package com.gxy.vbook.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    private Integer id;
    private String orderNo;
    private Integer score;
    private String comment;
}
