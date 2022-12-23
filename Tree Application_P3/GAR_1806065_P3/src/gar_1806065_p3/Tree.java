/* Hi teatcher , I hope you'r alawys happy >> Here The solving of ASS1 in Java language . 
The Date of sending :  wednesday , November 21th , 2019 */
// My personal info. >> Name(Razan Muhammed Dakheel Aljohani), ID(1806065), Section(GAR), Email(Raljohani0084@stu.kau.edu.sa) .\
package gar_1806065_p3;


public class Tree {

    private Node root;

// CONSTRUCTORS
    public Tree() {
        root = null;
    }

    /* Below are MANY methods that are used on Binary Search Trees.
*
* Examples:
* search, insert, delete, isEmpty, minVal, maxVal, inorder, sumNodes, and many
more
     */
//
// boolean | isEmpty()
//
    public boolean isEmpty() {
        return root == null;
    }

//
// boolean | search(int)
//
    public boolean search(int data) {
        return search(root, data);
    }
//
// boolean | search(Node, int)
//

    private boolean search(Node p, int data) {
        if (p == null) {
            return false;
        } else {
// if the data we are searching for is found at p (at the current root)
            if (data == p.getData()) {
                return true;
            } else if (data < p.getData()) {
                return search(p.getLeft(), data);
            } else {
                return search(p.getRight(), data);
            }

        }
    }

//
// void | insert(int)
//
    public void insert(int data) {
        Node newNode = new Node(data);

        root = insert(root, newNode);
    }
//
// Node | insert(Node, Node)
//

    private Node insert(Node p, Node newNode) {
// IF there is no tree, newNode will be the root, so just return it
        if (p == null) {
            return newNode;
        } // ELSE, we have a tree. Insert to the right or the left
        else {
// Insert to the RIGHT of root
            if (newNode.getData() > p.getData()) {
// Recursively insert into the right subtree
// The result of insertion is an updated root of the right subtree 
                Node temp = insert(p.getRight(), newNode);
// Save this newly updated root of right subtree into p.right
                p.setRight(temp);
            } // Insert to the LEFT of root
            else {
// Recursively insert into the left subtree
// The result of insertion is an updated root of the left subtree 
                Node temp = insert(p.getLeft(), newNode);
// Save this newly updated root of left subtree into p.left
                p.setLeft(temp);
            }
        }
// Return root of updated tree
        return p;
    }

//
// void | inorder()
//
    public void inorder() {
        inorder(root);
    }
//
// void | inorder(Node)
//

    private void inorder(Node p) {
        if (p != null) {
            inorder(p.getLeft());
            System.out.print(p.getData() + ",");
            inorder(p.getRight());
        }
    }

// int | heightBST()
//
    public int heightBST() {
        return heightBST(root);
    }
//
// int | heightBST(Node)
//

    private int heightBST(Node p) {
        int leftheight;
        int rightheight;
        if (p == null) {
            return 0;
        }

        leftheight = heightBST(p.getLeft());
        rightheight = heightBST(p.getRight());

        /* use the larger one */
        if (leftheight > rightheight) {
            return leftheight + 1;
        } else {
            return rightheight + 1;
        }

    }

// void | postorder()
//
    public void postorder() {

        postorder(root);
    }
//
// void | postorder(Node)
//

    private void postorder(Node p) {
        if (p != null) {
            postorder(p.getLeft());
            postorder(p.getRight());
            System.out.print(p.getData() + ", ");

        }
    }

//
// void | descendingorder()
//
    public void descendingorder() {
        descendingorder(root);
    }
//
// void | descendingorder(Node)
//

    private void descendingorder(Node p) {
        if (p != null) {

            descendingorder(p.getRight());
            System.out.print(p.getData() + ", ");

            descendingorder(p.getLeft());

        }
    }

//
// int | count7()
//
    public int count7() {
        return count7(root);
    }
//
// int | count7(Node)
//

    private int count7(Node p) {
        int count = 0;
        if (p == null) {
            return 0;
        }

        if (p.getData() % 7 == 0) {
            System.out.print(p.getData() + " ");
            count++;
        }
        count += count7(p.getLeft()) + count7(p.getRight());

        return count;
    }

//
// void | modifyAllNodes() ()
//
    public void modifyAllNodes(int value) {
        modifyAllNodes(root, value);
    }
//
// void | modifyAllNodes(Node,value)
//

    private void modifyAllNodes(Node p, int value) {
        if (p != null) {

            modifyAllNodes(p.getRight(), value);
            p.setData(p.getData() + value);
            modifyAllNodes(p.getLeft(), value);

        }
    }

//
// int | sumNodes()
//
    public int sumNodes() {
        return sumNodes(root);
    }

//
// int | sumNodes(Node)
//
    private int sumNodes(Node p) {
        if (p != null) {
            return p.getData() + sumNodes(p.getLeft())
                    + sumNodes(p.getRight());
        } else {
            return 0;
        }

    }

//
// void | delete(int)
//
    public void delete(int data) {
        root = delete(root, data);
    }
//
// Node | delete(Node, int)
//

    private Node delete(Node p, int data) {
        Node node2delete, newnode2delete, node2save, parent;
        int saveValue;

// Step 1: Find the node we want to delete
        node2delete = findNode(p, data);
// If node is not found (does not exist in tree), we clearly cannot delete it.

        if (node2delete == null) {
            return root;
        }

// Step 2: Find the parent of the node we want to delete
        parent = parent(p, node2delete);

// Step 3: Perform Deletion based on three possibilities
// **1** : node2delete is a leaf node
        if (isLeaf(node2delete)) {
// if parent is null, this means that node2delete is the ONLY node in  the tree

            if (parent == null) {
                return null; // we return null as the updated root of the tree
            }
// Delete node if it is a left child
            if (data < parent.getData()) {
                parent.setLeft(null);
            } // Delete node if it is a right child
            else {
                parent.setRight(null);
            }

// Finally, return the root of the tree (in case the root got updated)
            return p;
        }

// **2** : node2delete has only a left child
        if (hasOnlyLeftChild(node2delete)) {

// if node2delete is the root
            if (parent == null) {
                return node2delete.getLeft();
            }

// If node2delete is not the root,
// it must the left OR the right child of some node
// IF it is the left child of some node
            if (data < parent.getData()) {
                parent.setLeft(parent.getLeft().getLeft());
            } // ELSE it is the right child of some node
            else {
                parent.setRight(parent.getRight().getLeft());
            }

// Finally, return the root of the tree (in case the root got updated)
            return p;
        }

// **3** : node2delete has only a right child
        if (hasOnlyRightChild(node2delete)) {
// if node2delete is the root
            if (parent == null) {
                return node2delete.getRight();
            }

// If node2delete is not the root,
// it must the left OR the right child of some node
// IF it is the left child of some node
            if (data < parent.getData()) {
                parent.setLeft(parent.getLeft().getRight());
            } // ELSE it is the right child of some node
            else {
                parent.setRight(parent.getRight().getRight());
            }

// Finally, return the root of the tree (in case the root got updated)
            return p;

        }

// **4** : node2delete has TWO children.
// Remember, we have two choices: the minVal from the right subtree (of the deleted node )
// or the maxVal from the left subtree (of the deleted node)
// We choose to find the minVal from the right subtree.
        newnode2delete = minNode(node2delete.getRight());
// Now we need to temporarily save the data value(s) from this node
        saveValue = newnode2delete.getData();

// Now, we recursively call our delete method to actually delete this node  that we just copied the data from 
        p = delete(p, saveValue);

// Now, put the saved data (in saveValue) into the correct place (the original node we wanted to delete)
        node2delete.setData(saveValue);

// Finally, return the root of the tree (in case the root got updated)
        return p;

    }

//
// Node | minNode(Node)
//
    public Node minNode(Node root) {
        if (root == null) {
            return null;
        } else {
            if (root.getLeft() == null) {
                return root;
            } else {
                return minNode(root.getLeft());
            }
        }
    }

//
// Node | maxNode(Node)
//
    public Node maxNode(Node root) {
        if (root == null) {
            return null;

        } else {
            if (root.getRight() == null) {
                return root;
            } else {
                return maxNode(root.getRight());
            }
        }
    }

//
// Node | findNode(int)
//
    public Node findNode(int data) {
        return findNode(root, data);
    }
//
// Node | findNode(Node, int)
//

    private Node findNode(Node p, int data) {
        if (p == null) {
            return null;
        } else {
// if the data we are searching for is found at p (at the current root)
            if (data == p.getData()) {
                return p;
            } else if (data < p.getData()) {
                return findNode(p.getLeft(), data);
            } else {
                return findNode(p.getRight(), data);
            }

        }
    }

//
// Node | parent(Node)
//
    public Node parent(Node p) {
        return parent(root, p);
    }
//
// Node | parent(Node, Node)
//

    private Node parent(Node root, Node p) {
// Take care of NULL cases
        if (root == null || root == p) {
            return null; // because there is on parent
        }
// If root is the actual parent of node p
        if (root.getLeft() == p || root.getRight() == p) {
            return root; // because root is the parent of p
        }
// Look for p's parent in the left side of root

        if (p.getData() < root.getData()) {
            return parent(root.getLeft(), p);
        } // Look for p's parent in the right side of root
        else if (p.getData() > root.getData()) {
            return parent(root.getRight(), p);
        } // Take care of any other cases
        else {
            return null;
        }

    }

//
// boolean | isLeaf(Node)
//
    public boolean isLeaf(Node p) {
        return (p.getLeft() == null && p.getRight() == null);
    }

//
// boolean | hasOnlyLeftChild(Node)
//
    public boolean hasOnlyLeftChild(Node p) {
        return (p.getLeft() != null && p.getRight() == null);
    }

//
// boolean | hasOnlyRightChild(Node)
//
    public boolean hasOnlyRightChild(Node p) {
        return (p.getLeft() == null && p.getRight() != null);
    }
}
