package com.gxy.vbook.controller.admin;

import com.gxy.vbook.common.PageResponse;
import com.gxy.vbook.common.ServerResponse;
import com.gxy.vbook.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admin/order")
public class AdminOrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("list")
    public PageResponse list(@RequestParam("orderNo") String orderNo) {
        return orderService.findOrderList(orderNo);
    }
    @RequestMapping("{orderNo}")
    public ServerResponse item(@PathVariable("orderNo") String orderNo) {
        return orderService.item(orderNo);
    }
}
