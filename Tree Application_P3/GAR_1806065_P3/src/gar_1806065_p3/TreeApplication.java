/* Hi teatcher , I hope you'r alawys happy >> Here The solving of ASS1 in Java language . 
The Date of sending :  wednesday , November 21th , 2019 */
// My personal info. >> Name(Razan Muhammed Dakheel Aljohani), ID(1806065), Section(GAR), Email(Raljohani0084@stu.kau.edu.sa) .\

package gar_1806065_p3;

import java.util.Scanner;

public class TreeApplication {


    public static void main(String[] args) {
// Make Scanner

        Scanner input = new Scanner(System.in);

        Tree t = new Tree();
// Other variables
        int choice; // user choice
        int value;
        do {
            showMenu();
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("> What value do you want to insert: ");
                    value = input.nextInt();
                    // First, check to see if value already exists in tree. If so, give error message        .
                    if (t.search(value)) {
                        System.out.println("> " + value + " already exists in the tree . Duplicates are not allowed   .");
                    } else {
                        t.insert(value);
                        System.out.println("> " + value + " was successfully inserted into the tree   .");
                    }
                    System.out.println();
                    t.inorder();
                    break;
                case 2:
                    System.out.print("> What value do you want to search for:");
                    value = input.nextInt();
                    if (t.search(value)) {
                        System.out.println("> " + value + " was found in the tree.");

                    } else {
                        System.out.println("> " + value + " was not found in the tree.");
                    }
                    System.out.println();
                    break;
                case 3:
                    System.out.print("> What value do you want to delete: ");
                    value = input.nextInt();
                    // First, check to see if value is actually in the tree.
// IF it is in the tree, delete it.
                    if (t.search(value)) {
                        t.delete(value);
                        System.out.println("> " + value + " was successfully deleted from the tree.");
                        t.inorder();
                        
                    } // ELSE, print message stating that no delete is needed (since value  is not in the tree)
                    else {
                        System.out.println("> " + value + " is not in the tree(no delete needed).");
                    }
                    System.out.println();
                    break;
                case 4:
                    if (t.isEmpty()) {
                        System.out.println("> Error: cannot perform sum (the tree is empty)");
                        System.out.println();
                    } else {
                        System.out.println("> The sum of all nodes is " + t.sumNodes() + ".");
                        System.out.println();
                    }
                    break;
                case 5:
                    System.out.println("> Goodbye!");
                    System.out.println();
                    break;
                default:
                    System.out.println("> Wrong selection. Try again.");
                    System.out.println();
                    break;
            }
        } while (choice != 5);

    }

    public static void showMenu() {
        System.out.println("");
        System.out.println("|-----------------------------------------------|");
        System.out.println("|------ Tree System ------|");
        System.out.println("|-----------------------------------------------|");
        System.out.println("| 1. Construct Tree |");
        System.out.println("| 2. Search for node |");
        System.out.println("| 3. Delete node |");
        System.out.println("| 4. Compute total sum |");
        System.out.println("| 5. Exit |");
        System.out.println("|-----------------------------------------------|");
        System.out.println();
        System.out.print("> Please enter your choice: ");
    }
}
