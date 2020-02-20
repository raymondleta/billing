
package com.poolafrica.billing.mpesa.model;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

public class MpesaBody {

    @SerializedName("Body")
    private Body body;

    public MpesaBody(Body body) {
        this.body = body;
    }

    public MpesaBody() {
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }

}
