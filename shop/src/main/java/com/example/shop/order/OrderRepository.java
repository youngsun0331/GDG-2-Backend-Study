package com.example.shop.order;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.query.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderRepository {

    @PersistenceContext
    private EntityManager em ;

    public Order findById(Long orderid){
        return em.find(Order.class, orderid);

    }

    public List<Order> findAll(){
        return em.createQuery("SELECT o FROM order o", Order.class)
                .getResultList();

    }

    public Order findByorderId(String orderId){
        List<Order> result = em.createQuery(
                "SELECT o FROM order WHERE orderId = :orderId",Order.class
        ).setParameter("orderId",orderId).getResultList();

        return result.isEmpty() ? null : result.get(0);
    }


    public void save(Order order){
        em.persist(order);
    }

    public void deleteById(Long id){
        Order order = em.find(Order.class, id);
        em.remove(order);
    }



}
