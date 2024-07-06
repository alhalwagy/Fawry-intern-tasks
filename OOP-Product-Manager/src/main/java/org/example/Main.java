package org.example;


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        CustomerManager customerManager = new CustomerManager();
        ProductManager productManager = new ProductManager();
        OrderManager orderManager = new OrderManager();

        while (true) {
            System.out.println("\n--- E-Commerce Application ---");
            System.out.println("1. Add a new product");
            System.out.println("2. Remove a product");
            System.out.println("3. View all products");
            System.out.println("4. Add a new customer");
            System.out.println("5. Remove a customer");
            System.out.println("6. View all customers");
            System.out.println("7. Create a new order");
            System.out.println("8. View all orders");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");

            try {


                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        System.out.print("Enter product id: ");
                        int productId = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter product name: ");
                        String productName = scanner.nextLine();

                        System.out.print("Enter product description: ");
                        String description = scanner.nextLine();

                        System.out.print("Enter product price: ");
                        double productPrice = scanner.nextDouble();

                        System.out.print("Enter product stock quantity: ");
                        int quantity = scanner.nextInt();

                        Product product = new Product(productId, productName, description, productPrice, quantity);
                        productManager.addProduct(product);
                        break;

                    case 2:
                        System.out.print("Enter product id to remove: ");
                        int rpid = scanner.nextInt();
                        productManager.removeProduct(rpid);
                        break;

                    case 3:
                        productManager.viewAllProducts();
                        break;

                    case 4:
                        System.out.print("Enter customer id: ");
                        int cid = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter customer name: ");
                        String cname = scanner.nextLine();
                        System.out.print("Enter customer email: ");
                        String cemail = scanner.nextLine();
                        System.out.print("Enter customer address: ");
                        String caddress = scanner.nextLine();
                        Customer customer = new Customer(cid, cname, cemail, caddress);
                        customerManager.addCustomer(customer);
                        break;

                    case 5:
                        System.out.print("Enter customer id to remove: ");
                        int removeCid = scanner.nextInt();
                        customerManager.removeCustomer(removeCid);
                        break;

                    case 6:
                        customerManager.viewAllCustomers();
                        break;
                    case 7:
                        System.out.print("Enter order id: ");
                        int oid = scanner.nextInt();
                        System.out.print("Enter customer id: ");
                        int orderCid = scanner.nextInt();
                        Customer customerOrder = null;

                        for (Customer c : customerManager.getCustomers()) {

                            if (c.getId() == orderCid) {
                                customerOrder = c;
                                break;
                            }

                        }
                        if (customerOrder == null) {
                            System.out.println("Customer not found");
                            break;
                        }

                        List<Product> orderProducts = new ArrayList<>();
                        while (true) {
                            System.out.print("Enter product id to add to order (or 0 to finish): ");
                            int orderPid = scanner.nextInt();
                            if (orderPid == 0) break;
                            Product orderProduct = null;
                            for (Product p : productManager.getProducts()) {
                                if (p.getId() == orderPid) {
                                    orderProduct = p;
                                    break;
                                }
                            }
                            if (orderProduct == null) {
                                System.out.println("Product not found");
                                continue;
                            }
                            orderProducts.add(orderProduct);
                        }
                        Order order = new Order(oid, customerOrder, orderProducts);
                        orderManager.addOrder(order);
                        break;

                    case 8:
                        orderManager.viewAllOrders();
                        break;

                    case 9:
                        System.out.println("Exiting..................................");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice");

                }
            }catch (InputMismatchException e) {
                System.out.println("Invalid input. Please choose another choice from 0 to 9 as numbers.");
               break;
            }

        }
    }
}