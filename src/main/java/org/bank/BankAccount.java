package org.bank;

public class BankAccount {
    private volatile int balance;
    private final int numAccount;
    public BankAccount(int balance, int numAccount) {
        this.balance = balance;
        this.numAccount = numAccount;
    }

    public synchronized void deposit(int summ) {
        balance += summ;
    }

    public synchronized void withdraw(int summ) {
        balance -= summ;
    }

    public int getBalance() {
        return balance;
    }

    public int getNumAccount() {
        return numAccount;
    }
}
