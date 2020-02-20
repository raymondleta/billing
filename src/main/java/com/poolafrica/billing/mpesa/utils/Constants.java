package com.poolafrica.billing.mpesa.utils;

public class Constants {
    private static String APP_KEY = "46aTjCMbVcXdox7a8tao8gsoeoRhM1rk";
    private static String APP_SECRET = "0aoA8ktKmGUB6RkF";

    public Constants(String APP_KEY, String APP_SECRET) {
        Constants.APP_KEY = APP_KEY;
        Constants.APP_SECRET = APP_SECRET;
    }

    public static String getAPP_KEY() {
        return APP_KEY;
    }

    public void setAPP_KEY(String APP_KEY) {
        this.APP_KEY = APP_KEY;
    }

    public static String getAPP_SECRET() {
        return APP_SECRET;
    }

    public void setAPP_SECRET(String APP_SECRET) {
        this.APP_SECRET = APP_SECRET;
    }
}
