package com.voltline.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Voltline storefront — Spring Boot, server-rendered (Spring MVC + Thymeleaf).
 * This is the seed skeleton: it boots cleanly. The catalog, product pages, and
 * the homepage controller are built by jclaw's project phases.
 */
@SpringBootApplication
public class VoltlineApplication {
    public static void main(String[] args) {
        SpringApplication.run(VoltlineApplication.class, args);
    }
}
