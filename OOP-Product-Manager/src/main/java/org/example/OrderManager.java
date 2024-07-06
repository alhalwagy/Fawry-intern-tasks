package org.example;

import java.util.ArrayList;
import java.util.List;

public class OrderManager {

    private List<Order> orders;



    public OrderManager() {
        this.orders = new ArrayList<>();
    }

    public void addOrder(Order order){
        orders.add(order);
    }

    public void removeOrder(int orderId){
       orders.removeIf(order -> order.getId() == orderId);
    }

    public void viewAllOrders(){

      for(Order order:orders){

          System.out.println(order);

      }

    }



}
