package com.klarna.risk.decision.domain;

import org.checkerframework.checker.units.qual.C;

/**
 * The implementation of the {@link CreditDecisionMaker} interface.
 */
public class CreditDecisionMakerImpl implements CreditDecisionMaker {




    @Override
    public CreditDecision makeCreditDecision(int purchaseAmount, int currentCustomerDebt) {

        if(purchaseAmount<0) {
            return CreditDecision.MAX_AMOUNT_BREACH;
        }

        if(currentCustomerDebt+purchaseAmount>1000) {
            return  CreditDecision.DEBT;
        }

        currentCustomerDebt=currentCustomerDebt-purchaseAmount;

        return CreditDecision.ACCEPTED;
    }

}
