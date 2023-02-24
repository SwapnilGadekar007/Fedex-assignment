package com.fedex.service;

import com.fedex.restclient.PricingClient;
import com.fedex.restclient.ShipmentClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Service
public class ShipmentService implements IShipmentService {

    @Autowired
    private ShipmentClient shipmentClient;

    @Async
    @Override
    public CompletableFuture<Map<String, List<String>>> getShipmentDetails(List<String> orderNumbers) {
        Map<String, List<String>> shipment = orderNumbers.stream().parallel().map(this::getShipmentDetails).map(CompletableFuture::join)
                .collect(Collectors.toMap(KeyValue::getKey, KeyValue::getValue));
        return CompletableFuture.completedFuture(shipment);
    }

    @Async
    public CompletableFuture<KeyValue<String, List<String>>> getShipmentDetails(String orderNumber) {
        List<String> shippingDetails = shipmentClient.getShipmentDetails(orderNumber);
        return CompletableFuture.completedFuture(new KeyValue<>(orderNumber, shippingDetails));
    }
}
