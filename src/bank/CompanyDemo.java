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
public class CompanyDemo {

    public static void main(String args[]) {
        CompanyDemo c = new CompanyDemo();
        Companies companies = c.createCompanies(3);

        double total = c.calculateTotal(companies);
        System.out.println("The total revenue is " + total);
        c.printCompanies(companies);

        Company[] compar = companies.getCompany();
        for (int i = 0; i < compar.length; i++) {
            Company company = compar[i];
            Employee[] employees = company.getEmployees();
            Employee employee = c.calculateHighest(employees);
            System.out.println(employee.getName() + " in this " + company.getName() + " has the highest salary of " + employee.getSalary().getSalary());
        }
        for (int j = 0; j < compar.length; j++) {
            Company company = compar[j];
            Employee[] ems = company.getEmployees();
            double average = c.calculateAverage(ems);
            System.out.println(company.getName() + " has an average salary of " + average);
        }
        c.calculateLowestSalary(compar);

    }

    public void printCompanies(Companies c) {
        Company[] companies = c.getCompany();
        for (int i = 0; i < companies.length; i++) {
            Company company = companies[i];
            String name = company.getName();
            double revenue = company.getRevenue().getAmount();
            System.out.println(name + " has a revenue of " + revenue);
            Employee[] employees = company.getEmployees();
            for (int j = 0; j < employees.length; j++) {
                Employee employee = employees[j];
                System.out.println(employee.getName() + " has a salary of " + employee.getSalary().getSalary());
            }
        }

    }

    public double calculateTotal(Companies c) {
        double total = 0;
        Company[] companies = c.getCompany();
        for (int i = 0; i < companies.length; i++) {
            Company company = companies[i];
            double revenue = company.getRevenue().getAmount();
            total = total + revenue;

        }
        return total;
    }

    public Companies createCompanies(int n) {
        Company[] companies = new Company[n];
        for (int i = 0; i < companies.length; i++) {
            Company company = new Company();
            Revenue revenue = new Revenue();
            revenue.setAmount(n + i);
            company.setName("company " + i);
            company.setRevenue(revenue);
            Employee[] employees = createEmployees(i + 1);
            company.setEmployees(employees);
            companies[i] = company;
        }
        Companies companies2 = new Companies();
        companies2.setCompany(companies);
        return companies2;

    }

    public Employee[] createEmployees(int e) {
        Employee[] employees = new Employee[e];
        for (int i = 0; i < employees.length; i++) {
            Employee employee = new Employee();
            Salary salary = new Salary();
            salary.setSalary(e * i + 15);
            employee.setName("Name" + i);
            employee.setSalary(salary);
            employees[i] = employee;
        }
        return employees;
    }

    public Employee calculateHighest(Employee[] e) {
        double currentHighest = 0;
        Employee retEm = null;
        for (int i = 0; i < e.length; i++) {
            Employee em = e[i];
            double salary = em.getSalary().getSalary();
            if (salary > currentHighest) {
                currentHighest = salary;
                retEm = em;
            }
        }
        return retEm;
    }

    public double calculateAverage(Employee[] es) {
        double total = 0;
        int nume = 0;
        double average = 0;
        for (int i = 0; i < es.length; i++) {
            Employee e = es[i];
            total = total + e.getSalary().getSalary();
            nume = nume + 1;
        }
        average = total / nume;
        return average;
    }

    public void calculateLowestSalary(Company[] cs) {
        Company[] lowestCom = new Company[cs.length];
        for (int i = 0; i < cs.length; i++) {
            Company company = cs[i];
            Employee[] employees = company.getEmployees();
            double lowest = 0;
            for (int j = 0; j < employees.length; j++) {
                Employee e = employees[j];
                double salary = e.getSalary().getSalary();
                if (j == 0) {
                    lowest = salary;
                    company.setLowest(lowest);
                    lowestCom[i] = company;
                }
                if (salary < lowest) {
                    lowest = salary;
                    company.setLowest(lowest);
                    lowestCom[i] = company;
                }

            }

        }
        double ccl = 0;
        Company co = null;
        for (int k = 0; k < lowestCom.length; k++) {
            co = lowestCom[k];
            double salary = co.getLowest();
            if (k == 0) {
                ccl = co.getLowest();
            }
            if (salary < ccl) {
                ccl = salary;

            }

        }
        System.out.println(co.getName() + " has the lowest salary of " + co.getLowest());
    }
}
