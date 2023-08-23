package com.klarna.risk.decision.domain;

import com.google.common.collect.Maps;
import jdk.javadoc.doclet.Reporter;

import java.awt.image.ImageProducer;
import java.util.*;
import java.util.stream.Collectors;

/**
 * The implementation of the {@link CreditHistoryRepository} interface.
 */
public class CreditHistoryRepositoryImpl implements CreditHistoryRepository {
    HashMap<String, List<TrasactionDto>> history = new HashMap<>();

    @Override
    public Collection lookupTransactions(String email) {
        return history.get(email).isEmpty() ? Collections.EMPTY_LIST : Arrays.asList(history.get(email));
    }

    @Override
    public Collection lookupTransactions(String email, String reason) {
        return Arrays.asList(history.get(email)).stream().filter(creditDecision -> creditDecision.equals("ok")).collect(Collectors.toList());
    }

    @Override
    public void persistTransaction(String email, int purchaseAmount, CreditDecision creditDecision) {
        TrasactionDto trns = new TrasactionDto(purchaseAmount, creditDecision);
        history.computeIfAbsent(email, k -> new ArrayList<>()).add(new TrasactionDto(purchaseAmount, creditDecision));
    }
}
