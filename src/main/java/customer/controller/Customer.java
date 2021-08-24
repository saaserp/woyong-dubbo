package customer.controller;

import bean.Order;
import com.alibaba.dubbo.config.annotation.Reference;
import com.service.IOrderService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@EnableAutoConfiguration
@Controller
public class Customer {
    @Reference(version = "1.0.0",loadbalance="random")
    IOrderService orderService;
    @RequestMapping("/test")
    @ResponseBody
    public String test(){
        List<Order> orders=orderService.getOrderList("");
        System.out.println( orders);
        return orders.toString();
    }


}
