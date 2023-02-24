package com.fedex.service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public interface ITrackerService {
    CompletableFuture<Map<String, String>> trackStatus(List<String> orderNumbers);
}
