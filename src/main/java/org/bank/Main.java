package org.bank;

public class Main {
    public static void main(String[] args) {
        ConcurrentBank bank = new ConcurrentBank();

        BankAccount account1 = bank.createAccount(1000);
        BankAccount account2 = bank.createAccount(500);

        Thread transfer1 = new Thread(() -> bank.transfer(account1, account2, 200));
        Thread transfer2 = new Thread(() -> bank.transfer(account2, account1, 100));

        transfer1.start();
        transfer2.start();

        try {
            transfer1.join();
            transfer2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("total balance: " + bank.getTotalBalance());
    }
}