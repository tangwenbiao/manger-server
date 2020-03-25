package com.tfq.manager.web.model.request;

import lombok.Data;

@Data
public class OrderQueryRequestVO {

    /**
     * 关键字
     */
    private String key;

    /**
     * 页数
     */
    private Integer page;

    /**
     * 限制条数
     */
    private Integer limit;

    /**
     * 类型
     */
    private String type;

}
