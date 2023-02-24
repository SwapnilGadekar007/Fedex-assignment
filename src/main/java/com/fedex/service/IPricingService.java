package com.fedex.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public interface IPricingService {
    CompletableFuture<Map<String, BigDecimal>> getPricing(List<String> orderNumbers);
}
