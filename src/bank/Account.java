/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

/**
 *
 * @author Douglas
 */
public class Account {

    private AccountType acct;
    private String acctNumber;
    private Balance bal;

    public Account(Balance bal, AccountType acct, String acctnumber) {
        this.acct = acct;
        this.bal = bal;
        this.acctNumber = acctnumber;
    }

    public void credit(double amt) {
        double curBal = bal.getBalance();
        double newBal = curBal + amt;
        bal.setBalance(newBal);

    }

    public double calculateInterest(double intRate, int time) {
        double interest = bal.getBalance() * intRate * time;
        addInterest(interest);
        return interest;
    }

    public void addInterest(double interest) {
        double newbalance = bal.getBalance() + interest;
        bal.setBalance(newbalance);
    }

    public boolean debit(double amt) {
        boolean success = false;
        double curBal = bal.getBalance();
        if (curBal <= amt) {
            System.out.println("your current balance is " + curBal + ", but you can't withdraw $"
                    + amt + " since it's too much");

        } else {
            success = true;
            double newBal = curBal - amt;
            bal.setBalance(newBal);
        }
        return success;
    }

    /**
     * @return the acct
     */
    public AccountType getAcct() {
        return acct;
    }

    /**
     * @param acct the acct to set
     */
    public void setAcct(AccountType acct) {
        this.acct = acct;
    }

    /**
     * @return the acctNumber
     */
    public String getAcctNumber() {
        return acctNumber;
    }

    /**
     * @param acctNumber the acctNumber to set
     */
    public void setAcctNumber(String acctNumber) {
        this.acctNumber = acctNumber;
    }

    /**
     * @return the bal
     */
    public Balance getBal() {
        return bal;
    }

    /**
     * @param bal the bal to set
     */
    public void setBal(Balance bal) {
        this.bal = bal;
    }
}
