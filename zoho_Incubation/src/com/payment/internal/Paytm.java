package com.payment.internal;

import com.payment.api.PayementService;

public class Paytm implements PayementService{
    
    public void pay(double amount,String accNo, String name){
        System.out.println("Account No : "+accNo+"\n Name : "+name+"\n Amount : "+amount+"\n "+" Payment Done by Paytm");
    }
}