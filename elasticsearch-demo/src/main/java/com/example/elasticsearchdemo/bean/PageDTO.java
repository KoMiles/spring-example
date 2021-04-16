package com.example.elasticsearchdemo.bean;

import com.github.pagehelper.Page;
import java.io.Serializable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author komiles@163.com
 * @date 2021-04-16 21:26
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class PageDTO<T>  implements Serializable {
    /**
     * 总数
     */
    private Long total;

    /**
     * 每页条数
     */
    private Integer pageSize;

    /**
     * 当前页
     */
    private Integer pageNum;


    /**
     * 数据
     */
    private List<T> list;

    /**
     * 从page到PageDTO变换方法
     * @param page
     * @param list
     */
    public PageDTO(Page page, List<T> list){
        super();
        this.setTotal(page.getTotal());
        this.setPageSize(page.getPageSize());
        this.setPageNum(page.getPageNum());
        this.setList(list);
    }
}
