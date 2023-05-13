package net.nvsoftware.iOrderService;

import org.springframework.cloud.client.DefaultServiceInstance;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

public class ServiceInstanceListSupplierTest implements ServiceInstanceListSupplier {
    @Override
    public String getServiceId() {
        return null;
    }

    @Override
    public Flux<List<ServiceInstance>> get() {
        List<ServiceInstance> serviceInstancesList = new ArrayList<>();

        serviceInstancesList.add(new DefaultServiceInstance(
                "PAYMENT-SERVICE",
                "PAYMENT-SERIVCE",
                "localhost",
                8053,
                false
        )); // mocked port

        serviceInstancesList.add(new DefaultServiceInstance(
                "PRODUCT-SERVICE",
                "PRODUCT-SERIVCE",
                "localhost",
                8053,
                false
        )); // mocked port

        return Flux.just(serviceInstancesList);
    }
}
