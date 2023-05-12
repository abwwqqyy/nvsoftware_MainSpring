package net.nvsoftware.iOrderService.service;

import net.nvsoftware.iOrderService.external.client.PaymentServiceFeignClient;
import net.nvsoftware.iOrderService.external.client.ProductServiceFeignClient;
import net.nvsoftware.iOrderService.model.OrderResponse;
import net.nvsoftware.iOrderService.repository.OrderRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrderServiceImplTest {

    @Mock
    private RestTemplate restTemplate;

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private ProductServiceFeignClient productServiceFeignClient;

    @Mock
    private PaymentServiceFeignClient paymentServiceFeignClient;

    @InjectMocks
    private OrderService orderService = new OrderServiceImpl();

    @DisplayName("Get Order Detail - SUCCESS")
    @Test
    void testWhenGetOrderSuccess(){
        // Mock Part

        // Actual Call
        orderService.getOrderDetailByOrderId(1);
        // Verify Call

        // Assert Response
    }
}