package com.tfq.manager.web.model.response;

import lombok.Data;

import java.util.List;

@Data
public class OrderStatisticsResponseVo extends BaseStatisticsResponseVO {

    /**
     * 每个月订单数量
     */
    private List<Integer> orderNumbers;

    /**
     * x轴的刻度名称
     */
    private List<String>  xPoints;

    public OrderStatisticsResponseVo() {
        super();
        this.setType("orderInfo");
        this.setTitle("订单总计");
    }
}
