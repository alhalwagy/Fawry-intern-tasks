package org.example;

import java.util.ArrayList;
import java.util.List;

public class CustomerManager {

    private List<Customer> customers;



    public CustomerManager() {
        this.customers = new ArrayList<>();
    }

    public void  addCustomer(Customer customer){
        customers.add(customer);
    }

    public void removeCustomer(int customerId){
        customers.removeIf(customer -> customer.getId()==customerId);
    }

    public void viewAllCustomers(){

       for(Customer customer :customers){
           System.out.println(customer);
       }

    }

    public List<Customer> getCustomers() {
        return customers;
    }
}
