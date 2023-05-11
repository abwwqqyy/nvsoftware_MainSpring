package net.nvsoftware.iOrderService.service;

import lombok.extern.log4j.Log4j2;
import net.nvsoftware.iOrderService.entity.OrderEntity;
import net.nvsoftware.iOrderService.model.OrderRequest;
import net.nvsoftware.iOrderService.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@Log4j2
public class OrderServiceImpl implements OrderService{
    @Autowired
    private OrderRepository orderRepository;
    @Override
    public long placeOrder(OrderRequest orderRequest) { // TODO: make this a transaction
        // call OrderService to create an order entity with status CREATED save to orderdb
        log.info("OrderService placeOrder - save to orderdb start");
        OrderEntity orderEntity = OrderEntity.builder()
                .productId(orderRequest.getProductId())
                .orderQuantity(orderRequest.getOrderQuantity())
                .totalAmount(orderRequest.getTotalAmount())
                .orderDate(Instant.now())
                .orderStatus("CREATED")
                .paymentMode(orderRequest.getPaymentMode().name())
                .build();

        orderEntity = orderRepository.save(orderEntity);
        log.info("OrderService placeOrder - save to orderdb done");
        // call ProductService to check quantity and reduce quantity if ok

        // call PaymentService to charge paymentMode, mark order COMPLETED if success, else CANCELLED
        return orderEntity.getOrderId();
    }
}
