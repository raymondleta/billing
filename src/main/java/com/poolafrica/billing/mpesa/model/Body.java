
package com.poolafrica.billing.mpesa.model;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Body {

    @Expose
    private StkCallback stkCallback;

    public Body(StkCallback stkCallback) {
        this.stkCallback = stkCallback;
    }

    public Body() {
    }

    public StkCallback getStkCallback() {
        return stkCallback;
    }

    public void setStkCallback(StkCallback stkCallback) {
        this.stkCallback = stkCallback;
    }

}
