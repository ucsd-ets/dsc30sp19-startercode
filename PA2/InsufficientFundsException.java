/**
 * Exception defined for Banking Application
 */
public class InsufficientFundsException extends Exception {
    public InsufficientFundsException(){}

    public InsufficientFundsException(String message){
        super(message);
    }
}
