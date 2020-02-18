package com.poolafrica.billing.mpesa.controller;

import com.poolafrica.billing.mpesa.utils.Constants;
import com.poolafrica.billing.mpesa.utils.Mpesa;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;

@RequestMapping("/api/v1/billing")
@RestController
public class MpesaController {

    private Mpesa mpesa =new Mpesa(Constants.INSTANCE.getAPP_KEY(), Constants.INSTANCE.getAPP_SECRET());

    @PostMapping(value = "/stk-push")
    public String mpesaStkPush(){
        try {
             mpesa.STKPushSimulation("174379", "MTc0Mzc5YmZiMjc5ZjlhYTliZGJjZjE1OGU5N2RkNzFhNDY3Y2QyZTBjODkzMDU5YjEwZjc4ZTZiNzJhZGExZWQyYzkxOTIwMjAwMjE4MTA0MDAw",
                    "20200218104000","CustomerPayBillOnline", "1",  "254714581282", "174379","254714581282",
                    "https://sandbox.safaricom.co.ke/mpesa/stkpush/v1/processrequest", "test", "test");
            return "Success";

        } catch (IOException e) {
            e.printStackTrace();
            return e.getLocalizedMessage();
        }
    }

    @PostMapping(value = "/stk-callback")
    public String mpesaStkCalback(){
        try {
            mpesa.STKPushTransactionStatus("174379","MTc0Mzc5YmZiMjc5ZjlhYTliZGJjZjE1OGU5N2RkNzFhNDY3Y2QyZTBjODkzMDU5YjEwZjc4ZTZiNzJhZGExZWQyYzkxOTIwMjAwMjE4MTA0MDAw","20200218104000", mpesa.mpesaResponse());

            if (mpesa.processMpesaResponseCode().equals("0")){
                return "Success";
            }else{
                return "Fail";
            }
        } catch (IOException e) {
           return e.getLocalizedMessage();
        }
    }

}