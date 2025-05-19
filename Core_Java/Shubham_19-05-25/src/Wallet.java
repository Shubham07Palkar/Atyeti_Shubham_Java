import exception.InsufficientBalanceException;
import exception.WalletLimitExceededException;

public class Wallet{
    private String walletId;
    private double balance;
    private static final double DAILY_LIMIT = 100000;

    public Wallet(double balance, String walletId) {
        this.balance = balance;
        this.walletId = walletId;
    }

    public void addMoney(double amount)throws WalletLimitExceededException{
        if(amount + balance>DAILY_LIMIT){
            throw new WalletLimitExceededException("Exceeds Wallet Daily Limit");
        }
        balance +=amount;
    }

    public void withdraw(double amount){
        if(amount > balance){
            throw new InsufficientBalanceException("Insufficient Balance in wallet");
        }
        balance -= amount;
    }

    public double getBalance() {
        return balance;

    }
}
