package com.poolafrica.billing.mpesa.controller;

import com.mpesa_api.wrappers.responses.callbacks.STK_Success_CallbackResponse;
import com.poolafrica.billing.mpesa.model.MpesaRequestBody;
import com.poolafrica.billing.mpesa.utils.Constants;
import com.poolafrica.billing.mpesa.utils.Mpesa;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;


@RequestMapping("/api/v1/billing")
@RestController
public class MpesaController {



    private Mpesa mpesa = new Mpesa(Constants.getAPP_KEY(), Constants.getAPP_SECRET());
    private String phone;
    private String userResponse;

    @PostMapping(value = "/stk-push")
    private String mpesaStkPush(@RequestBody MpesaRequestBody body) {
        try {
            mpesa.STKPushSimulation("174379", "MTc0Mzc5YmZiMjc5ZjlhYTliZGJjZjE1OGU5N2RkNzFhNDY3Y2QyZTBjODkzMDU5YjEwZjc4ZTZiNzJhZGExZWQyYzkxOTIwMjAwMjIxMTAzNDAw",
                    "20200221103400", "CustomerPayBillOnline", body.getAmount(), body.getPhone(), "174379", body.getPhone(),
                    "http://6a71920e.ngrok.io/api/v1/billing/stk-callback", "Nginyo", "Nginyo");
            return "Success";

        } catch (IOException e) {
            e.printStackTrace();
            return e.getLocalizedMessage();
        }
    }

    @PostMapping(value = "/stk-callback")
    private void mpesaStkCalback(@RequestBody STK_Success_CallbackResponse response) {

        String result = String.valueOf(response.getBody().getStkCallback().getResultCode());

        if (result.equals("0")) {
            userResponse = "0";
        } else {
            userResponse = "1";
        }
    }

    @GetMapping(value = "/user-response")
    private String  userStkResponse(){
        if (userResponse.equals("0")){
            return "Success";
        }else{
            return "Fail";
        }
    }



}