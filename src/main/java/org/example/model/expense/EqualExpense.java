package org.example.model.expense;

import org.example.model.User;
import org.example.model.split.EqualSplit;
import org.example.model.split.Split;

import java.util.List;

public class EqualExpense extends Expense {

    public EqualExpense(double amount, User expensePaidBy, List<Split> splits, ExpenseData expenseData) {
        super(amount, expensePaidBy, splits, expenseData);
    }

    @Override
    public boolean validate() {
        for(Split split: getSplits()){
            if(!(split instanceof EqualSplit)) return false;
        }
        return true;
    }


}
