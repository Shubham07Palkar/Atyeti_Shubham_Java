import exception.InsufficientBalanceException;
import exception.InvalidUserException;
import exception.WalletLimitExceededException;

import java.util.HashMap;
import java.util.Map;

public class TransactionService {
    private Map<String, User> users= new HashMap<>();
    private Map<String, Wallet> wallets = new HashMap<>();

    public void registerUser(String userId, String name, double initialBalance){
        users.put(userId, new User(userId,name));
        wallets.put(userId, new Wallet(initialBalance,userId));
    }

    public void transfer(String fromUserId, String toUserId, double amount){
        try {
            validateUser(fromUserId);
            validateUser(toUserId);

            Wallet senderWallet = wallets.get(fromUserId);
            Wallet receiverWallet = wallets.get(toUserId);

            senderWallet.withdraw(amount);
            receiverWallet.addMoney(amount);

            System.out.println("Transfered "+ amount + " from "+ fromUserId + " to " + toUserId);
        }catch (InvalidUserException | InsufficientBalanceException | WalletLimitExceededException e){
            System.out.println("Error :"+e.getMessage());
        }finally {
            System.out.println("Transaction attempt Complete.");
        }

    }

    private void validateUser(String userId){
        if(!users.containsKey(userId)){
            System.out.println("User ID "+userId + " is Invalid");
            throw new InvalidUserException("User ID "+userId+" is Invalid. ");
        }
    }


    public void showBalance(String userId){
        Wallet wallet = wallets.get(userId);
        System.out.println(userId + "Wallet Balance :"+wallet.getBalance());
    }
}
