package com.example.druiddemo.common;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author komiles@163.com
 * @date 2020-04-30 18:54
 */
@Data
@AllArgsConstructor
public class PageDTO<T> {

    private Long Total;

    private Integer pageSize;

    private Integer pageNum;

    private List<T> list;
}
