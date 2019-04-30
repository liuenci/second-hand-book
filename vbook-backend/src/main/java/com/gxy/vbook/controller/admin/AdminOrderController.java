package com.gxy.vbook.controller.admin;

import com.gxy.vbook.common.PageResponse;
import com.gxy.vbook.common.ServerResponse;
import com.gxy.vbook.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 后台订单接口
 */
@RestController
@RequestMapping("admin/order")
public class AdminOrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 查看订单列表
     * @param orderNo
     * @return
     */
    @RequestMapping("list")
    public PageResponse list(@RequestParam("orderNo") String orderNo) {
        return orderService.findOrderList(orderNo);
    }

    /**
     * 查看某一个订单的信息
     * @param orderNo
     * @return
     */
    @RequestMapping("{orderNo}")
    public ServerResponse item(@PathVariable("orderNo") String orderNo) {
        return orderService.item(orderNo);
    }
}
