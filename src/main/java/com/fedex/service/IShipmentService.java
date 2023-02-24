package com.fedex.service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public interface IShipmentService {
    CompletableFuture<Map<String, List<String>>> getShipmentDetails(List<String> orderNumbers);
}
