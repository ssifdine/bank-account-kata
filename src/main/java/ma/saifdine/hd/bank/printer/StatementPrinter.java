package ma.saifdine.hd.bank.printer;

import ma.saifdine.hd.bank.model.Transaction;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class StatementPrinter {
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    /**
     *
     * @param transactions
     */
    public void printStatement(List<Transaction> transactions) {
        StringBuilder output = new StringBuilder();
        output.append("Date       ||  Amount    || Balance \n");

        for (int i = transactions.size() - 1; i >= 0; i--) {
            Transaction transaction = transactions.get(i);
            output.append(String.format("%s ||  %-10d|| %d",
                    transaction.getDate().format(DATE_FORMATTER),
                    transaction.getAmount(),
                    transaction.getBalance()));
            if (i > 0) {
                output.append("\n");
            }
        }

        System.out.print(output);
    }
}