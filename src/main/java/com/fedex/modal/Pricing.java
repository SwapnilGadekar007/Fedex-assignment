package com.fedex.modal;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class Pricing {
    Map<String, BigDecimal> price;

    @JsonAnyGetter
    public Map<String, BigDecimal> getPrice() {
        return this.price;
    }

    @JsonAnySetter
    public void addPrice(String id, BigDecimal price) {
        if (price == null) {
            this.price = new HashMap<>();
        }

        this.price.put(id, price);
    }
}
