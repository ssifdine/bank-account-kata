package ma.saifdine.hd.bank.repository;

import ma.saifdine.hd.bank.model.Transaction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TransactionRepository {

    private final List<Transaction> transactions = new ArrayList<>();  // Liste pour stocker les transactions

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);  // Ajoute une transaction à la liste
    }

    public List<Transaction> getAllTransactions() {
        List<Transaction> result = new ArrayList<>(transactions);
//        Collections.reverse(result);
        return result; // Retourne une copie de la liste des transactions
    }
}
