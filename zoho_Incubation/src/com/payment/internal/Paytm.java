package com.payment.internal;

import com.payment.api.PayementService;

public class Paytm implements PayementService{
    private double amount;
    private String accNo;
    private String name;
    public void pay(double amount,String accNo, String name){
        System.out.println("Account No : "+accNo+"\n Name : "+name+"\n Amount : "+amount+"\n "+" Payment Done by Paytm");
    }
}