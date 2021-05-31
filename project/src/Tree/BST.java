package Tree;

import java.util.Scanner;

public class BST {
    TreeNode root;

    public static void main(String[] args) {
        BST bst = new BST();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println();
            System.out.println("1.  Insert Element in BST");
            System.out.println("2.  View elements inorder");
            System.out.println("3.  Find element in BST");
            System.out.println("4.  Delete element in BST");
            System.out.println("5.  Find maximum element in BST");
            System.out.println("6.  Find minimum element in BST");
            System.out.println("7.  Find Lowest common Ancestor");
            System.out.println("Enter your choice");
            int n = sc.nextInt();

            switch (n) {
                case 1 :
                    System.out.println("Enter an element");
                    bst.root = bst.createTreeNode(bst.root, sc.nextInt());
                    break;
                case 2 :
                    if (bst.root == null) {
                        System.out.println("No elements");
                        return;
                    }
                    bst.inorder(bst.root);
                    break;
                case 3 :
                    System.out.println("Enter element to find");
                    System.out.println("Element found:" + bst.findElement(bst.root, sc.nextInt()));
                    break;
            }

        }
    }

    private boolean findElement(TreeNode node, int data) {
        if (node != null) {
            if (node.data == data)
                return true;
            else if (node.data > data)
                findElement(node.left, data);
            else if (node.data < data)
                findElement(node.right, data);
            return false;
        } else {
            return false;
        }
    }

    private void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    private TreeNode createTreeNode(TreeNode node, int data) {
        if (node == null) {
            node = createNode(data);
        } else {
                if (node.data < data) {
                    node.right = createTreeNode(node.right, data);
                } else {
                    node.left = createTreeNode(node.left, data);
                }
        }
        return node;
    }

    private TreeNode createNode(int data) {
        TreeNode node = new TreeNode(data);
        return node;
    }
}
