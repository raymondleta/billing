
package com.poolafrica.billing.mpesa.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MpesaRequestBody {

    @Expose
    @SerializedName("amount")
    private String amount;

    @Expose
    @SerializedName("phone")
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
