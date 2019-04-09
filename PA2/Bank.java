import java.util.ArrayList;

/**
 * The Bank class acts as the interface between a user and their money.
 * The Bank consists of an ArrayList of accounts and a interest rate for savings accounts.
 * Through this class users can create accounts, deposit to accounts,
 * withdraw from accounts, and transfer between accounts.
 */
public class Bank {
    private ArrayList<Account> accounts; // Structure holding all accounts.
    private double savingsInterestRate; // The interest rate given to savings account holders as a percent

    /**
     * Default constructor creates an empty accounts Array List and set initial interest rate to 0%
     */
    public Bank() {
        // TODO
    }

    /**
     * Sets the savings interest rate
     * @param rate The rate which will be the new savings interest rate
     */
    public void setSavingsInterest(double rate) {
        // TODO
    }

    /**
     * Returns the number of checking accounts this bank has
     * @return the number of checking accounts in this bank
     */
    public int getNumberOfCheckingAccounts() {
        // TODO
        return 0;
    }

    /**
     * Returns the number of savings accounts this bank has
     * @return the number of savings accounts in this bank
     */
    public int getNumberOfSavingsAccounts() {
        // TODO
        return 0;
    }

    /**
     * Helper method to get the checking account associated with accountID
     *
     * @param accountID the id of the account to obtain
     * @return If there exists an checking account with accountID return it. Otherwise return null
     */
    private Account getCheckingAccount(String accountID) {
        // TODO

        return null;
    }

    /**
     * Helper method to get the savings account associated with accountID
     *
     * @param accountID the id of the account to obtain
     * @return If there exists an savings account with accountID return it. Otherwise return null
     */
    private Account getSavingsAccount(String accountID) {
        // TODO

        return null;
    }

    /**
     * Creates a checking account with the given accountID and returns true or false depending on success.
     * You also need to print the proper message in each case, check write up for more details.
     *
     * The accountID must not already be taken and the initialDeposit must be greater than $0
     *
     * @param accountID The id the user wants associated to this new account.
     * @param initialDeposit The starting balance of the new account in dollars
     * @return True if account created successfully. False if not.
     */
    public boolean createCheckingAccount(String accountID, double initialDeposit) {
        String successMSG = "Successully created checking account for " + accountID  + ".";
        String failMSG = accountID + " ALREADY HAD A CHECKING ACCOUNT!";
        String minimumMSG = "THE MINIMUM INITIAL DEPOSIT FOR A CHECKING ACCOUNT WAS NOT MET!";

        // TODO

        return false;
    }

    /**
     * Creates a savings account with the given accountID and returns true or false depending on success.
     * You also need to print the proper message in each case, check write up for more details.
     *
     * The accountID must not already be taken and the initialDeposit must be greater than $100
     *
     * @param accountID The id the user wants associated to this new account.
     * @param initialDeposit The starting balance of the new account in dollars
     * @return True if account created successfully. False if not.
     */
    public boolean createSavingsAccount(String accountID, double initialDeposit) {
        String successMSG = "Successully created savings account for " + accountID  + ".";
        String failMSG = accountID + " ALREADY HAD A SAVINGS ACCOUNT!";
        String minimumMSG = "THE MINIMUM INITIAL DEPOSIT FOR A CHECKING ACCOUNT WAS NOT MET!";

        // TODO

        return false;
    }

    /**
     * Helper method to get the account and print proper messages if no account is found.
     *
     * @param accountID the given accountID
     * @param isChecking true if is checking account, false otherwise
     * @return the proper account
     */
    public Account getAccount(String accountID, boolean isChecking) {
        String noCheckingMSG = accountID + " DOES NOT HAVE A CHECKING ACCOUNT!";
        String noSavingsMSG = accountID + " DOES NOT HAVE A SAVINGS ACCOUNT!";

        // TODO

        return null;
    }

    /**
     * Adds money to the account associated with accountID
     *
     * @param isChecking true if deposit to checking, false if to savings
     * @param accountID the id of the account to add money too
     * @param amount the amount of dollars to add to the account
     * @return The new balance of the account after deposit. Null if no account exists with accountID
     */
    public Double deposit(boolean isChecking, String accountID, double amount)  {
        // TODO

        return null;
    }

    /**
     * Removes money from the account associated with accountID
     *
     * @param isChecking true if withdraw from checking, false if from savings
     * @param accountID the id of the account to take money from
     * @param amount the amount of dollars to add to the account
     * @return The new balance of the account after withdrawal. Null if no account exists with accountID
     */
    public Double withdraw(boolean isChecking, String accountID, double amount) {

        // TODO

        return null;
    }

    /**
     * Moves money from an account to another account via "online" transfer. No check fees are charged.
     *
     * If either account does not exist the transfer will fail.
     * If the fromAccount does not have enough funds or rejects the withdrawal for any other reason the transfer fails.
     *
     * @param fromAccountID the id of the account to take money from
     * @param isFromChecking true if transfer from checking, false if from savings
     * @param toAccountID the id of the account to put money in
     * @param isToChecking true if transfer to checking, false if to savings
     * @param amount the amount of dollars to add to the account
     * @return Whether or not the transfer succeeded.
     */
    public boolean onlineTransfer(String fromAccountID, boolean isFromChecking, String toAccountID,
                                  boolean isToChecking, double amount) {
        // TODO

        return false;
    }

    /**
     * Moves money from an account to another account using a "check."
     *
     * If the from account is not a checking account the transfer will fail.
     * If either account does not exist the transfer will fail.
     * If the fromAccount does not have enough funds or rejects the withdrawal for any other reason the transfer fails.
     *
     * @param fromAccountID the id of the account to take money from
     * @param toAccountID the id of the account to put money in
     * @param amount the amount of dollars to add to the account
     * @return Whether or not the transfer succeeded.
     */
    public boolean checkTransfer(String fromAccountID,boolean isFromChecking, String toAccountID,
                                 boolean isToChecking, double amount) {
        String shouldUseCheckingMSG = fromAccountID + " SHOULD USE A CHECKING ACCOUNT!"
        // TODO

        return false;
    }

    /**
     * Adds interest to every savings account.
     */
    public void addInterest() {
        // TODO
    }

    /**
     * First, if accountID has a checking account, print its information. Then, if accountID has a savings account,
     * print its information. Check write up for more details.
     *
     * @param accountID the id of the account to obtain
     */
    public void printAccount(String accountID) {
        // TODO
    }

}
