package Firstpackage;

public class BankAccount {
	private int accountNumber;
    private String accountHolderName;
    private double accountBalance;

    public BankAccount(int accountNumber, String accountHolderName, double accountBalance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.accountBalance = accountBalance;
    }

    public void deposit(double amount) {
        accountBalance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= accountBalance) {
            accountBalance -= amount;
        }
    }

    public void displayAccountInfo() {
        System.out.println("Enter Account Number: " + accountNumber);
        System.out.println(" Enter Account Holder Name: " + accountHolderName);
        System.out.println("Account Balance : " + accountBalance);
    }

	public static void main(String[] args) {
	
        BankAccount account = new BankAccount(123456789, "Ankit Yadav", 1000.0);

        account.deposit(10000.0);

        account.withdraw(2000.0);

        
        account.displayAccountInfo();
	

	}

}
