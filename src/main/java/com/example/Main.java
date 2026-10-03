package com.example;

import com.example.entity.OrderDetails;
import com.example.entity.Orders;
import com.example.util.HibernateUtil;

import org.hibernate.Session;

public class Main {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        Orders order = session.createQuery(
                "select distinct o from Orders o " +
                "join fetch o.user " +
                "join fetch o.orderDetails od " +
                "join fetch od.product " +
                "where o.id = :id",
                Orders.class)
                .setParameter("id", 1L)
                .getSingleResult();

        System.out.println("========== ORDER ==========");
        System.out.println("Order ID: " + order.getId());
        System.out.println("Order Date: " + order.getOrderDate());
        System.out.println("Customer: " + order.getUser().getUsername());
        System.out.println("Email: " + order.getUser().getEmail());
        System.out.println("Total: ₹" + order.getTotalAmount());

        System.out.println("\nProducts:");

        for (OrderDetails detail : order.getOrderDetails()) {

            System.out.println(
                    "  Product: " + detail.getProduct().getName()
            );

            System.out.println(
                    "  Quantity: " + detail.getQuantity()
            );

            System.out.println(
                    "  Unit Price: ₹" + detail.getUnitPrice()
            );

            System.out.println();
        }

        session.close();
        HibernateUtil.shutdown();
    }
}