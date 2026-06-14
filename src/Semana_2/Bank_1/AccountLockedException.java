package Semana_2.Bank_1;

public class AccountLockedException extends Exception {
    public AccountLockedException(String message) {
        super(message);
    }
}