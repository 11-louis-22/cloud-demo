package cn.itcast.order.web;

import cn.itcast.feign.client.UserClient;
import cn.itcast.feign.pojo.User;
import cn.itcast.order.pojo.Order;
import cn.itcast.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("order")
public class OrderController {

   @Autowired
   private OrderService orderService;

    @Resource
    private UserClient userClient;

    @GetMapping("{orderId}")
    public Order queryOrderByUserId(@PathVariable("orderId") Long orderId) {
        //1、根据id查询具体用户的订单并返回
        Order order = orderService.queryOrderById(orderId);

        //2、功能：查询订单的同时，根据订单中包含的userId查询出用户信息--->用Feign远程调用查询user
        User user = userClient.get(order.getUserId());

        //3、将用户存入到order中
        order.setUser(user);

        //4、返回订单
        return order;






  /*@Autowired
   private RestTemplate restTemplate;

    @GetMapping("{orderId}")
    public Order queryOrderByUserId(@PathVariable("orderId") Long orderId) {
        //1、根据id查询具体用户的订单并返回
        Order order = orderService.queryOrderById(orderId);

        //2、功能：查询订单的同时，根据订单中包含的userId查询出用户信息--->RestTemplate远程查询user
        //2.1 url地址
        String url = "http://userservice/user/" + order.getUserId();

        //2.2 发起调用,如果你是get请求，就用getForObject，如果是post请求就用postForObject
        User user = restTemplate.getForObject(url, User.class);

        //3、将用户存入到order中
        order.setUser(user);

        //4、返回订单
        return order;*/

    }
}
