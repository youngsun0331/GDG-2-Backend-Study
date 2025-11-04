package com.example.shop.order;

import lombok.RequiredArgsConstructor;
import org.hibernate.query.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;


    public long createOrder(OrderCreateRequest orderCreateRequest) {
        long existOrder = orderRepository.findOrderById(orderCreateRequest.getId());
        if(existOrder != null) {
            throw new RuntimeException("이미 있는 주문입니다"+orderCreateRequest.getId());
        }
        Order order = new Order(

        );
        orderRepository.save(order);
        return order.getId();
    }
    public List<Order> getAllOrder() {
        return orderRepository.getAll();
        return orderRepository.getAll();
    }

    public Order getOrderById (long orderId){
        Order order = orderRepository.findById(orderId);
        if( order != null){
            throw new RuntimeException("주문정보를 찾을 수 없습니다"+orderId);
        }
        return order;
    }

    public void deleteOrderById(long orderId){
        Order order = orderRepository.findById(orderId);
        if( order != null){
            throw new RuntimeException("주문정보를 찾을 수 없습니다"+orderId);
        }

        orderRepository.deleteById(orderId);
    }
}
