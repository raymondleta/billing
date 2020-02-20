
package com.poolafrica.billing.mpesa.model;

import com.google.gson.annotations.SerializedName;

public class StkCallback {

    @SerializedName("CallbackMetadata")
    private CallbackMetadata callbackMetadata;
    @SerializedName("CheckoutRequestID")
    private String checkoutRequestID;
    @SerializedName("MerchantRequestID")
    private String merchantRequestID;
    @SerializedName("ResultCode")
    private Long resultCode;
    @SerializedName("ResultDesc")
    private String resultDesc;

    public StkCallback(CallbackMetadata callbackMetadata, String checkoutRequestID, String merchantRequestID, Long resultCode, String resultDesc) {
        this.callbackMetadata = callbackMetadata;
        this.checkoutRequestID = checkoutRequestID;
        this.merchantRequestID = merchantRequestID;
        this.resultCode = resultCode;
        this.resultDesc = resultDesc;
    }

    public StkCallback() {
    }

    public CallbackMetadata getCallbackMetadata() {
        return callbackMetadata;
    }

    public void setCallbackMetadata(CallbackMetadata callbackMetadata) {
        this.callbackMetadata = callbackMetadata;
    }

    public String getCheckoutRequestID() {
        return checkoutRequestID;
    }

    public void setCheckoutRequestID(String checkoutRequestID) {
        this.checkoutRequestID = checkoutRequestID;
    }

    public String getMerchantRequestID() {
        return merchantRequestID;
    }

    public void setMerchantRequestID(String merchantRequestID) {
        this.merchantRequestID = merchantRequestID;
    }

    public Long getResultCode() {
        return resultCode;
    }

    public void setResultCode(Long resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultDesc() {
        return resultDesc;
    }

    public void setResultDesc(String resultDesc) {
        this.resultDesc = resultDesc;
    }

}
