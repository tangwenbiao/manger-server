package com.tfq.manager.web.model.response;

import lombok.Data;

/**
 * 统计信息基类
 */
@Data
public class BaseStatisticsResponseVO {

    /**
     * 统计信息的类型
     */
    private String type;

    /**
     * 统计信息的标题
     */
    private String title;

}
