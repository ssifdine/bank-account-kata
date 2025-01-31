package ma.saifdine.hd.bank.service;

import ma.saifdine.hd.bank.model.Transaction;
import ma.saifdine.hd.bank.printer.StatementPrinter;
import ma.saifdine.hd.bank.repository.TransactionRepository;
import ma.saifdine.hd.bank.utils.Clock;

import java.time.LocalDate;

public class Account implements AccountService {

    private final TransactionRepository transactionRepository; // Références au dépôt de transactions
    private final StatementPrinter statementPrinter;         // Références à l'imprimante de relevés
    private int balance = 0;                                 // Solde du compte
    private final Clock clock;

    /**
     *
     * @param transactionRepository
     * @param statementPrinter
     * @param clock
     */
    public Account(TransactionRepository transactionRepository, StatementPrinter statementPrinter , Clock clock) {
        this.transactionRepository = transactionRepository;
        this.statementPrinter = statementPrinter;
        this.clock = clock;
    }

    @Override
    public void deposit(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
        balance += amount;
        Transaction transaction = new Transaction(clock.today(), amount, balance);
        transactionRepository.addTransaction(transaction);
    }

    @Override
    public void withdraw(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive");
        }
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient funds");
        }
        balance -= amount;
        Transaction transaction = new Transaction(clock.today(), -amount, balance);
        transactionRepository.addTransaction(transaction);
    }

    @Override
    public void printStatement() {
        statementPrinter.printStatement(transactionRepository.getAllTransactions());
    }

    /**
     *
     * @return
     */
    public int getBalance() {
        return balance;
    }
}