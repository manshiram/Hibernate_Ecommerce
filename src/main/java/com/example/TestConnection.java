package com.example;

import com.example.util.HibernateUtil;

public class TestConnection {

    public static void main(String[] args) {

        System.out.println("Starting Hibernate...");

        HibernateUtil.getSessionFactory();

        System.out.println("Hibernate connected successfully!");

        HibernateUtil.shutdown();
    }
}