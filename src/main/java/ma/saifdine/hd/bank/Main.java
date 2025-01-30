package ma.saifdine.hd.bank;

import ma.saifdine.hd.bank.printer.StatementPrinter;
import ma.saifdine.hd.bank.repository.TransactionRepository;
import ma.saifdine.hd.bank.service.Account;
import ma.saifdine.hd.bank.utils.Clock;

public class Main {

    public static void main(String[] args) {

        TransactionRepository transactionRepository = new TransactionRepository();
        StatementPrinter statementPrinter = new StatementPrinter();
        Clock clock = new Clock();
        Account account = new Account(transactionRepository, statementPrinter,clock);

        account.deposit(1000);
        account.deposit(2000);
        account.withdraw(500);
        account.printStatement();
    }
}
