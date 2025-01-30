package ma.saifdine.hd.bank.service;

public interface AccountService {

    /**
     * Methode pour deposer de l'argent
     * @param amount
     */
    void deposit(int amount);

    /**
     * Methode pour retirer de l'argent
     * @param amount
     */
    void withdraw(int amount);

    /**
     * Methode pour imprimer le releve de compte
     */
    void printStatement();
}
