/* Hi teatcher , I hope you'r alawys happy >> Here The solving of ASS1 in Java language . 
The Date of sending :  wednesday , November 21th , 2019 */
// My personal info. >> Name(Razan Muhammed Dakheel Aljohani), ID(1806065), Section(GAR), Email(Raljohani0084@stu.kau.edu.sa) .
package gar_1806065_p3;

public class Node {

    private int data;
    private Node left;
    private Node right;

// CONSTRUCTORS
    public Node() {
        data = 0;
        left = right = null;
    }

    public Node(int data) {
        this.data = data;
        left = right = null;
    }

    public Node(int data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

// ACCESSORS
    public int getData() {
        return data;

    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

// MUTATORS
    public void setData(int data) {
        this.data = data;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
