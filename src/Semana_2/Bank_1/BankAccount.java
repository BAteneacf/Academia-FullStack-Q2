package Semana_2.Bank_1;

public class BankAccount {
    private double balance;
    private boolean locked;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
        this.locked = false;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new InvalidAmountException("El monto a depositar debe ser mayor a cero: " + amount);
        }
        this.balance += amount;
    }

    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount <= 0) {
            throw new InvalidAmountException("Monto invalido: " + amount);
        }
        if (amount > this.balance) {
            double deficit = amount - this.balance;
            throw new InsufficientBalanceException("Fondos insuficientes para el retiro.", deficit);
        }
        this.balance -= amount;
    }

    public void transfer(BankAccount target, double amount) throws InsufficientBalanceException {
        try (TransactionLog logger = new TransactionLog()) {
            this.withdraw(amount);
            logger.log("Retiro de transferencia exitoso de la cuenta origen por: $" + amount);

            target.deposit(amount);
            logger.log("Depósito de transferencia exitoso en la cuenta destino por: $" + amount);
        }
    }

    public void lock() { this.locked = true; }
    public boolean isLocked() { return locked; }
    public double getBalance() { return balance; }
}