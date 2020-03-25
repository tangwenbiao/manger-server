package com.tfq.manager.web.control;


import com.tfq.manager.web.model.enums.OrderStatus;
import com.tfq.manager.web.model.request.OrderQueryRequestVO;
import com.tfq.manager.web.model.response.OrderDetailResponseVO;
import com.tfq.manager.web.model.response.OrderResponseVO;
import com.tfq.manager.web.model.response.PageResponseVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

@RequestMapping("order")
@RestController
public class OrderController {

    private AtomicInteger INCREASE_NUMBER=new AtomicInteger(1);

    @ApiOperation("订单列表")
    @RequestMapping(value = "list",method = RequestMethod.POST)
    public PageResponseVO<OrderResponseVO> getOrderList(@RequestBody OrderQueryRequestVO orderQuery){
        PageResponseVO<OrderResponseVO> pageResponseVO=new PageResponseVO<>();
        pageResponseVO.setPage(orderQuery.getPage());
        pageResponseVO.setLimit(orderQuery.getLimit());
        List<OrderResponseVO> list = getList(orderQuery.getPage(), orderQuery.getLimit());
        pageResponseVO.setTotal(list.size()*10);
        pageResponseVO.setDataList(list);
        return pageResponseVO;
    }


    @ApiOperation("订单详情")
    @RequestMapping(value = "get/{id}",method = RequestMethod.GET)
    public OrderDetailResponseVO getOrder(@PathVariable("id") Integer id){
        OrderDetailResponseVO details=new OrderDetailResponseVO();
        details.setId(id);
        details.setMoney(new BigDecimal(200));
        details.setPayDate(LocalDateTime.now());
        details.setType(OrderStatus.PAID);
        details.setRemark("当前点击"+INCREASE_NUMBER.getAndIncrement());
        return details;
    }


    private List<OrderResponseVO> getList(int pages,int number){
        List<OrderResponseVO> orderResponseVOS=new ArrayList<>();
        if(pages==1){
            orderResponseVOS= generatorList(10,number);
        }else {
            orderResponseVOS= generatorList(20,number);
        }
        return orderResponseVOS;
    }

    private List<OrderResponseVO> generatorList(int prefix,int number){
        List<OrderResponseVO> orderResponseVOS=new ArrayList<>();
        Random random=new Random();
        for (int i = 0; i < number; i++) {
            OrderResponseVO responseVO=new OrderResponseVO();
            responseVO.setId(prefix*1000+i);
            int money=random.nextInt(100)+300;
            responseVO.setMoney(new BigDecimal(money));
            responseVO.setType(OrderStatus.PAID);
            responseVO.setPayDate(LocalDateTime.now());
            orderResponseVOS.add(responseVO);
        }

        return orderResponseVOS;
    }

}
