package com.example;

import com.example.entity.Category;
import com.example.entity.Product;
import com.example.util.HibernateUtil;
import org.hibernate.Session;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class HibernateEcommerceTest {

    @Test
    void testCategoryCreation() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            session.beginTransaction();

            Category category = new Category(
                    "Test Category " + UUID.randomUUID(),
                    "Test Description"
            );

            session.persist(category);
            session.getTransaction().commit();

            assertNotNull(category.getId());

        } finally {
            session.close();
        }
    }

    @Test
    void testProductCreation() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            session.beginTransaction();

            Category category = new Category(
                    "Test Electronics " + UUID.randomUUID(),
                    "Test Category"
            );

            Product product = new Product(
                    "Test Laptop " + UUID.randomUUID(),
                    new BigDecimal("50000.00"),
                    10
            );

            category.addProduct(product);

            session.persist(category);
            session.getTransaction().commit();

            assertNotNull(product.getId());
            assertTrue(product.getName().startsWith("Test Laptop"));

        } finally {
            session.close();
        }
    }
}