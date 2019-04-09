/**
 * The CheckingAccount class extends Account.
 * This account does not give any interest.
 * It allows deposit and withdrawals with no fees.
 * The balance cannot go bellow $0 through a withdrawal. after which they cannot withdraw again
 *      until they deposit enough to cover their overdraft fee.
 *
 * A checking account also allows the users to use checks may be used to make withdrawals.
 * The first three checks are free, but subsequent uses add a fee of $2 to each check withdrawal.
 * Checks are allowed to take the balance negative (i.e., an overdraft).
 * If the balance goes negative the user incurs an overdraft fee of $35.
 * If the balance is negative we do not allow any additional withdrawals until enough money is
 * deposited to cover the fee.
 */
public class CheckingAccount extends Account {

    private int numberOfChecksUsed; // stores the number of checks used.
    private boolean inOverdraft; // Indicates if the account is currently having negative balance

    /**
     * Constructor for our banks checking accounts
     *
     * @param id The identifier associated with this Checking Account
     * @param initialDeposit The starting balance for this new Checking Account
     * @throws InsufficientFundsException if initialDeposit is too low
     */
    public CheckingAccount(String id, double initialDeposit) throws InsufficientFundsException{
        // TODO
    }

    /**
     * This method makes the numberOfChecksUsed zero
     */
    public void resetChecksUsed(){
        // TODO
    }

    /**
     * This method returns the numberOfChecksUsed.
     * @return the number of checks used this month
     */
    public int getChecksUsed(){
        // TODO

        return 0;
    }

    /**
     * Returns a string that contains the id, the type of account (Checking or Savings), and balance.
     * For example, if the user id is "ghosh", account type is checking account, and balance is "120.30",
     * the string returned will be as follows (identical punctuation and spaces):
     * ID: ghosh, Type: Checking, Balance: 120.30
     * @return the String that represents this checking account
     */
    public String toString() {
        String id = "";
        double balance = 0.0;

        // TODO: set both local variables to proper value

        return "ID: " + id + ", Type: Checking, Balance: " + balance;
    }

    /**
     * Overrides the deposit method. Adds money to the checking account and check if it covers negative balance.
     *
     * @param amount The amount the customer wishes to add to the account
     * @return The updated balance in the account
     */
    @Override
    public double deposit(double amount) {
        // TODO

        return 0.0;
    }

    /**
     * Implements abstract withdraw method.
     * Rejects withdrawal if the withdrawal would put the account bellow $0 and throws an exception.
     * Rejects withdrawal if the account is in overdraft and throws an exception
     *
     * @param amount The amount the customer wishes to redeem from the account.
     * @throws InsufficientFundsException if withdrawal would put account under $0, with a message
     *                                      indicating either the maximum amount they could withdraw
     *                                    if the account is in overdraft, with a message indicating
     *                                      the minimum amount they must deposit to make a withdrawal.
     * @return The balance left in the account
     */
    public double withdraw(double amount) throws InsufficientFundsException{
        // TODO

        return 0.0;
    }


    /**
     * Method pulls money from the users account when someone cashes their check.
     *
     * If the account is in overdraft reject the check and inform the check writer(id) of how much they need to deposit
     * to make withdrawals.
     *
     * Otherwise this check can withdraw any amount of money. If it puts the account balance bellow $0 place the account
     * in overdraft.
     *
     * If the check writer has already used up his free checks, there is an additional $2 fee for this withdrawal.
     *
     * @param amount The amount the customer wishes to withdraw from his account
     * @throws InsufficientFundsException if the account is in overdraft, with a message indicating
     *                                        the minimum amount they must deposit to make a withdrawal.
     * @return the remaining balance in the account*/
    public double withdrawUsingCheck(double amount) throws InsufficientFundsException{
        // TODO

        return 0.0;
    }
}
