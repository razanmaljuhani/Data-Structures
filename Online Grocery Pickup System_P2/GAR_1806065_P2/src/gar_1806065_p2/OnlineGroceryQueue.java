/* Hi teatcher , I hope you'r alawys happy >> Here The solving of ASS2 in Java language . 
The Date of sending :  wednesday , November 13th , 2019 */
// My personal info. >> Name(Razan Muhammed Dakheel Aljohani), ID(1806065), Section(GAR), Email(Raljohani0084@stu.kau.edu.sa) .\
package gar_1806065_p2;

import java.io.*;

//OnlineGroceryQueue Class :
public class OnlineGroceryQueue {

    private Order front;
    private Order back;
    private int numOrders;

// Constructor 
    public OnlineGroceryQueue() {
        front = null;
        back = null;
        numOrders = 0;
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//getter and setter methods:
    public int getNumOrders() {
        return numOrders;
    }

    public void setNumOrders(int numOrders) {
        this.numOrders = numOrders;
    }

    public Order getFront() {
        return front;
    }

    public void setFront(Order front) {
        this.front = front;
    }

    public Order getBack() {
        return back;
    }

    public void setBack(Order back) {
        this.back = back;
    }

//Below are MANY methods that are used on stacks.
//Examples: isEmpty, PUSH, POP, PEEK, and more.
    
    
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Method1 isEmpty : >> if front = null then the Queue is empty 
    public boolean isEmpty() {
        return front == null;
    }

    
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Method2 PrintQueue :
    public void PrintQueue(PrintWriter output) throws Exception {
        PrintQueue(front, output);
    }

    private void PrintQueue(Order front, PrintWriter output) throws Exception {
// We need a pointer to traverse and print data of the node .
        Order pointer = front;
        while (pointer != null) {
            System.out.println(pointer.toString());
            output.println(pointer.toString());
            pointer = pointer.getNext();
        }
        System.out.println();
        output.println();
    }

    
    
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//Method3  enqueue : inserting items in Queue .
    public void enqueue(String customerName, String customerID, String orderTime, String[] orderItems, String[] quantIties, String pickupTime) {
        if (isEmpty()) {
            front = back = enqueue(front, back, customerName, customerID, orderTime, orderItems, quantIties, pickupTime);
        } else {
            back = enqueue(front, back, customerName, customerID, orderTime, orderItems, quantIties, pickupTime);
        }
    }

    private Order enqueue(Order front, Order back, String customerName, String customerID, String orderTime, String[] orderItems, String[] quantIties, String pickupTime) {
// Make a new Order with "data" as the data value
        numOrders++; //evrey items insert in Queue , Queue items is incresing .

        Order temp = new Order(numOrders, customerName, customerID, orderTime, orderItems, quantIties, pickupTime);

// Now, if the list is empty, return the reference for temp
// and save this reference into both "front" and "back"
// Since this is the only node in the queue, it will be the front and back node
        if (isEmpty()) {
            return temp;
        } // ELSE, the queue is not empty. We need to insert temp at the back of the queue.
        // So save the address of the new node into the next of back.
        // Finally, return the updated node.
        else {
            back.setNext(temp);
            return temp;
        }
    }

    
    
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Method4 void | dequeue : deleting items from Queue .
    public Order dequeue() {
        Order temp = front;
        front = dequeue(front);
        if (front == null) {
            back = null;
        }
        return temp;
    }

    private Order dequeue(Order front) {
        front = front.getNext();
        numOrders--;//evrey items delete from Queue , Queue items is decreasing .
        return front;
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//Method5 peek : return the top value  .
    public String peek() {
// Invoke the peek method with front as a parameter
        String frontValue = peek(front);

        return frontValue;
    }

    private String peek(Order front) {
// Return the data value of the front node.
// You can see that we do NOT dequeue. We are only returning the data value.
        return front.toString();

    }

}//end of class 
