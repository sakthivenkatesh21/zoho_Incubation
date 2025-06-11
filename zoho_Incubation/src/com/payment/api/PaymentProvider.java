package com.payment.api;

import com.payment.internal.Paytm;

public class PaymentProvider{
    public static PayementService getPayementService(){
        return new Paytm();
    }
}
