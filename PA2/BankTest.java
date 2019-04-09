import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BankTest {
    private static final double EPSILON = 1e-15;

    Bank bank;

    @Before
    public void setUp() {
        bank = new Bank();
        bank.createCheckingAccount("Checking", 2000);
        bank.createSavingsAccount("Savings", 2000);
    }

    @Test
    public void testSetSavingsInterest() {
        bank.setSavingsInterest(2);
        bank.addInterest();
        assertEquals(2040, bank.getAccount("Savings", false).getBalance(), EPSILON);
    }

    @Test
    public void testGetNumberOfCheckingAccounts() {
        assertEquals(1, bank.getNumberOfCheckingAccounts());
        // Add more checking account
        bank.createCheckingAccount("DSC20", 20);
        assertEquals(2, bank.getNumberOfCheckingAccounts());
    }

    @Test
    public void testGetNumberOfSavingsAccounts() {
        assertEquals(1, bank.getNumberOfSavingsAccounts());
        // Add more savings account
        bank.createSavingsAccount("DSC20", 100);
        assertEquals(2, bank.getNumberOfSavingsAccounts());
    }

    @Test
    public void testCreateCheckingAccount() {
        // Account with lower than initial deposit requirement
        assertFalse(bank.createCheckingAccount("DSC20", 0));

        // This should work
        assertTrue(bank.createCheckingAccount("DSC20", 20));

        // DSC20 already has a checking account
        assertFalse(bank.createCheckingAccount("DSC20", 10));
    }

    @Test
    public void testCreateSavingsAccount() {
        // Account with lower than initial deposit requirement
        assertFalse(bank.createSavingsAccount("DSC20", 99));

        // This should work
        assertTrue(bank.createSavingsAccount("DSC20", 100));

        // DSC20 already has a savings account
        assertFalse(bank.createSavingsAccount("DSC20", 10));
    }

    @Test
    public void testGetAccount() {
        // Get checking account
        Account checking = bank.getAccount("Checking", true);
        assertEquals("Checking", checking.getId());
        assertEquals(2000, checking.getBalance(), EPSILON);

        // Get savings account
        Account savings = bank.getAccount("Savings", false);
        assertEquals("Savings", savings.getId());
        assertEquals(2000, savings.getBalance(), EPSILON);

        // Get an account that does not exist
        assertNull(bank.getAccount("nonExist", true));
    }
    @Test
    public void testDeposit() {
        assertEquals(2100, bank.deposit(true, "Checking", 100), EPSILON);
        assertEquals(2100, bank.deposit(false, "Savings", 100), EPSILON);

        // Deposit to an account that does not exist
        assertNull(bank.deposit(true, "nonExist", 100));
    }

    @Test
    public void testWithdraw() {
        assertEquals(1500, bank.withdraw(true,"Checking", 500), EPSILON);
        assertEquals(1498, bank.withdraw(false, "Savings", 500), EPSILON);

        // Checking doesn't have 20000 in the account, withdraw will return null
        assertNull(bank.withdraw(true,"Checking", 20000));

        // Withdraw from an account that does not exist
        assertNull(bank.withdraw(true,"nonExist", 20));
    }


    @Test
    public void testOnlineTransfer() {
        // From account does not exist
        assertFalse(bank.onlineTransfer("Adam",false, "Savings", false, 1));
        assertFalse(bank.onlineTransfer("Alex",true, "Checking", true, 1));

        // To account does not exist
        assertFalse(bank.onlineTransfer("Checking",true, "Adam", true, 1));
        assertFalse(bank.onlineTransfer("Savings",false, "Alex", false, 1));

        // Both accounts do not exist
        assertFalse(bank.onlineTransfer("Chad",true, "Adam", true, 1));
        assertFalse(bank.onlineTransfer("Don",false, "Alex", false, 1));

        // Checking does not have 3000, this should fail
        assertFalse(bank.onlineTransfer("Checking", true, "Savings", false, 3000));

        // This should work
        assertTrue(bank.onlineTransfer("Savings", false, "Checking", true, 100));
        assertEquals(1898, bank.getAccount("Savings", false).getBalance(), EPSILON);
    }


    @Test
    public void testCheckTransfer() {
        // from account is not checking
        assertFalse(bank.checkTransfer("Savings", false, "Checking", true, 100));

        // from account does not exist
        assertFalse(bank.checkTransfer("Adam",true, "Saving", false,1));

        // to account does not exist
        assertFalse(bank.checkTransfer("Checking",true, "Adam", false, 1));
        assertFalse(bank.checkTransfer("Checking",true, "Adam", true, 1));

        // overdraft from checking once is OK
        assertTrue(bank.checkTransfer("Checking",true, "Savings", false,2001));
        assertEquals(4001, bank.getAccount("Savings", false).getBalance(), EPSILON);
        assertEquals(-36, bank.getAccount("Checking", true).getBalance(), EPSILON);

        // Can not withdraw when checking is already in overdraft
        assertFalse(bank.checkTransfer("Checking",true, "Savings", false,1));
    }

    @Test
    public void testAddInterest() {
        bank.setSavingsInterest(2);
        bank.addInterest();
        assertEquals(2040, bank.getAccount("Savings", false).getBalance(), EPSILON);
    }
}
