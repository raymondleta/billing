package com.poolafrica.billing.mpesa.controller;

import com.mpesa_api.wrappers.responses.callbacks.STK_Success_CallbackResponse;
import com.poolafrica.billing.mpesa.model.MpesaBody;
import com.poolafrica.billing.mpesa.utils.Constants;
import com.poolafrica.billing.mpesa.utils.Mpesa;
import okhttp3.Response;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RequestMapping("/api/v1/billing")
@RestController
public class MpesaController {

    private Mpesa mpesa = new Mpesa(Constants.getAPP_KEY(), Constants.getAPP_SECRET());

    @PostMapping(value = "/stk-push")
    public String mpesaStkPush() {
        try {
            mpesa.STKPushSimulation("174379", "MTc0Mzc5YmZiMjc5ZjlhYTliZGJjZjE1OGU5N2RkNzFhNDY3Y2QyZTBjODkzMDU5YjEwZjc4ZTZiNzJhZGExZWQyYzkxOTIwMjAwMjIwMTYyNTAw",
                    "20200220162500", "CustomerPayBillOnline", "1", "254714581282", "174379", "254714581282",
                    "https://2034edf2.ngrok.io/api/v1/billing/stk-callback", "test", "test");
            return "Success";

        } catch (IOException e) {
            e.printStackTrace();
            return e.getLocalizedMessage();
        }
    }

    @PostMapping(value = "/stk-callback")
    public String mpesaStkCalback(@RequestBody STK_Success_CallbackResponse response) {

        String result = String.valueOf(response.getBody().getStkCallback().getResultCode());

        if (result.equals("0")) {
            return "Success";
        } else {
            return "Fail";
        }
    }


}