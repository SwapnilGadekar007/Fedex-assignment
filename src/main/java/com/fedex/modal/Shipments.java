package com.fedex.modal;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Shipments {
    Map<String, List<String>> shipments;

    @JsonAnyGetter
    public Map<String, List<String>> getShipments() {
        return this.shipments;
    }

    @JsonAnySetter
    public void addShipment(String id, List<String> items) {
        if (shipments == null) {
            shipments = new HashMap<>();
        }

        shipments.put(id, items);
    }
}
