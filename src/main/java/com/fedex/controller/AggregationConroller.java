package com.fedex.controller;

import java.util.List;

import com.fedex.modal.AggregationResponse;
import com.fedex.service.IAggregationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aggregation")
public class AggregationConroller {

    @Autowired
    private IAggregationService aggregationService;

    @GetMapping
    public AggregationResponse aggregateResponse(
            @RequestParam("shipmentsOrderNumbers") List<String> shipmentsOrderNumbers,
            @RequestParam("trackOrderNumbers") List<String> trackOrderNumbers,
            @RequestParam("pricingCountryCodes") List<String> pricingCountryCodes) {
        return aggregationService.aggregateResponse(shipmentsOrderNumbers, trackOrderNumbers, pricingCountryCodes);
    }
}
