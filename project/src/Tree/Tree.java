package Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Tree {
    TreeNode root;

    public static void main(String[] args) {
        Tree tree = new Tree();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println();
            System.out.println("1.  Insert Element in BST");
            System.out.println("2.  View elements InOrder");
            System.out.println("3.  View elements PreOrder");
            System.out.println("4.  View elements PostOrder");
            System.out.println("5.  Find element in BST");
            System.out.println("6.  Delete element in BST");
            System.out.println("7.  Inorder Successor in BST");
            System.out.println("8. No. of BST Possible");
            System.out.println("9. BFS(level order traversal)");
            System.out.println("10. Diameter of a binary tree");
            System.out.println("11. Height of a binary tree");
            System.out.println("12. Find Leaf Nodes");
            System.out.println("13. Check Sum tree");
            System.out.println("14. Add Tree");
            System.out.println("15: K Distance from root");
            System.out.println("16: Lowest Common Ancestor");
            System.out.println("17: Print K Leaves Nodes");
            System.out.println("Enter your choice");
            int n = sc.nextInt();

            switch (n) {
                case (1) :
                    System.out.println("Enter element");
                    tree.root = tree.insert(tree.root, sc.nextInt());
                    break;
                case (2) :
                    if (tree.root == null) {
                        System.out.println("No elements");
                    } else {
                        tree.inorder(tree.root);
                    }
                    break;
                case (3) :
                    if (tree.root == null) {
                        System.out.println("No elements");
                    } else {
                        tree.preorder(tree.root);
                    }
                    break;
                case (4) :
                    if (tree.root == null) {
                        System.out.println("No elements");
                    } else {
                        tree.postOrder(tree.root);
                    }
                    break;
                case (5) :
                    int val = sc.nextInt();
                    System.out.println("Element found: " +  tree.findElement(tree.root, val));
                    break;
                case (6) :
                    System.out.println("Enter Element to delete");
                    tree.deleteElement(tree.root, sc.nextInt());
                    break;
                case (7) :
                    System.out.println("Enter Element to find Inorder Successor of");
                    int data = sc.nextInt();
                    boolean isPresent = tree.findElement(tree.root, data);
                    if (!isPresent) {
                        System.out.println("Element not present");
                        break;
                    }
                    tree.inorderSuccessor(tree.root, data);
                    break;

                case (8) :
                    System.out.println("Enter value");
                    tree.possibleBST(sc.nextInt());
                    break;

                case (9) :
                    tree.bfs(tree.root);
                    break;

                case(10):
                    System.out.println("Diameter of binary tree: " + tree.findDiameter(tree.root));
                    break;

                case(11):
                    System.out.println("Height of binary tree: " + tree.findHeight(tree.root));
                    break;

                case(12):
                    System.out.println("No. of leaf nodes: " + tree.findLeafNodes(tree.root));
                    break;
                case(13):
                    System.out.println("Is sum tree: " + tree.isSumTree(tree.root));
                    break;
                case(14):
                    System.out.println("Add Nodes: " + tree.add(tree.root));
                    break;
                case(15):
                    System.out.println("Enter K value for distance from root");
                    tree.kDistanceFromRoot(tree.root, sc.nextInt());
                    break;
                case(16):
                    System.out.println("Enter Two Nodes");
                    System.out.println(tree.lca(tree.root, sc.nextInt(), sc.nextInt()).data);
                    break;
                case(17):
                    System.out.println("Enter K value");
                    tree.kLeafNodes(tree.root, sc.nextInt());
                    break;
            }
        }

    }

    private int kLeafNodes(TreeNode root, int k) {
        if (root == null)
            return 0;
        else {
            if (root.left == null && root.right == null) {
                return 1;
            } else {
                int left = kLeafNodes(root.left, k);
                int right = kLeafNodes(root.right, k);
                if (left + right == k) {
                    System.out.println(root.data + " ");
                } else {
                    return left + right;
                }
                return 0;
            }
        }
    }

    private TreeNode lca(TreeNode root, int p, int q) {
        if (root == null)
            return root;
        if (root.data == p || root.data == q)
            return root;
        TreeNode left = lca(root.left, p, q);
        TreeNode right = lca(root.right, p, q);
        if (left != null && right != null) {
            return root;
        } else {
            return left != null ? left : right;
        }
    }

    private void kDistanceFromRoot(TreeNode root, int k) {
        if (root == null)
            return;
        if (k == 0) {
            System.out.print(root.data + " ");
        } else {
            kDistanceFromRoot(root.left, k - 1);
            kDistanceFromRoot(root.right, k - 1);
        }
    }

    private boolean isSumTree(TreeNode root) {
        if (root == null)
            return true;
        else if (root.left == null && root.right == null)
            return true;
        else {
            int left = add(root.left);
            int right = add(root.right);
            if (root.data == left + right) {
                if (isSumTree(root.left) && isSumTree(root.right)) {
                    return true;
                }
                return false;
            } else
                return false;
        }
    }

    private int add(TreeNode root) {
        if (root == null)
            return 0;
        else {
            if (root.left == null && root.right == null)
                return root.data;
            return root.data + add(root.left) + add(root.right);
        }
    }

    private int findLeafNodes(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 1;
        return findLeafNodes(root.left) + findLeafNodes(root.right);
    }

    private int findDiameter(TreeNode root) {
        if (root == null)
            return 0;
        else {
            int lh = 1 + findHeight(root.left);
            int rh = 1 + findHeight(root.right);

            int ld = findDiameter(root.left);
            int rd = findDiameter(root.right);

            int fd = Integer.max(lh + rh + 1, Integer.max(ld, rd));
            return fd;
        }

    }

    private int findHeight(TreeNode root) {
        if (root == null)
            return 0;
        int lh = findHeight(root.left);
        int rh = findHeight(root.right);
        int h;
        if (lh > rh) {
            h = lh + 1;
        } else  {
            h = rh + 1;
        }
        return h;
    }

    private void bfs(TreeNode root) {
        if (root == null)
            System.out.println("No elements present");
        else {
            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            queue.add(root);
            while (!queue.isEmpty()) {
                TreeNode temp = queue.remove();
                System.out.print(temp.data + " ");
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
        }
    }

    private void possibleBST(int n) {
        int a[] = new int[n + 1];
        a[0] = a[1] = 1;

        for (int i = 2; i <= n; i++) {
            a[i] = 0;
            for (int j = 0; j < i; j++) {
                a[i] += a[j] * a[i - j -1];
            }
        }
        System.out.println("BST Possible: " + a[n]);
    }

    private void inorderSuccessor(TreeNode root, int val) {
        TreeNode node = root;
        TreeNode successor = root;
        while (node.data != val) {
            if (node.data > val) {
                successor = node;
                node = node.left;
            } else {
                node = node.right;
            }
        }
        if (node.right != null) {
            TreeNode temp = node.right;
            while (temp.left != null) {
                temp = temp.left;
            }

            System.out.println("Inorder Successor: " + temp.data);
        } else {
            System.out.println("Inorder Successor: " + successor.data);
        }
    }

    private void deleteElement(TreeNode root, int val) {
        if (!findElement(root, val)) {
            System.out.println("Element Not present");
        } else {
            deleteElementFromBST(root, val);
        }

    }

    private TreeNode deleteElementFromBST(TreeNode root, int val) {
        if (root == null)
            return null;
        else if (root.data > val)
            root.left = deleteElementFromBST(root.left, val);
        else if (root.data < val)
            root.right = deleteElementFromBST(root.right, val);
        else {
            if (root.left != null && root.right != null) {
                TreeNode temp = findMaxInBST(root.left);
                root.data = temp.data;
                root.left = deleteElementFromBST(root.left, root.data);
            } else {
                if (root.left == null) {
                    root = root.right;
                }
                if (root != null && root.right == null) {
                    root = root.left;
                }
            }
        }
        return root;
    }

    private TreeNode findMaxInBST(TreeNode root) {
        if (root == null)
            return root;
        else {
            TreeNode temp = root.right;
            while (temp != null) {
                temp = temp.right;
            }
            return temp;
        }
    }

    private boolean findElement(TreeNode root, int val) {
        if (root != null) {
            if (root.data == val)
                return true;
             else if (root.data > val)
                return findElement(root.left, val);
            else if (root.data < val)
                return findElement(root.right, val);
            return false;
        } else {
            return false;
        }
    }

    private void postOrder(TreeNode root) {
        if (root != null) {
            preorder(root.left);
            preorder(root.right);
            System.out.print(root.data + " ");
        }
    }

    private void preorder(TreeNode root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    private void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    private TreeNode insert(TreeNode root, int val) {
        if (root == null) {
            root = createNewElement(val);
        } else {
            if (root.data > val)
                root.left = insert(root.left, val);
            else
                root.right = insert(root.right, val);
        }
        return root;
    }

    private TreeNode createNewElement(int val) {
        TreeNode node = new TreeNode(val);
        return node;
    }


}
