package com.gxy.vbook.common;

import lombok.*;

import java.util.List;

/**
 * 分页类
 * @param <T>
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PageResponse<T> {
    /**
     * 总个数
     */
    private Integer total;
    /**
     * 所有的记录对象
     */
    private List<T> rows;
}
