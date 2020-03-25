package com.tfq.manager.web.model.response;


import lombok.Data;

import java.util.List;

@Data
public class UserStatisticsResponseVO extends BaseStatisticsResponseVO {

    /**
     * x轴的刻度名称
     */
    private List<String>  xPoints;

    /**
     * 每一个刻度的活跃用户数
     */
    private List<Integer> activeUsers;

    /**
     * 不活跃的用户数量
     */
    private List<Integer> inactiveUsers;

    public UserStatisticsResponseVO() {
        super();
        this.setType("userInfo");
        this.setTitle("用户活跃度");
    }
}
