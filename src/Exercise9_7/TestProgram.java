package Exercise9_7;

public class TestProgram {
    /* Write a test program that creates an Account object with an account ID of 1122,
        a balance of $20,000, and an annual interest rate of 4.5%.
        Use the withdraw method to withdraw $2,500, use the deposit method to deposit $3,000,
        and print the balance, the monthly interest, and the date when this account was created.
    */
    public static void main(String[] args) {
        // Create account with an ID of 1122, a balance of 20,000 and an annual interest rate of 4.5%
        Account testAccount = new Account(1122, 20000.0);
        testAccount.setAnnualInterestRate(4.5);

        // Use the withdraw method to withdraw $2,500, use the deposit method to deposit $3,000
        testAccount.withdraw(2500.0);
        testAccount.deposit(3000.0);

        // Print the balance, the monthly interest, and the date when this account was created.
        System.out.println("Account ID: " + testAccount.getId());
        System.out.printf("Current Balance: $%,.2f%n", testAccount.getBalance());  // format as floating point with commas and 2 digits after decimal
        System.out.printf("Monthly Interest: $%,.2f%n", testAccount.getMonthlyInterest()); // format as floating point with commas and 2 digits after decimal
        System.out.println("Date Created: " + testAccount.getDateCreated()); // no special formatting of date
    }
}
