import java.util.ArrayList;
import java.util.List;

/*
HW3 with A and B solutions
NAME&LASTNAME : REZWANULLAH QURAISHI
 STUDENT NO: 200316057
*/

class Node {
    int data;
    Node left, right;

    // Constructor to initialize a node with the given data
    public Node(int item) {
        data = item;
        left = right = null;
    }
}

class BinaryTree {
    Node root;

    // Constructor to initialize an empty binary tree
    public BinaryTree() {
        root = null;
    }

    // Method to insert a node into the binary tree
    public void insert(int data) {
        root = insertRecursive(root, data);
    }

    // Recursive method to insert a node into the binary tree
    private Node insertRecursive(Node root, int data) {
        // If the tree is empty, create a new node and return it as the root
        if (root == null) {
            root = new Node(data);
            return root;
        }

        // If the data is less than the current node's data, recursively insert it into the left subtree
        if (data < root.data)
            root.left = insertRecursive(root.left, data);
            // If the data is greater than the current node's data, recursively insert it into the right subtree
        else if (data > root.data)
            root.right = insertRecursive(root.right, data);

        return root;
    }

    // Method to perform preorder traversal of the binary tree
    public List<Integer> preorderTraversal() {
        List<Integer> result = new ArrayList<>();
        preorder(root, result);
        return result;
    }

    // Recursive method to perform preorder traversal
    private void preorder(Node node, List<Integer> result) {
        // Base case: If the current node is null, return
        if (node != null) {
            // Process the current node (add its data to the result list)
            result.add(node.data);

            // Recursively traverse the left subtree
            preorder(node.left, result);

            // Recursively traverse the right subtree
            preorder(node.right, result);
        }
    }

    public int findLowestCommonAncestor(int node1Data, int node2Data) {
        // Call the recursive helper function to find the lowest common ancestor
        Node lowestCommonAncestor = findLowestCommonAncestor(root, node1Data, node2Data);
        if (lowestCommonAncestor != null)
            return lowestCommonAncestor.data;
        else
            return -1; // Return -1 if no lowest common ancestor found
    }

    private Node findLowestCommonAncestor(Node node, int node1Data, int node2Data) {
        // Base cases:
        // If the current node is null or matches either of the given node values, return the current node
        if (node == null || node.data == node1Data || node.data == node2Data)
            return node;

        // Recursively find the lowest common ancestor in the left and right subtrees
        Node left = findLowestCommonAncestor(node.left, node1Data, node2Data);
        Node right = findLowestCommonAncestor(node.right, node1Data, node2Data);

        // If both left and right subtrees have found a common ancestor, the current node is the lowest common ancestor
        if (left != null && right != null)
            return node;

        // If only one subtree has found a common ancestor, propagate it upward
        return (left != null) ? left : right;
    }

}

public class Main {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        // Inserting nodes into the binary tree According to the given binary tree fig
        tree.insert(70); // Root node
        tree.insert(45); // Left child of root
        tree.insert(32); // Left child of the left child
        tree.insert(21); // Left child of the left child of the left child
        tree.insert(13); // Left child of the left child of the left child of the left child
        tree.insert(27); // Right child of the left child of the left child of the left child
        tree.insert(40); //  .......
        tree.insert(56);
        tree.insert(46);
        tree.insert(68);
        tree.insert(87);
        tree.insert(77);
        tree.insert(73);
        tree.insert(80);
        tree.insert(79);
        tree.insert(82);
        tree.insert(92);
        tree.insert(89);
        tree.insert(99);
        // A section Problem's solution
        // Performing preorder traversal and printing the output
        List<Integer> preorderList = tree.preorderTraversal();

        System.out.print("Preorder output: ");
        for (int i = 0; i < preorderList.size(); i++) {
            System.out.print(preorderList.get(i));
            if (i != preorderList.size() - 1)
                System.out.print(",");
        }
        System.out.println();

        // B section Problem's solution

        int node1 = 27;
        int node2 = 46;
        int lowestCommonAncestor = tree.findLowestCommonAncestor(node1, node2);
        System.out.println("Lowest common ancestor of (" + node1 + "," + node2 + ") = " + lowestCommonAncestor);

        node1 = 77;
        node2 = 13;
        lowestCommonAncestor = tree.findLowestCommonAncestor(node1, node2);
        System.out.println("Lowest common ancestor of (" + node1 + "," + node2 + ") = " + lowestCommonAncestor);
    }
}
