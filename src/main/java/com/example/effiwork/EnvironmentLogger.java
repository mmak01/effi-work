//package com.example.effiwork;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//@Component
//public class EnvironmentLogger implements CommandLineRunner {
//
//    @Value("${DB_HOST:localhost}")
//    private String dbHost;
//
//    @Value("${DB_PORT:3306}")
//    private String dbPort;
//
//    @Value("${DB_USER:root}")
//    private String dbUser;
//
//    @Value("${DB_PASSWORD:default_password}")
//    private String dbPassword;
//
//    @Override
//    public void run(String... args) throws Exception {
//        System.out.println("====== Database Configuration ======");
//        System.out.println("DB_HOST: " + dbHost);
//        System.out.println("DB_PORT: " + dbPort);
//        System.out.println("DB_USER: " + dbUser);
//        System.out.println("DB_PASSWORD: " + dbPassword);
//        System.out.println("====================================");
//    }
//}