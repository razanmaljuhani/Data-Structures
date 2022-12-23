/* Hi teatcher , I hope you'r alawys happy >> Here The solving of ASS2 in Java language . 
The Date of sending :  wednesday , November 13th , 2019 */
// My personal info. >> Name(Razan Muhammed Dakheel Aljohani), ID(1806065), Section(GAR), Email(Raljohani0084@stu.kau.edu.sa) .\
package gar_1806065_p2;

import java.util.*;
import java.io.*;
import java.time.*;

public class OnlineOrderMenu {

//Static Object of OnlineGroceryQueue class >
    static OnlineGroceryQueue myQueue = new OnlineGroceryQueue();

//Static Object of OnlineGroceryStack class >   
    static OnlineGroceryStack myStack = new OnlineGroceryStack();

    public static void main(String args[]) throws Exception {
// Make Scanner
        Scanner input = new Scanner(System.in);
        PrintWriter output = new PrintWriter("output.txt");
// Other variables
        int choice; // user choice
        do {
            showMenu(output);
            choice = input.nextInt();
            output.println(choice);
            switch (choice) {

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                //1. Add a new order 
                //This selection will allow the customer to request a new order using OnlineGroceryQueue.java and order.java. 
                //Note: the system should check whether the pickup time is not less than 2 hours from the order time (in Metod Add_Order)
                case 1:
                    Add_Order(input, output); //Call Add_Order Method
                    System.out.println("");
                    output.println();
                    break;

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                //2. Lookup the first order 
                //This selection will display the next order to be fulfilled
                case 2:
                    if (myQueue.isEmpty()) {
                        System.out.println(">>> Error: Cannot peek Queue(Queue is empty ).");
                        output.println(">>> Error: Cannot peek Queue(Queue is empty ).");
                    } else {
                        System.out.println("The first Order information   : ");
                        output.println("The first order information: ");
                        System.out.println("");
                        output.println("");
                        //Method peek return the front of the Queue , which is return the frist Order
                        System.out.println(myQueue.peek());
                        output.println(myQueue.peek());
                    }
                    System.out.println();
                    output.println("");
                    break;

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                //3. Fulfill order 
                //It consist of tow options 
                //If the user choice is 1, the system should display only the first order that should be fulfilled, remove it from the queue and push it into the stack. 
                //If the choice is 2, the user has to specify the number of orders that the system has to fulfill. 
                //The program should remove those orders from the queue and push them into the stack
                case 3:
                    if (myQueue.isEmpty()) {
                        System.out.println(">>> Error: Cannot peek Queue(Queue is empty ).");
                        output.println(">>> Error: Cannot peek Queue(Queue is empty ).");
                    } else {
                        System.out.println("Please select your option: ");
                        output.println("Please select your option: ");
                        System.out.println("     1. Fulfill one order");
                        output.println("     1. Fulfill one order");
                        System.out.println("     2. Fulfill multiple orders");
                        output.println("     2. Fulfill multiple orders");
                        choice = input.nextInt();
                        output.println(choice);

                        //1. Fulfill one order
                        if (choice == 1) {
                            System.out.println("The first order information: ");
                            output.println("The first order information: ");
                            System.out.println("");
                            output.println("");

                            //Call Fulfill_Order Method for choice 1 to Fulfill one order
                            Fulfill_Order(1, output);
                            System.out.println("The order is fulfilled!");
                            output.println("The order is fulfilled!");

                            //2. Fulfill multiple orders
                        } else if (choice == 2) {
                            System.out.print("Please enter the number of orders that you would like to fulfill: ");
                            output.println("Please enter the number of orders that you would like to fulfill: ");
                            int numOfOrder = input.nextInt();
                            output.println(numOfOrder);
                            System.out.println("The orders information:");
                            output.println("The orders information:");

                            //Call Fulfill_Order Method for choice 2 to Fulfill multiple orders
                            Fulfill_Order(numOfOrder, output);
                            System.out.println("The orders above are fulfilled!!");
                            output.println("The orders above are fulfilled!!");
                        }
                        System.out.println();
                        output.println();
                    }
                    break;

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                //4. Restock orders 
                //This selection will allow the store to restock the orders. 
                //This method will print out all the orders in the queue. 
                //Then your program should ask for the number of restocking orders to be made. 
                //If the number is greater than the number of queue elements, the system should warn the user.   
                case 4:
                    if (myQueue.isEmpty()) {
                        System.out.println(">>> Error: Cannot peek Queue(Queue is empty ).");
                        output.println(">>>> Error: Cannot peek Queue(Queue is empty ).");
                    } else {
                        System.out.println("All waiting orders: ");
                        output.println("All waiting orders: ");
                        myQueue.PrintQueue(output);//Printing All Waiting Orders

                        System.out.print("Please enter the number Of orders to restock   : ");
                        output.print("Please enter the number Of orders to restock   : ");
                        int restockNumber = input.nextInt();
                        output.println(restockNumber);
                        if (restockNumber <= myQueue.getNumOrders()) {

                            //Call Restock Method for the restock Number .
                            Restock_Order(restockNumber, output);

                            System.out.println("The order(s) restocked successfully!");
                            System.out.println("");
                            System.out.println("____________________________________________________________ ");
                            System.out.println("");
                            output.println("The order(s) restocked successfully!");
                            output.println("");
                            output.println("____________________________________________________________ ");
                            output.println("");

                        } else if (restockNumber > myQueue.getNumOrders()) {
                            System.out.println("Can’t restock the orders, the number of orders is less than your input  !!!");
                            output.println("Can’t restock the orders, the number of orders is less than your input  !!!");
                        }
                    }
                    break;

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                //5. Print orders
                //This selection will allow the user to print the orders that are waiting to be fulfilled first from the queue.
                //In addition, this method should print out the fulfilled orders from the stack.   
                case 5:
                    if (myQueue.isEmpty()) {
                        System.out.println(">>> Error: Cannot print nodes(the Queue is empty )");
                        System.out.println();
                        output.println(">>> Error: Cannot print nodes(the Queue is empty )");
                        output.println();
                    } else {
                        System.out.println("Orders did not fulfill yet:");
                        System.out.println("");
                        System.out.println("The orders information: ");
                        System.out.println("");
                        output.println("Orders did not fulfill yet:");
                        output.println("");
                        output.println("The orders information: ");
                        output.println("");

                        //Printing All Orders that did not fulfill yet , that is in Queue .
                        myQueue.PrintQueue(output);

                        System.out.println("------------------------");
                        System.out.println("Already Fulfilled orders: ");
                        System.out.println("");
                        System.out.println("The orders information: ");
                        output.println("------------------------");
                        output.println("Already Fulfilled orders: ");
                        output.println("");
                        output.println("The orders information: ");

                        //Printing All Orders that fulfilled  , that is in Stack .
                        myStack.PrintStack(output);

                        System.out.println("");
                    }
                    break;

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                //6. Exit.
                case 6:
                    System.out.println("> Goodbye!");
                    System.out.println();
                    output.println("> Goodbye!");
                    output.println();
                    break;

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                default:
                    System.out.println(">>> Wrong selection...Try again.  ");
                    System.out.println();
                    output.println(">>> Wrong selection...Try again.  ");
                    output.println();
                    break;

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            }//end switch
        } while (choice != 6);
        output.close();//Closing The Output File .
    }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Method1 showMenu .
    public static void showMenu(PrintWriter output) throws Exception {

        System.out.println("|-----------------------------------------------|");
        System.out.println("|-------- Online Grocery Pickup System ---------|");
        System.out.println("|-----------------------------------------------|");
        System.out.println("| 1. Add a new order |");
        System.out.println("| 2. Lookup the first order|");
        System.out.println("| 3. Fulfill order |");
        System.out.println("| 4. Restock orders |");
        System.out.println("| 5. Print Orders |");
        System.out.println("| 6. Exit |");
        System.out.println("|-----------------------------------------------|");
        System.out.println();
        System.out.print("Please enter your choice: ");

        output.println("|-----------------------------------------------|");
        output.println("|-------- Online Grocery Pickup System ---------|");
        output.println("|-----------------------------------------------|");
        output.println("| 1. Add a new order |");
        output.println("| 2. Lookup the first order|");
        output.println("| 3. Fulfill order |");
        output.println("| 4. Restock orders |");
        output.println("| 5. Print Orders |");
        output.println("| 6. Exit |");
        output.println("|-----------------------------------------------|");
        output.println();
        output.print("Please enter your choice: ");
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Method2 add_Order: .
    public static void Add_Order(Scanner input, PrintWriter output) throws Exception {

        System.out.println("Please enter the order information:");
        output.println("Please enter the order information:");
        System.out.println("");
        output.println("");
//Order information :
        System.out.print("\ncustomer ID: ");
        output.print("\ncustomer ID: \n");
        String customerID = input.next();
        output.println(customerID);

        System.out.print("\ncustomer name: ");
        output.print("\ncustomer name: \n");
        String customerName = input.next();
        output.println(customerName);

        System.out.print("\norder time: ");
        output.print("\norder time: \n");
        String orderTime = input.next();// FOR EXAMPLE 12:20
        output.println(orderTime);
        String t1[] = orderTime.split(":");

        System.out.print("\npickup time: ");
        output.print("\npickup time: \n");
        String pickupTime = input.next();
        output.println(pickupTime);
        String t2[] = pickupTime.split(":");

        //Metods of Class LacalTime : 
        LocalTime orderTimeFormatt = LocalTime.of(Integer.parseInt(t1[0]), Integer.parseInt(t1[1]), 0); //hour , minute and second 
        LocalTime pickupTimeFormatt = LocalTime.of(Integer.parseInt(t2[0]), Integer.parseInt(t2[1]), 0);//hour , minute and second 

        System.out.print("\norder items: ");
        output.print("\norder items: \n");
        String orderItems = input.next();// FOR EXAMPLE potato,tomato, etc
        output.println(orderItems);
        String[] orders = orderItems.split(",");

        System.out.print("\nquantality: ");
        output.print("\nquantality: \n");
        String quantIties = input.next(); // FOR EXAMPLE 4kg,3kg, etc
        output.println(quantIties);
        String[] quanti = quantIties.split(",");

        // The Duration between OrderTime and PickupTime
        Duration duration = Duration.between(orderTimeFormatt, pickupTimeFormatt);

//Cheack if duration more than or equals 2  then We can ADD Order
        if (duration.toHours() >= 2) {
            myQueue.enqueue(customerName, customerID, orderTime, orders, quanti, pickupTime);
            System.out.println("The order is added!");
            output.println("The order is added!\n");
//if duration less than 2 Can not ADD Order
        } else if (duration.toHours() < 2) {
            System.out.println("Can’t add the order because the order pick-up time less than 2 hours!!!");
            output.println("Can’t add the order because the order pick-up time less than 2 hours!!!\n");
        }
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Method3 Fulfill_Order : .
    public static void Fulfill_Order(int numOfOrder, PrintWriter output) throws Exception {
        for (int i = 0; i < numOfOrder; i++) {
            System.out.println(myQueue.peek());//frist : Print the information of order/s that we choice to fulfill .
            output.println(myQueue.peek());
            Order temp = myQueue.dequeue();// then delete tha temp (Order/s) from the Queue .

            //then Push the Ordar/s in the stack  :
            myStack.push(temp.getOrderID(), temp.getCustomerName(), temp.getCustomerID(), temp.getOrderTime(), temp.getOrderItems(), temp.getQuantIties(), temp.getPickupTime());
        }
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Method4 Restock_order
    public static void Restock_Order(int restookNumber, PrintWriter output) throws Exception {
        for (int i = 0; i < restookNumber; i++) {
            Order temp = myQueue.dequeue();//delete tha temp (Order/s) from the Queue .
            //then insert the Ordar/s in the Queue  :
            myQueue.enqueue(temp.getCustomerName(), temp.getCustomerID(), temp.getOrderTime(), temp.getOrderItems(), temp.getQuantIties(), temp.getPickupTime());
            myQueue.PrintQueue(output);

        }
    }

}//end of class
