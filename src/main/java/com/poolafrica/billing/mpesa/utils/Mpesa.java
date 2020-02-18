package com.poolafrica.billing.mpesa.utils;

import com.google.gson.Gson;
import com.poolafrica.billing.mpesa.model.MpesaQuerySuccess;
import com.poolafrica.billing.mpesa.model.MpesaResponseSuccess;
import okhttp3.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Base64;

public class Mpesa {
    private String appKey;
    private String appSecret;
    private Response resp;
    private Response status;


    public Mpesa(String app_key, String app_secret) {
        appKey = app_key;
        appSecret = app_secret;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    private String authenticate() throws IOException {

        String appKeySecret = appKey + ":" + appSecret;
        byte[] bytes = appKeySecret.getBytes("ISO-8859-1");
        String encoded = Base64.getEncoder().encodeToString(bytes);


        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://sandbox.safaricom.co.ke/oauth/v1/generate?grant_type=client_credentials")
                .get()
                .addHeader("authorization", "Basic " + encoded)
                .addHeader("cache-control", "no-cache")

                .build();

        Response response = client.newCall(request).execute();
        JSONObject jsonObject = new JSONObject(response.body().string());
        return jsonObject.getString("access_token");
    }

    public String STKPushSimulation(String businessShortCode, String password, String timestamp, String transactionType,
                             String amount, String partyA, String partyB, String phoneNumber, String callBackURL,
                             String accountReference, String transactionDesc) throws IOException {
        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("BusinessShortCode", businessShortCode);
        jsonObject.put("Password", password);
        jsonObject.put("Timestamp", timestamp);
        jsonObject.put("TransactionType", transactionType);
        jsonObject.put("Amount", amount);
        jsonObject.put("PartyA", partyA);
        jsonObject.put("PartyB", partyB);
        jsonObject.put("PhoneNumber", phoneNumber);
        jsonObject.put("CallBackURL", callBackURL);
        jsonObject.put("AccountReference", accountReference);
        jsonObject.put("TransactionDesc", transactionDesc);


        jsonArray.put(jsonObject);

        String requestJson = jsonArray.toString().replaceAll("[\\[\\]]", "");

        OkHttpClient client = new OkHttpClient();
        String url = "https://sandbox.safaricom.co.ke/mpesa/stkpush/v1/processrequest";
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, requestJson);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .addHeader("content-type", "application/json")
                .addHeader("authorization", "Bearer " + authenticate())
                .addHeader("cache-control", "no-cache")
                .build();


        Response response = client.newCall(request).execute();

        resp = response;
        return response.body().toString();
    }

    public String STKPushTransactionStatus(String businessShortCode, String password, String timestamp, String checkoutRequestID) throws IOException {
        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("BusinessShortCode", businessShortCode);
        jsonObject.put("Password", password);
        jsonObject.put("Timestamp", timestamp);
        jsonObject.put("CheckoutRequestID", checkoutRequestID);

        jsonArray.put(jsonObject);

        String requestJson = jsonArray.toString().replaceAll("[\\[\\]]", "");


        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, requestJson);
        Request request = new Request.Builder()
                .url("https://sandbox.safaricom.co.ke/mpesa/stkpushquery/v1/query")
                .post(body)
                .addHeader("authorization", "Bearer " + authenticate())
                .addHeader("content-type", "application/json")
                .build();

        Response response = client.newCall(request).execute();
        status = response;
        return response.body().toString();
    }

    public String mpesaResponse() {

        String json = null;
        try {
            json = resp.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Gson g = new Gson();
        MpesaResponseSuccess checkoutId = g.fromJson(json, MpesaResponseSuccess.class);
        return checkoutId.getCheckoutRequestID();
    }

     public String processMpesaResponseCode(){
        String json = null;


        try {
            json = status.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Gson g = new Gson();
        MpesaQuerySuccess statusCode = g.fromJson(json, MpesaQuerySuccess.class);
        return statusCode.getResultCode();

    }
}
