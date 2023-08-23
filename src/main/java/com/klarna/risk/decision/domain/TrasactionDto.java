package com.klarna.risk.decision.domain;

public class TrasactionDto {

    private int purchaseAmount;
    private  CreditDecision creditDecision;

    public TrasactionDto(){

    }
    public TrasactionDto(int purchaseAmount, CreditDecision creditDecision){
        this.purchaseAmount = purchaseAmount;
        this.creditDecision =  creditDecision;

    }
    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public void setPurchaseAmount(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public CreditDecision getCreditDecision() {
        return creditDecision;
    }

    public void setCreditDecision(CreditDecision creditDecision) {
        this.creditDecision = creditDecision;
    }
}
