import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SavingsAccountTest {
    private static final double EPSILON = 1e-15;
    SavingsAccount Alex;
    SavingsAccount Adam;

    @Before
    public void setUp() throws Exception {
        Alex = new SavingsAccount("Alex", 100);
        Adam = new SavingsAccount("Adam", 5000);
    }

    @Test
    public void testSavingsAccountConstructor() {
        // To use assertEquals on double, need to specify epsilon
        assertEquals("Alex", Alex.getId());
        assertEquals(100, Alex.getBalance(), EPSILON);

        // Adam should have $100 bonus because his initial deposit is 5000
        assertEquals("Adam", Adam.getId());
        assertEquals(5100, Adam.getBalance(), EPSILON);
    }

    @Test(expected = InsufficientFundsException.class)
    public void testConstructorInsufficientFundsException() throws InsufficientFundsException {
        // Min initial deposit is 100 for saving account
        Alex = new SavingsAccount("Alex", 99);
    }

    @Test
    public void testToString() {
        assertEquals("ID: Alex, Type: Savings, Balance: 100.0", Alex.toString());
        assertEquals("ID: Adam, Type: Savings, Balance: 5100.0", Adam.toString());
    }

    @Test
    public void testDeposit() {
        // Deposit $100 to Alex's account
        assertEquals(200, Alex.deposit(100), EPSILON); // test return value
        assertEquals(200, Alex.getBalance(), EPSILON); // test new balance
    }

    @Test
    public void testWithdraw() throws InsufficientFundsException{
        // Withdraw $25 from Alex's account, new balance should be 5100 - 100 - 2 = 4998
        assertEquals(4998, Adam.withdraw(100), EPSILON); // test return value
        assertEquals(4998, Adam.getBalance(), EPSILON); // test new balance
    }

    @Test(expected = InsufficientFundsException.class)
    public void testWithdrawInsufficientFundsException() throws InsufficientFundsException {
        // Adam's withdrawal puts his balance under 100 (110 - 9 - 2 = 99 < 100)
        Adam = new SavingsAccount("Adam", 110);
        Adam.withdraw(9);
    }

    @Test
    public void testAddInterest() {
        // Add 2% interest to Alex, 100 * (1 + 2 / 100) = 102
        assertEquals(102, Alex.addInterest(2), EPSILON); // test return value
        assertEquals(102, Alex.getBalance(), EPSILON); // test new balance
    }
}