package org.example.service;

import org.example.model.ExpenseType;
import org.example.model.User;
import org.example.model.expense.*;
import org.example.model.split.PercentSplit;
import org.example.model.split.Split;


import java.util.List;

public class ExpenseService {

    public static Expense createExpense(ExpenseType expenseType, double amount,
                                        User expensePaidBy, List<Split> splits, ExpenseData expenseData) {
        switch (expenseType) {
            case EXACT:
                return new ExactExpense(amount, expensePaidBy, splits, expenseData);
            case PERCENT:
                for (Split split : splits) {
                    PercentSplit percentSplit = (PercentSplit) split;
                    split.setAmount((amount*percentSplit.getPercent())/100.0);
                }
                return new PercentageExpense(amount, expensePaidBy, splits, expenseData);
            case EQUAL:
                int totalSplits = splits.size();
                double splitAmount = ((double) Math.round(amount*100/totalSplits))/100.0;
                for (Split split : splits) {
                    split.setAmount(splitAmount);
                }
                return new EqualExpense(amount, expensePaidBy, splits, expenseData);
            default:
                return null;
        }
    }
}
