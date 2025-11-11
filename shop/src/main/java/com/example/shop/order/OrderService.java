package com.example.shop.order;

import com.example.shop.order.dto.OrderCreateRequest;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class OrderService {

    private final OrderRepository orderRepository;


    @Transactional
    public long createOrder(OrderCreateRequest request) {
        //Order 의 ID는 DB 에 등록할때 생김 -> html에서 처리 x 그러면 어떻게 비교하지?
//        Order existOrder = orderRepository.findOrderById(request.getId());
//        if(existOrder != null) {
//            throw new RuntimeException("이미 있는 주문입니다"+request.getId());
//        }
        Orders orders = new Orders(
                request.getOrderDate(),
                request.getTotalPrice(),
                request.getStatus(),
                request.getPointUsed(),
                request.getCashAmount()
        );

        orderRepository.save(orders);
        return orders.getOrderId();
    }


    @Transactional
    public List<Orders> getAllOrder() {

        return orderRepository.findAll();
    }

    @Transactional
    public Orders getOrderById (long orderId){
        Orders orders = orderRepository.findById(orderId);
        if( orders == null){
            throw new RuntimeException("주문정보를 찾을 수 없습니다"+orderId);
        }
        return orders;
    }

    @Transactional
    public void deleteOrderById(long orderId){
        Orders orders = orderRepository.findById(orderId);
        if( orders != null){
            throw new RuntimeException("주문정보를 찾을 수 없습니다"+orderId);
        }

        orderRepository.deleteById(orderId);
    }
}
