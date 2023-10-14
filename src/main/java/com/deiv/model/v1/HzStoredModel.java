package com.deiv.model.v1;

import com.deiv.model.ModelMarker;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class HzStoredModel implements ModelMarker {

    private String v1;
    private Integer a1;

    public HzStoredModel(String value) {
        this.v1 = value;
        this.a1 = Integer.parseInt(value);
    }
}
