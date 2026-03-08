package com.example.cicd_service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CicdServiceApplicationTests {

	@Test
	void contextLoads() {
        OrderController order = new OrderController();
        assertEquals("Order Service Running" , order.getOrders());
	}

}
