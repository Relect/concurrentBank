package org.bank;

public class BankAccount {
    private volatile int balance;
    private final int numAccount;
    public BankAccount(int balance, int numAccount) {
        this.balance = balance;
        this.numAccount = numAccount;
    }

    public void deposit(int summ) {
        balance += summ;
    }

    public void withdraw(int summ) {
        balance -= summ;
    }

    public int getBalance() {
        return balance;
    }

    public int getNumAccount() {
        return numAccount;
    }
}
