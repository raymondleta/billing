
package com.poolafrica.billing.mpesa.model;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class MpesaRequestBody {

    @Expose
    private String amount;
    @Expose
    private String phone;

    public MpesaRequestBody(String amount, String phone) {
        this.amount = amount;
        this.phone = phone;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
