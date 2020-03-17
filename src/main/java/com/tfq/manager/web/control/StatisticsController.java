package com.tfq.manager.web.control;

import com.tfq.manager.web.model.response.UserStatisticsResponseVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "statistics")
public class StatisticsController {

    @ApiOperation(value = "用户统计信息")
    @RequestMapping(value = "userInfo",method = RequestMethod.GET)
    public UserStatisticsResponseVO userInfo(){
        UserStatisticsResponseVO responseVO=new UserStatisticsResponseVO();
        responseVO.setTitle("用户活跃度");
        //x刻度
        List<String> points=new ArrayList<>();
        points.add("三月");
        points.add("四月");
        points.add("五月");
        points.add("六月");
        //活跃用户数
        List<Integer> activeUsers=new ArrayList<>();
        activeUsers.add(1200);
        activeUsers.add(900);
        activeUsers.add(1500);
        activeUsers.add(800);
        //不活跃用户数
        List<Integer> inactiveUsers=new ArrayList<>();
        inactiveUsers.add(300);
        inactiveUsers.add(200);
        inactiveUsers.add(500);
        inactiveUsers.add(100);
        //
        responseVO.setXPoints(points);
        responseVO.setActiveUsers(activeUsers);
        responseVO.setInactiveUsers(inactiveUsers);
        return responseVO;
    }
}
