package Exercise9_7;

import java.util.Date;

public class Account {
    // Data fields
    private int id;                     // default 0
    private double balance;             // default 0
    private double annualInterestRate;  // current interest rate, default 0.0 (as a percent, e.g., 4.5)
    private final Date dateCreated;     // date when account is created, added "final" per IntelliJ hint to make immutable after construction

    // No-arg constructor (default account)
    public Account() {
        this.id = 0;
        this.balance = 0.0;
        this.annualInterestRate = 0.0;
        this.dateCreated = new Date(); // current date/time
    }

    // constructor to create an account with specified ID and account balance
    public Account(int id, double balance) {
        this.id = id;
        this.balance = balance;
        this.annualInterestRate = 0.0;
        this.dateCreated = new Date();
    }

    // accessor methods for id, balance, annualInterestRate, dateCreated
    public int getId() {
        return id;
    }
    public double getBalance() {
        return balance;
    }
    public double getAnnualInterestRate() {
        return annualInterestRate;
    }
    public Date getDateCreated() {
        return dateCreated;
    }

    // mutators for id and annualInterestRate
    public void setId(int id) {
        this.id = id;
    }
    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    // A method named getMonthlyInterestRate() that returns the monthly interest rate.
    public double getMonthlyInterestRate() {
        return (annualInterestRate / 100.0) / 12.0;  // divide by 100 for percent and by 12 for monthly rate
    }

    // A method named getMonthlyInterest() that returns the monthly interest.
    public double getMonthlyInterest() {
        return balance * getMonthlyInterestRate();
    }

    // A method named withdraw that withdraws a specified amount from the account.
    public void withdraw(double amount) {
        balance -= amount;
    }

    // A method named deposit that deposits a specified amount to the account.
    public void deposit(double amount) {
        balance += amount;
    }
}