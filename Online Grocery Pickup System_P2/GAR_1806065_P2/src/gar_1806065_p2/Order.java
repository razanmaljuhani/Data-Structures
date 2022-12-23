/* Hi teatcher , I hope you'r alawys happy >> Here The solving of ASS2 in Java language . 
The Date of sending :  wednesday , November 13th , 2019 */
// My personal info. >> Name(Razan Muhammed Dakheel Aljohani), ID(1806065), Section(GAR), Email(Raljohani0084@stu.kau.edu.sa) .\
package gar_1806065_p2;

//Orde Class :
public class Order {

    private int orderID;
    private String customerName;
    private String customerID;
    private String orderTime;
    private String[] orderItems;
    private String[] quantIties;
    private String pickupTime;
    private Order next;

//Constructor1 
    public Order() {
    }

//Constructor2
    public Order(int orderID, String customerName, String customerID, String orderTime, String[] orderItems, String[] quantIties, String pickupTime) {
        this.orderID = orderID;
        this.customerName = customerName;
        this.customerID = customerID;
        this.orderTime = orderTime;
        this.orderItems = orderItems;
        this.quantIties = quantIties;
        this.pickupTime = pickupTime;
        this.next = null; //next = null
    }

//Constructor3
    public Order(int orderID, String customerName, String customerID, String orderTime, String[] orderItems, String[] quantIties, String pickupTime, Order next) {
        this.orderID = orderID;
        this.customerName = customerName;
        this.customerID = customerID;
        this.orderTime = orderTime;
        this.orderItems = orderItems;
        this.quantIties = quantIties;
        this.pickupTime = pickupTime;
        this.next = next; // next = next
    }

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Getter and setter methods :
    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public String[] getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(String[] orderItems) {
        this.orderItems = orderItems;
    }

    public String[] getQuantIties() {
        return quantIties;
    }

    public void setQuantIties(String[] quantIties) {
        this.quantIties = quantIties;
    }

    public String getPickupTime() {
        return pickupTime;
    }

    public void setPickupTime(String pickupTime) {
        this.pickupTime = pickupTime;
    }

    public Order getNext() {
        return next;
    }

    public void setNext(Order next) {
        this.next = next;
    }

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Method1 to get OrderItems , with commas and print it .
    public String OrderItems() {
        String str = "";
        for (int i = 0; i < orderItems.length; i++) {
            str = str + orderItems[i] + ", ";
        }
        return str;
    }

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Method2 to get Orders quantIties for Items, with commas an 
    public String quantItyItems() {
        String str = "";
        for (int i = 0; i < quantIties.length; i++) {
            str = str + quantIties[i] + ", ";
        }
        return str;
    }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//toString method :
    @Override
    public String toString() {
        String str = "";
        str = str + "customer ID: " + customerID + "\r\n";
        str = str + "customer name: " + customerName + "\r\n";
        str = str + "order time: " + orderTime + "\r\n";
        str = str + "pickup time: " + pickupTime + "\r\n";
        str = str + "order items: " + OrderItems() + "\r\n";
        str = str + "quantality: " + quantItyItems() + "\r\n";
        return str;
    }

}//end of class
