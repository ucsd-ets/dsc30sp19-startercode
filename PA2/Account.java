/**
 * Abstract account class defines a bank accounts id, and the amount in the account(balance)
 * A default constructor, get methods, and a deposit method must be implemented here.
 *
 * Abstract methods defining toString and withdraw operations are left for subclasses to implement
 */
public abstract class Account {
    protected String id; //Unique account identifier
    protected double balance; // stores the current balance

    /**
     * Even though an abstract class cannot be directly instantiated, this constructor
     * will be used from a sub-class's constructor.
     *
     * @param id The identifier associated with this Account
     * @param balance The starting balance for this new bank account
     */
    public Account(String id, double balance){
        // TODO
    }

    /**
     * Returns the account id
     * @return the account identifier
     */
    public String getId(){
        // TODO
        return null;
    }

    /**
     * Returns the current balance.
     * @return  the balance of the account
     */
    public double getBalance() {
        // TODO
        return 0.0;
    }

    /**
     * This method will be implemented in the subclasses to return a string that contains the id
     * the type of account (Checking or Savings), and balance.
     *
     * For example, if the user id is "ghosh", account type is checking account, and balance is "120.30",
     * the string returned will be as follows (identical punctuation and spaces):
     * ID: ghosh, Type: Checking, Balance: 120.30
     *
     * @return a String that represents this account
     */
    public abstract String toString();

    /**
     * Deposits into this account
     *
     * @param amount the amount the user wishes to put into their account
     * @return the new balance
     */
    public double deposit(double amount) {
        // TODO
        return 0.0;
    }

    /**
     * This method will be implemented in the subclasses to allow withdrawal from this account
     *
     * @param amount the amount the user wishes to take from their account
     * @return the remaining balance*/
    public abstract double withdraw(double amount) throws InsufficientFundsException;
}
