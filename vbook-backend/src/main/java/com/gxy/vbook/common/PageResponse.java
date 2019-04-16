package com.gxy.vbook.common;

import lombok.*;

import java.util.List;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PageResponse<T> {
    private Integer total;
    private List<T> rows;
}
