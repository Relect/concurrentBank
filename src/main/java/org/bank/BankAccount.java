package org.bank;

public class BankAccount {
    private volatile int balance;

    public BankAccount(int balance) {
        this.balance = balance;
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
}
