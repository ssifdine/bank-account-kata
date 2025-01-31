package ma.saifdine.hd.bank.model;

import java.time.LocalDate;

public class Transaction {

    private final LocalDate date; // Date de la transaction
    private final int amount;     // Montant de la transaction
    private final int balance;    // Solde apres la transaction

    /**
     *
     * @param date
     * @param amount
     * @param balance
     */
    public Transaction(LocalDate date, int amount, int balance) {
        this.date = date;
        this.amount = amount;
        this.balance = balance;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getAmount() {
        return amount;
    }

    public int getBalance() {
        return balance;
    }
}
