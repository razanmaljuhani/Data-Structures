/* Hi teatcher , I hope you'r alawys happy >> Here The solving of ASS2 in Java language . 
The Date of sending :  wednesday , November 13th , 2019 */
// My personal info. >> Name(Razan Muhammed Dakheel Aljohani), ID(1806065), Section(GAR), Email(Raljohani0084@stu.kau.edu.sa) .\
package gar_1806065_p2;

import java.io.*;

//OnlineGroceryStack Class :
public class OnlineGroceryStack {

    private Order top;

// Constructor:
    public OnlineGroceryStack() {
        top = null;
    }

    //Below are MANY methods that are used on stacks.
    //* Examples: isEmpty, PUSH, POP, PEEK, and more. */
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Method1 isEmpty : >> if front = null then the Queue is empty 
    public boolean isEmpty() {
        return top == null;
    }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Method2 PrintStack :
    public void PrintStack(PrintWriter output)throws Exception {
        PrintStack(top, output);
    }

    private void PrintStack(Order top, PrintWriter output) throws Exception{
// We need a pointer to traverse and print data of the node .
        Order pointer = top;
        while (pointer != null) {
            System.out.println(pointer.toString());
            output.println(pointer.toString());
            pointer = pointer.getNext();
        }
        System.out.println();
        output.println();
    }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Method3  push : insert items in Stack .
    public void push(int orderID, String customerName, String customerID, String orderTime, String[] orderItems, String[] quantIties, String pickupTime) {
        top = push(top, orderID, customerName, customerID, orderTime, orderItems, quantIties, pickupTime);
    }

    private Order push(Order top, int orderID, String customerName, String customerID, String orderTime, String[] orderItems, String[] quantIties, String pickupTime) {
// Make a new Order with "data" as the data value
// and set the "next" of this new node to the same  address as top 
// * This is the same as addToFront() method for Linked Lists.
        top = new Order(orderID, customerName, customerID, orderTime, orderItems, quantIties, pickupTime, top);
// Now, return the newly updated top.
        return top;
    }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Method4  pop : delete items in Stack .
    public Order pop() {
// Save a reference to the current top node(because we  will change where top points to )
        Order temp = top;

// This method will return a new top node.
        top = pop(top);
// Finally, return temp, which is the previous top node that we just "popped" off the list.
        return temp;
    }

    private Order pop(Order top) {
// Set top equal to the next node.
// This will make top point to the 2nd node instead of the first node  .
        top = top.getNext();
        // return the address/reference of the new top node
        return top;
    }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Method5 peek : return the top value .
    public String peek() {
// Invoke the peek method with top as a parameter
        String topValue = peek(top);
        return topValue;
    }

    private String peek(Order top) {
// Return the data value of the top node.
// You can see that we do NOT pop. We are only returning the data value   .
        return top.toString();
    }

}//end of class
