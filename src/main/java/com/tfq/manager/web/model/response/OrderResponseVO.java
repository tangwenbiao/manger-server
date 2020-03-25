package com.tfq.manager.web.model.response;

import com.tfq.manager.web.model.enums.OrderStatus;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class OrderResponseVO {

    /**
     * 编号
     */
    private Integer id;

    /**
     * 交易金额
     */
    private BigDecimal money;

    /**
     * 交易时间
     */
    private LocalDateTime payDate;

    /**
     * 订单状态
     */
    private OrderStatus type;

}
