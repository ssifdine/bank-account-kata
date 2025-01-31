package ma.saifdine.hd.bank.service;

import ma.saifdine.hd.bank.printer.StatementPrinter;
import ma.saifdine.hd.bank.repository.TransactionRepository;
import ma.saifdine.hd.bank.utils.Clock;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.assertEquals;

public class AccountTest {
    private Account account;
    private TransactionRepository transactionRepository;
    private StatementPrinter statementPrinter;
    private Clock clock;

    @Before
    public void setUp() {
        transactionRepository = new TransactionRepository();
        statementPrinter = new StatementPrinter();
        clock = new Clock();
        account = new Account(transactionRepository, statementPrinter, clock);
    }

    @Test
    public void testDeposit() {
        account.deposit(1000);
        assertEquals(1000, account.getBalance());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDepositNegativeAmount() {
        account.deposit(-100);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithdrawNegativeAmount() {
        account.withdraw(-100);
    }

    @Test
    public void testWithdraw() {
        account.deposit(1000);
        account.withdraw(500);
        assertEquals(500, account.getBalance());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithdrawMoreThanBalance() {
        account.deposit(1000);
        account.withdraw(1500);
    }

    @Test
    public void testBankStatement() {
        // Capture System.out
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        try {
            account.deposit(1000); // 10-01-2012
            account.deposit(2000); // 13-01-2012
            account.withdraw(500); // 14-01-2012

            account.printStatement();

            String expectedOutput = "Date       ||  Amount    || Balance \n" +
                                    "14/01/2012 ||  -500      || 2500\n" +
                                    "13/01/2012 ||  2000      || 3000\n" +
                                    "10/01/2012 ||  1000      || 1000";

            assertEquals(expectedOutput, outContent.toString());
        } finally {
            System.setOut(originalOut);
        }
    }
}