package com.deiv.model.v2;

import com.deiv.model.ModelMarker;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MutableModelButJson implements ModelMarker {

    private String f1;
    private String f2;
    private String f3;
    private String f4;

    public MutableModelButJson(String value) {
        this.f1 = value + "1";
        this.f2 = value + "2";
        this.f3 = value + "3";
        this.f4 = value + "4";
    }
}
