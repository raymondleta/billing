package com.poolafrica.billing.mpesa;

import org.springframework.web.bind.annotation.*;
import java.io.IOException;

@RequestMapping("/api/v1/billing")
@RestController
public class MpesaController {

    Mpesa m=new Mpesa(Constants.INSTANCE.getAPP_KEY(), Constants.INSTANCE.getAPP_SECRET());

    @PostMapping(value = "/mpesa-auth")
    public String mpesaAuthenticate(){
        try {
            return m.authenticate();

        } catch (IOException e) {
            e.printStackTrace();
            return "error";
        }
    }


    @PostMapping(value = "/stk-push")
    public String mpesaStkPush(){
        try {
             m.STKPushSimulation("174379", "MTc0Mzc5YmZiMjc5ZjlhYTliZGJjZjE1OGU5N2RkNzFhNDY3Y2QyZTBjODkzMDU5YjEwZjc4ZTZiNzJhZGExZWQyYzkxOTIwMjAwMjE3MTQzMDAw",
                    "20200217143000","CustomerPayBillOnline", "1",  "254714581282", "174379","254714581282",
                    "https://sandbox.safaricom.co.ke/mpesa/stkpush/v1/processrequest", "test", "test");
            return "Success";

        } catch (IOException e) {
            e.printStackTrace();
            return e.getLocalizedMessage();
        }
    }


}
