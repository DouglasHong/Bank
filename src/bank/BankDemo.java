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
public class BankDemo {

    public static void main(String a[]) {
        BankDemo bankdemo = new BankDemo();
        Customer c = bankdemo.createCustomer();
        bankdemo.printCustomer(c);
        bankdemo.calculateInterest(c, "acct#2");
        bankdemo.creditDebit(c);
        bankdemo.calculateInterests(c);
    }

    public BankDemo() {

    }

    public void printCustomer(Customer c) {
        Account[] accounts = c.getAccount();
        for (int i = 0; i < accounts.length; i++) {
            Balance bal = accounts[i].getBal();
            AccountType accttype = accounts[i].getAcct();
            Name name = c.getName();
            String acctnumber = accounts[i].getAcctNumber();
            System.out.println(name.getFirstname() + name.getLastname() + " has an account type of"
                    + accttype.getType() + " with a balance of $"
                    + bal.getBalance() + " and an account number of " + acctnumber);

        }
    }

    public Customer createCustomer() {
        Name name = new Name("Douglas", " Hong");

        Customer c = new Customer(name, 3);
        int numberofaccounts = c.getAccountSize();
        for (int i = 0; i < numberofaccounts; i++) {
            Balance bal = new Balance(15 + i);

            AccountType acctype = new AccountType(" good account type " + i);

            Account account = new Account(bal, acctype, "acct#" + i);
            c.addAccount(account);

        }
        return c;
    }

    public void creditDebit(Customer c) {
        String acctnumber = "acct#2";
        Account a = c.lookUpAnAccount(acctnumber);
        if (a != null) {
            double curBal = a.getBal().getBalance();
            a.credit(55);
            double newBal = a.getBal().getBalance();
            System.out.println("Current balance is $" + curBal + " and the new balance is $"
                    + newBal);
            curBal = a.getBal().getBalance();
            boolean success = a.debit(100);
            newBal = a.getBal().getBalance();
            if (success == true) {
                System.out.println("Current balance is $" + curBal + " and the new balance is $"
                        + newBal);
            } else {
                System.out.println("Withdraw denied");
            }
        } else {
            System.out.println(acctnumber + " IS NOT FOUND!!!");
        }

    }

    public void calculateInterest(Customer c, String number) {

        Account acc = c.lookUpAnAccount(number);

        if (acc == null) {
            System.out.println("Account not found");

        } else {
            System.out.println("The balance for this account was $" + acc.getBal().getBalance());
            double newInterest = acc.calculateInterest(5, 2);
            System.out.println("After the interest calcualations, your new balance for this account is $"
                    + acc.getBal().getBalance() + " and the interest is $" + newInterest);
        }

    }

    public void calculateInterests(Customer c) {
        Account[] accounts = c.getAccount();
        Name name = c.getName();
        System.out.println(name.getFirstname() + " " + name.getLastname() + " has interest for all accounts");
        for (int i = 0; i < accounts.length; i++) {
            Account account = accounts[i];
            calculateInterest(c, account.getAcctNumber());

        }
    }
}
