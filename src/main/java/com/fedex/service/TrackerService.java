package com.fedex.service;

import com.fedex.restclient.PricingClient;
import com.fedex.restclient.TrackerClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Service
public class TrackerService implements ITrackerService {

    @Autowired
    private TrackerClient trackerClient;

    @Async
    @Override
    public CompletableFuture<Map<String, String>> trackStatus(List<String> orderNumbers) {
        Map<String, String> status = orderNumbers.stream().parallel().map(this::trackStatus).map(CompletableFuture::join)
                .collect(Collectors.toMap(KeyValue::getKey, KeyValue::getValue));

        return CompletableFuture.completedFuture(status);
    }

    @Async
    public CompletableFuture<KeyValue<String, String>> trackStatus(String orderNumber) {
        String status = trackerClient.trackStatus(orderNumber);
        return CompletableFuture.completedFuture(new KeyValue<>(orderNumber, status));
    }
}
