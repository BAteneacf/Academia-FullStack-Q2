package Semana_2.Bank_1;

public class Main {
    public static void main(String[] args) {
        BankAccount cuenta1 = new BankAccount(1000.00);
        BankAccount cuenta2 = new BankAccount(500.00);

        // Operaciones válidas
        try {
            cuenta1.deposit(500);
            System.out.printf("Deposito exitoso. Saldo: $%.2f%n", cuenta1.getBalance());

            cuenta1.withdraw(200);
            System.out.printf("Retiro exitoso. Saldo: $%.2f%n", cuenta1.getBalance());

            cuenta1.transfer(cuenta2, 300);
            System.out.printf("Transferencia exitosa. Saldo cuenta1: $%.2f, cuenta2: $%.2f%n",
                    cuenta1.getBalance(), cuenta2.getBalance());
        } catch (InsufficientBalanceException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\n=== Manejo de Errores ===");

        // Captura individual de Unchecked Exception
        try {
            cuenta1.deposit(-100);
        } catch (InvalidAmountException e) {
            System.out.println("Error detectado: " + e.getMessage());
        }

        // Captura de Checked Exception con datos propios (deficit)
        try {
            cuenta1.withdraw(999999);
        } catch (InsufficientBalanceException e) {
            System.out.printf("Error detectado: %s (deficit: $%.2f)%n",
                    e.getMessage(), e.getDeficit());
        }

        System.out.println("\n=== Demostración de Multi-Catch ===");
        try {
            cuenta1.withdraw(50000);
        } catch (InsufficientBalanceException | InvalidAmountException e) {
            System.out.println("[MULTI-CATCH] Se interceptó un error en el sistema: " + e.getMessage());
        }
    }
}
