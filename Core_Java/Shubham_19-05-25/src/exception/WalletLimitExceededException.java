package exception;

public class WalletLimitExceededException extends RuntimeException{
    public WalletLimitExceededException(String message){
        super(message);
    }
}
