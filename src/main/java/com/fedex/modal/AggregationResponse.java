package com.fedex.modal;

import lombok.Data;

@Data
public class AggregationResponse {
    private Shipments shipments;
    private Track track;
    private Pricing pricing;
}
