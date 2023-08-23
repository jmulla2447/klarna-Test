package com.klarna.risk.decision.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

public class CreditDecisionMakerTest {

    @Test
    public void purchaseAmountNegative() {
        CreditDecisionMakerImpl creditDecisionMaker = new CreditDecisionMakerImpl();
        CreditDecision decision = creditDecisionMaker.makeCreditDecision(-200,20);
        assertEquals(decision,CreditDecision.DEBT);
    }

    @Test
    public void currentCustomerDebtVeryHigh() {
        CreditDecisionMakerImpl creditDecisionMaker = new CreditDecisionMakerImpl();
        CreditDecision decision = creditDecisionMaker.makeCreditDecision(200,1000);
        assertEquals(decision.isAccepted(),false);
        assertEquals(decision.getReason(),"debt");
    }

    @Test
    public void customerdebtExceededWithPurchaseAmount() {
        CreditDecisionMakerImpl creditDecisionMaker = new CreditDecisionMakerImpl();
        CreditDecision decision = creditDecisionMaker.makeCreditDecision(800,400);
        assertEquals(decision.isAccepted(),false);
        assertEquals(decision.getReason(),"debt");
    }


    @Test
    public void purchaseAmountExceedsAllowedDebt() {
        CreditDecisionMakerImpl creditDecisionMaker = new CreditDecisionMakerImpl();
        CreditDecision decision = creditDecisionMaker.makeCreditDecision(1800,0);
        assertEquals(decision.isAccepted(),false);
        assertEquals(decision.getReason(),"amount");
    }


    @Test
    public void purchaseAmountNotExceedingDebt() {
        CreditDecisionMakerImpl creditDecisionMaker = new CreditDecisionMakerImpl();
        CreditDecision decision = creditDecisionMaker.makeCreditDecision(400,400);
        assertEquals(decision.isAccepted(),true);
        assertEquals(decision.getReason(),"ok");
    }

    @Test
    public void purchaseAmountNotExactlyEqualTodebt() {
        CreditDecisionMakerImpl creditDecisionMaker = new CreditDecisionMakerImpl();
        CreditDecision decision = creditDecisionMaker.makeCreditDecision(600,399);
        assertEquals(decision.isAccepted(),true);
        assertEquals(decision.getReason(),"ok");
    }








}
