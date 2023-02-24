package com.fedex.restclient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "shipment", url = "${client.shipment-url}")
public interface ShipmentClient {
    @RequestMapping(method = RequestMethod.GET, value = "/shipment-products")
    List<String> getShipmentDetails(@RequestParam("orderNumber") String orderNumber);
}
