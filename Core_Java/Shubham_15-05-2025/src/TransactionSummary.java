public class TransactionSummary {

    public static void main(String[] args) {
        double[] upiTransactions = {500.0, 400.0, 600.0};
        double[] creditCardTransactions = {2000.0, 1400.0};
        double[] debitCardTransactions = {800.0, 600.0, 700.0, 500.0};
        double[] netBankingTransactions = {1200.0};

        System.out.println("--- EOD Transaction Summary---\n");

        double totalAmount = 0;
        int totalTransactions = 0;

        totalAmount += printSummary("UPI",upiTransactions);
        totalTransactions+= upiTransactions.length;

        totalAmount +=printSummary("Credit Card", creditCardTransactions);
        totalTransactions+=creditCardTransactions.length;

        totalAmount +=printSummary("Debit Card", debitCardTransactions);
        totalTransactions+=creditCardTransactions.length;

        totalAmount+=printSummary("Net Banking", netBankingTransactions);
        totalTransactions+= netBankingTransactions.length;


        System.out.println("\n==== overall summary ===");
        System.out.println("Total Transactions : "+totalTransactions);
        System.out.println("Total Amount Spent :"+totalAmount);

    }
        private static double printSummary(String systemName, double[] transactions) {
            double sum = 0;
            for(double amt: transactions){
                sum+=amt;
            }
            System.out.println("System Name : "+systemName);
            System.out.println(" - Transactions: "+transactions.length);
            System.out.println(" - Total Spent: "+sum +"\n");

            return sum;
        }
}
