package com.example.shop.order;


import com.example.shop.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.hibernate.query.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<Void> createOrder(@RequestBody OrderCreateRequest orderCreateRequest){
        Long orderId = orderService.createOrder(orderCreateRequest);
        return ResponseEntity.created(URI.create("/order"+orderId)).build();
    }

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrder(){
        List<Order> order = orderService.getAllOrder();
        return ResponseEntity.ok(order);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<Order> getOrder(@PathVariable long orderId){
        Order order = orderService.getOrderById(orderId);
        return ResponseEntity.ok(order);
    }
    @DeleteMapping("/{orderId}")
    public ResponseEntity<Void> deleteOrder(@PathVariable long orderId){
        orderService.deleteOrderById(orderId);

        return ResponseEntity.ok().build();
    }


}
