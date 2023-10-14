package com.liqui.model.v1;

import com.liqui.model.ModelMarker;

public class HzStoredModel implements ModelMarker {

    private String value;
    private Integer amount;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
