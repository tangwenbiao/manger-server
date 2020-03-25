package com.tfq.manager.web.model.response;

import lombok.Data;

@Data
public class PanelStatisticsResponseVO {

    /**
     * 用户数量
     */
    private Integer userTotal;

    /**
     * 订单数量
     */
    private Integer orderTotal;

}
