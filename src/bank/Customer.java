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
public class Customer {

    private Name name;
    private Account accounts[];

    public Customer(Name name, int size) {
        this.name = name;
        accounts = new Account[size];
    }

    public int getAccountSize() {
        return accounts.length;
    }

    public void addAccount(Account acct) {
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] == null) {
                accounts[i] = acct;
                break;
            }
        }
    }

    public Account lookUpAnAccount(String number) {
        Account ac = null;

        for (int i = 0; i < accounts.length; i++) {

            ac = accounts[i];
            if (ac != null) {
                if (!ac.getAcctNumber().equals(number)) {
                    ac = null;
                } else {

                    break;
                }

            }
        }
        return ac;
    }

    /**
     * @return the name
     */
    public Name getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(Name name) {
        this.name = name;
    }

    /**
     * @return the account
     */
    public Account[] getAccount() {
        return accounts;
    }

    /**
     * @param account the account to set
     */
    public void setAccount(Account[] account) {
        this.accounts = account;
    }
}
