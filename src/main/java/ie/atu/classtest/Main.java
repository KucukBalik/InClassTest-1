package ie.atu.classtest;

import java.util.ArrayList;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Scanner myScan = new Scanner(System.in);

        System.out.println("Menu\n\n");
        System.out.println("1 - Add Order\n");
        System.out.println("2 - Update Order\n");
        System.out.println("3 - Display All Orders\n");
        System.out.println("4 - Exit\n");

        ArrayList<Order> orderObjects = new ArrayList<Order>();

        Order newObject = new Order("Null", "Null", "Null", 0);

        orderObjects.add(new Order("001", "Jake", "Laptop", 4));
        orderObjects.add(new Order("002", "John", "Keyboard", 3));
        orderObjects.add(new Order("003", "Alan", "Mouse", 5));

        Order object1 = orderObjects.get(0);
        Order object2 = orderObjects.get(1);
        Order object3 = orderObjects.get(2);

        String option = myScan.nextLine();

        switch(option){


            case"1":
                System.out.println("Please enter the OrderID");
                String ID = myScan.nextLine();
                try {
                    if (ID == object1.getOrderId() || ID == object2.getOrderId() || ID == object3.getOrderId())
                    {
                        throw new IllegalArgumentException("Invalid objectID , entered ID should be valid!");
                    }
                    System.out.println("Please enter a unique OrderID");
                    ID = myScan.nextLine();
                }
                catch (IllegalArgumentException iae)
                {
                    System.out.println("ERROR: " + iae.getMessage());
                }


                System.out.println("Please enter the Customer Name");
                String Cus = myScan.nextLine();
                System.out.println("Please enter the Product Name");
                String Pro = myScan.nextLine();
                System.out.println("Please enter the Quantity");
                int Qua = myScan.nextInt();

                newObject = new Order(ID, Cus, Pro, Qua);

                orderObjects.add(newObject);

                getDetails(object1);
                getDetails(object2);
                getDetails(object3);
                getDetails(newObject);
                break;

            case"2":
                System.out.println("Please enter the OrderID that you want to UPDATE");
                    ID = myScan.nextLine();

                System.out.println("Please enter the new ORDER ID");
                    String uID = myScan.nextLine();

                System.out.println("Please enter the new Customer Name");
                    Cus = myScan.nextLine();

                System.out.println("Please enter the new Product Name");
                    Pro = myScan.nextLine();

                System.out.println("Please enter the new Quantity");
                    Qua = myScan.nextInt();

                Order updatedObject = new Order(uID, Cus, Pro, Qua);

                if(ID == object1.getOrderId())
                {
                    getDetails(updatedObject);
                    getDetails(object2);
                    getDetails(object3);
                }
                if(ID == object2.getOrderId())
                {
                    getDetails(object1);
                    getDetails(updatedObject);
                    getDetails(object3);
                }
                if(ID == object3.getOrderId())
                {
                    getDetails(object1);
                    getDetails(object2);
                    getDetails(updatedObject);
                }
                break;

            case"3":

                getDetails(object1);
                getDetails(object2);
                getDetails(object3);
                getDetails(newObject);
                break;

            case"4":

                System.out.println("You exit the System");
                break;

            default:
                System.out.println("Please enter valid OPTION");
                break;

        }



    }

    public static void getDetails(Order order)
    {
        System.out.println("Order ID: = " + order.getOrderId());
        System.out.println("Customer Name: = " + order.getCustomerName());
        System.out.println("Product Name = " + order.getProductName());
        System.out.println("Quantity = " + order.getQuantity() + "\n\n");


    }
}