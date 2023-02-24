package com.fedex.service;

import com.fedex.modal.AggregationResponse;

import java.util.List;

public interface IAggregationService {
    AggregationResponse aggregateResponse(List<String> shipmentsOrderNumbers, List<String> trackOrderNumbers, List<String> pricingCountryCodes);
}
