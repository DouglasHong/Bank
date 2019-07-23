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
public class Company {

    private Revenue revenue;
    private String name;
    private Employee employees[];
    private double lowest;

    /**
     * @return the revenue
     */
    public Revenue getRevenue() {
        return revenue;
    }

    /**
     * @param revenue the revenue to set
     */
    public void setRevenue(Revenue revenue) {
        this.revenue = revenue;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the employees
     */
    public Employee[] getEmployees() {
        return employees;
    }

    /**
     * @param employees the employees to set
     */
    public void setEmployees(Employee[] employees) {
        this.employees = employees;
    }

    /**
     * @return the lowest
     */
    public double getLowest() {
        return lowest;
    }

    /**
     * @param lowest the lowest to set
     */
    public void setLowest(double lowest) {
        this.lowest = lowest;
    }
}
