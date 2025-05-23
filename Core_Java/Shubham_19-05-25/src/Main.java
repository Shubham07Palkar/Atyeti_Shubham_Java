//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
            TransactionService transactionService = new TransactionService();
            transactionService.registerUser("U100", "Alice", 5000);
            transactionService.registerUser("U200", "Bob", 4000);

            transactionService.showBalance("U100");
            transactionService.showBalance("U200");

            transactionService.transfer("U100", "U200", 2000);

            //fails for insufficient
            transactionService.transfer("U100", "U200", 4000);

            //fails Invalid user
            transactionService.transfer("U200", "U300", 5000);

            //fails for exceed limit
            transactionService.transfer("U100", "U200", 95000);

        }
    }
