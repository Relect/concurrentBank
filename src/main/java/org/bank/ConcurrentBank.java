package org.bank;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class ConcurrentBank {
    private AtomicInteger numAccount = new AtomicInteger(0);
    private final List<BankAccount> accounts = new ArrayList<>();
    private final ReentrantLock locker = new ReentrantLock();

    public BankAccount createAccount(int summ) {
        BankAccount account = new BankAccount(summ, numAccount.incrementAndGet());
        accounts.add(account);
        return account;
    }
    public void transfer(BankAccount from, BankAccount to, int summ) {
        if (from.getNumAccount() < to.getNumAccount()) {
            from.withdraw(summ);
            to.deposit(summ);
        } else  {
            to.deposit(summ);
            from.withdraw(summ);
        }


    }
    public int getTotalBalance() {
        int result = 0;
        for (BankAccount account: accounts) {
            result += account.getBalance();
        }
        return result;
    }
}
