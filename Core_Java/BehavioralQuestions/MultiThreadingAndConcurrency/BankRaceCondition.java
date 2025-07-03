package com.Collections.BehavioralQuestions.MultiThreadingAndConcurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class BankAccount{
    private int balance = 10000;

    public synchronized void withdraw(String name,int amount){
        if(balance>=amount){
            System.out.println(name + " is trying to withdraw "+amount);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            balance -= amount;
            System.out.println(name + " successfully Withdrawn "+amount+" remaining: "+balance);
        }else {
            System.out.println(name + " tried to withdraw but insufficient balance: "+balance);
        }
    }

    public synchronized void deposit(String name, int amount){
        System.out.println(name+" is depositing "+ amount);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        balance+=amount;
        System.out.println("Successfully deposited "+ amount+" balance is "+balance);
    }

    public int getBalance() {
        return balance;
    }
}
class DepositThread extends Thread{
    private BankAccount account;
    private String name;
    private int amount;

    public DepositThread(BankAccount account, int amount, String name) {
        this.account = account;
        this.amount = amount;
        this.name = name;
    }

    public void run(){
        account.deposit(name, amount);
    }
}

class WithdrawThread extends Thread{
    private BankAccount acc;
    private String name;
    private int amount;

    public WithdrawThread(BankAccount acc, String name, int amount) {
        this.acc = acc;
        this.name = name;
        this.amount = amount;
    }

    public void run(){
        acc.withdraw(name,amount);
    }
}




public class BankRaceCondition {
    public static void main(String[] args) throws InterruptedException {
        BankAccount account = new BankAccount();
//        Thread w1 = new WithdrawThread(account, "WithdrawThread-1",4000);
//        Thread w2 = new WithdrawThread(account,"WithdrawThread-2", 2000);
//        Thread w3 = new WithdrawThread(account, "WithdrawThread-3", 3000);
//        Thread w4 = new WithdrawThread(account, "WithdrawThread-4",3000);
//
//        Thread d1 = new DepositThread(account,2000, "DepositThread-1");
//        Thread d2 = new DepositThread(account,4000, "DepositThread-2");
//
//
//        w1.start();
//        d1.start();
//        w2.start();
//        d2.start();
//        w3.start();
//
//        w1.join();
//        w2.join();
//        w3.join();
//        w4.join();
//        d1.join();
//        d2.join();
//
//        System.out.println("\n Final Balance: "+account.getBalance());

        ExecutorService service = Executors.newFixedThreadPool(4);

        service.submit(()->account.withdraw("WithdrawTask-1",4000));
        service.submit(()->account.withdraw("WithdrawTask-2",4000));
        service.submit(()->account.withdraw("WithdrawTask-3", 4000));

        service.submit(()->account.deposit("DepositTask-1",3000));
        service.submit(()->account.deposit("DepositTask-2",3000));
        service.shutdown();

        while(!service.isTerminated()){

        }
        System.out.println("Final Balance: "+account.getBalance());
    }
}
