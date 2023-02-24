package com.fedex.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import com.fedex.modal.Pricing;
import com.fedex.modal.Shipments;
import com.fedex.modal.Track;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fedex.modal.AggregationResponse;

@Service
public class AggregationService implements IAggregationService {

    @Autowired
    private IShipmentService shipmentService;

    @Autowired
    private IPricingService pricingService;

    @Autowired
    private ITrackerService trackerService;

    public AggregationResponse aggregateResponse(List<String> shipmentsOrderNumbers, List<String> trackOrderNumbers, List<String> pricingCountryCodes) {
        CompletableFuture<Map<String, BigDecimal>> pricing = pricingService.getPricing(shipmentsOrderNumbers);
        CompletableFuture<Map<String, List<String>>> shipment = shipmentService.getShipmentDetails(pricingCountryCodes);
        CompletableFuture<Map<String, String>> trackStatus = trackerService.trackStatus(trackOrderNumbers);

        AggregationResponse response = new AggregationResponse();
        response.setPricing(new Pricing(pricing.join()));
        response.setShipments(new Shipments(shipment.join()));
        response.setTrack(new Track(trackStatus.join()));

        return response;
    }
}
