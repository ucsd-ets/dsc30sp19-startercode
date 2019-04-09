
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CheckingAccountTest {
    private static final double EPSILON = 1e-15;

    CheckingAccount Chad;

    @Before
    public void setup() throws InsufficientFundsException {
        Chad = new CheckingAccount("Chad", 100);
    }

    @Test
    public void testCheckingAccountConstructor() {
        // To use assertEquals on double, need to specify epsilon
        assertEquals("Chad", Chad.getId());
        assertEquals(100, Chad.getBalance(), EPSILON);
    }

    @Test (expected =  InsufficientFundsException.class)
    public void testInitialDepositException() throws InsufficientFundsException {
        Chad = new CheckingAccount("Chad", 0.0);
    }

    @Test
    public void testToString() {
        assertEquals("ID: Chad, Type: Checking, Balance: 100.0", Chad.toString());
    }

    @Test
    public void testResetChecksUsed() throws InsufficientFundsException {
        for (int i = 0; i < 3; i++) {
            Chad.withdrawUsingCheck(1);
        }
        // Make sure 3 checks are used
        assertEquals(3, Chad.getChecksUsed());
        // Reset used checks
        Chad.resetChecksUsed();
        // Make sure 0 check is used
        assertEquals(0, Chad.getChecksUsed());
    }

    @Test
    public void testGetChecksUsed() throws InsufficientFundsException {
        // Make sure 0 check is used
        assertEquals(0, Chad.getChecksUsed());
        // Make sure 1 check is used
        Chad.withdrawUsingCheck(1);
        assertEquals(1, Chad.getChecksUsed());
    }

    @Test
    public void testDeposit() {
        // Deposits $100 to Chad
        assertEquals(200.0, Chad.deposit(100), EPSILON);
        assertEquals(200.0, Chad.getBalance(), EPSILON);
    }

    @Test
    public void testWithdraw() throws InsufficientFundsException {
        Chad.deposit(100);
        // takes 100 away from 200 to get 100
        assertEquals(100, Chad.withdraw(100), EPSILON);
    }

    @Test (expected = InsufficientFundsException.class)
    public void testWithdrawException() throws InsufficientFundsException {
        // Chad has $100 but withdrawing $101 makes 1 below minimum
        Chad.withdraw(101);
    }

    @Test
    public void testWithdrawUsingChecks() throws InsufficientFundsException {
        Chad.withdrawUsingCheck(10);
        assertEquals(90, Chad.getBalance(), EPSILON);

        Chad.withdrawUsingCheck(10);
        assertEquals(80, Chad.getBalance(), EPSILON);

        Chad.withdrawUsingCheck(10);
        assertEquals(70, Chad.getBalance(), EPSILON);

        // After 3 checks used, every check cost $2 check fee
        Chad.withdrawUsingCheck(10);
        assertEquals(58, Chad.getBalance(), EPSILON);

        // Balance is 58 - 60 - 2 = -4, in overdraft, owns (-4) - 35 = -39
        Chad.withdrawUsingCheck(60);
        assertEquals(-39, Chad.getBalance(), EPSILON);
    }

    @Test (expected = InsufficientFundsException.class)
    public void testOverdraftWithCheck() throws InsufficientFundsException {

        Chad.withdrawUsingCheck(150);
        // Overdraft fee is $35, new balance is 100 - 150 - 35 = -85
        assertEquals(-85, Chad.getBalance(), EPSILON);

        // Can't withdraw when in overdraft
        Chad.withdrawUsingCheck(5);
    }

}