package com.java.listas.colecciones.models;

import java.util.ArrayList;
import java.util.List;

public class CreditCard {

    private final double limitCredit;
    private final String titular;
    private double balance;

    private final List<Purchase> purchasesList;

    public CreditCard(double limitCredit, String titular) {
        this.limitCredit = limitCredit;
        this.balance = limitCredit;
        this.titular = titular;
        this.purchasesList = new ArrayList<>();
    }

    public int buy (Purchase purchase){
        if(purchase.getPrice() <= 0){
            return 0;
        }
        else if(this.balance >= purchase.getPrice()){
            this.balance -= purchase.getPrice();
            this.purchasesList.add(purchase);
            return 1;
        }
        return 2;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getLimitCredit() {
        return limitCredit;
    }

    public String getTitular() {
        return titular;
    }

    public double getBalance() {
        return balance;
    }

    public List<Purchase> getPurchasesList() {
        return purchasesList;
    }
}
