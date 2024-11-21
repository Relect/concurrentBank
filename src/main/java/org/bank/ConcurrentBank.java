package org.bank;

import java.util.ArrayList;
import java.util.List;

public class ConcurrentBank {
    private final List<BankAccount> accounts = new ArrayList<>();

    public BankAccount createAccount(int summ) {
        BankAccount account = new BankAccount(summ);
        accounts.add(account);
        return account;
    }
    public void transfer(BankAccount from, BankAccount to, int summ) {
        from.withdraw(summ);
        to.deposit(summ);
    }
    public int getTotalBalance() {
        int result = 0;
        for (BankAccount account: accounts) {
            result += account.getBalance();
        }
        return result;
    }
}
