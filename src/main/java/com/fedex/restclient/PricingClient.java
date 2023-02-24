package com.fedex.restclient;

import java.math.BigDecimal;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "pricing", url = "${client.pricing-url}")
public interface PricingClient {
    @RequestMapping(method = RequestMethod.GET, value = "/pricing")
    BigDecimal getPricing(@RequestParam("countryCode") String countryCode);
}
