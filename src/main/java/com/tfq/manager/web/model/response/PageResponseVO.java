package com.tfq.manager.web.model.response;

import lombok.Data;

import java.util.List;

@Data
public class PageResponseVO<T> {

    /**
     * 当前页数
     */
    private Integer page;

    /**
     * 总条数
     */
    private Integer total;

    /**
     * 每页条数
     */
    private Integer limit;

    /**
     * 查询的信息
     */
    private List<T> dataList;


}
