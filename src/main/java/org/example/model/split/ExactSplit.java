package org.example.model.split;

import org.example.model.User;

public class ExactSplit extends Split {

    public ExactSplit(User user, double amount) {
        super(user);
        this.amount = amount;
    }
}