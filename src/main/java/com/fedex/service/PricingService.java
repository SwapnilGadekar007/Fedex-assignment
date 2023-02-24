package com.fedex.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.fedex.restclient.PricingClient;

@Service
public class PricingService implements IPricingService {

    @Autowired
    private PricingClient pricingClient;

    @Async
    @Override
    public CompletableFuture<Map<String, BigDecimal>> getPricing(List<String> orderNumbers) {
        Map<String, BigDecimal> pricing = orderNumbers.stream().parallel().map(this::getPricing).map(CompletableFuture::join)
                .collect(Collectors.toMap(KeyValue::getKey, KeyValue::getValue));

        return CompletableFuture.completedFuture(pricing);
    }

    @Async
    public CompletableFuture<KeyValue<String, BigDecimal>> getPricing(String orderNumber) {
        BigDecimal price = pricingClient.getPricing(orderNumber);
        return CompletableFuture.completedFuture(new KeyValue<>(orderNumber, price));
    }
}
