package com.fedex.restclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "track", url = "${client.tracker-url}")
public interface TrackerClient {

    @RequestMapping(method = RequestMethod.GET, value = "/track-status")
    String trackStatus(@RequestParam("orderNumber") String orderNumber);
}
