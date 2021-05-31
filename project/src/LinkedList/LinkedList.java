package LinkedList;

import java.util.Scanner;

public class LinkedList {
    Node start;
    int size;

    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            LinkedList list = new LinkedList();
            while (true) {
                System.out.println();
                System.out.println("Enter your choice: ");
                System.out.println("1. Insert element at beginning");
                System.out.println("2. Insert element at last");
                System.out.println("3. Insert element at position");
                System.out.println("4. Delete first element");
                System.out.println("5. Delete last element");
                System.out.println("6. Delete from position");
                System.out.println("7. View Elements");
                System.out.println("8. Is LinkedList empty");
                System.out.println("9. No. of elements");
                System.out.println("10. Sort linked list");
                System.out.println("11. Rotate linked list");
                System.out.println("12. Reverse linked list");
                System.out.println("13. Remove duplicates in linked list");
                System.out.println("14. Reverse linked list using recursion");

                int n = sc.nextInt();

                switch (n) {
                    case (1) :
                        System.out.println("Enter an element");
                        list.insertElementAtBeginning(sc.nextInt());
                        break;
                    case (2) :
                        System.out.println("Enter an element");
                        list.insertElementAtLast(sc.nextInt());
                        break;
                    case (3) :
                        System.out.println("Enter an element");
                        int value = sc.nextInt();
                        System.out.println("Enter position");
                        int pos = sc.nextInt();
                        list.insertElementAtPosition(value, pos);
                        break;
                    case (4) :
                        list.deleteFirstElement();
                        break;
                    case (5) :
                        list.deleteLastElement();
                        break;
                    case (7) :
                        System.out.println("View Elements");
                        list.viewElements();
                        break;
                    case (10) :
                        list.sortLinkedList();
                        break;
                    case (13) :
                        list.removeDuplicates();
                        break;
                    case (14) :
                        list.reverse();
                        break;
                }
            }
    }

    private void removeDuplicates() {
        if (isEmpty()) {
            System.out.println("No elements");
            return;
        } else {
            Node temp = start;
            int a[] = new int[100000];
            for (int i  = 0; i < 100000; i++)
                a[i] = 0;

            for (int i = 0; i < size; i++) {
                if (a[temp.getData()] == 1) {
                    deleteElementFromPosition(i);
                } else {
                    a[temp.getData()] = 1;
                }
                temp = temp.getNext();
            }
        }
    }

    private void deleteElementFromPosition(int pos) {
        if (isEmpty()) {
            System.out.println("No elements");
            return;
        } else {
            if (pos == 0)
                deleteFirstElement();
            else if (pos == size - 1)
                deleteLastElement();
            else {
                Node temp = start, prev = start;
                for (int i = 0; i < pos; i++) {
                    prev = temp;
                    temp = temp.getNext();
                }
                prev.setNext(temp.getNext());
                size--;
            }

        }
    }

    private void reverse() {
        if (isEmpty()) {
            System.out.println("No elements");
            return;
        }
        Node curr, next, prev;
        curr = next = start;
        prev = null;

        while (curr != null) {
            next = curr.getNext();
            curr.setNext(prev);
            prev = curr;
            curr = next;
        }
        start = prev;
    }

    private void sortLinkedList() {
        if (isEmpty()) {
            System.out.println("No elements");
            return;
        } else {
            Node next, prev;
            prev = start;
            next = start.getNext();
            while (next != null) {
                if (prev.getData() > next.getData()) {
                    prev.setData(prev.getData() ^ next.getData());
                    next.setData(prev.getData() ^ next.getData());
                    prev.setData(prev.getData() ^ next.getData());
                }
                prev = next;
                next = next.getNext();
            }
        }
    }

    private void insertElementAtPosition(int value, int pos) {
        if (isEmpty()) {
            if (pos != 0) {
                System.out.println("No elements present, Insertion at position: " + pos + ", not possible");
                return;
            } else {
                insertElementAtBeginning(value);
            }
        } else {
            if (pos < 0 || pos > size) {
                System.out.println("No elements present, Insertion at position: " + pos + ", not possible");
                return;
            } else {
                if (pos == 0)
                    insertElementAtBeginning(value);
                else if (pos == size)
                    insertElementAtLast(value);
                else {
                    Node node = new Node();
                    node.setData(value);
                    Node temp, prev;
                    temp = prev = start;

                    for (int i = 0; i < pos; i++) {
                        prev = temp;
                        temp = temp.getNext();
                    }
                    node.setNext(temp);
                    prev.setNext(node);
                    size++;
                }
            }
        }
    }

    private void deleteLastElement() {
        if (isEmpty()) {
            System.out.println("No elements");
            return;
        } else {
            Node temp = start;
            for (int i  = 0; i < size - 1; i++) {
                if (temp.getNext() == null) {
                    temp = temp.getNext();
                }
                temp.setNext(null);
                size--;
            }
        }
    }

    private void deleteFirstElement() {
        if (isEmpty()) {
            System.out.println("No elements");
            return;
        } else {
            start = start.getNext();
            size--;
        }
    }

    private void viewElements() {
        Node temp = start;
        if (isEmpty()) {
            System.out.println("No elements");
            return;
        }
        for (int i  = 0; i < size; i++) {
            System.out.print(temp.getData() + " ");
            temp = temp.getNext();
        }
    }

    private void insertElementAtLast(int value) {
        Node node = new Node();
        node.setData(value);
        if (isEmpty()) {
            start = node;
        } else {
            Node temp = start;
           for (int i = 0; i < size; i++) {
               if (temp.getNext() == null) {
                   temp.setNext(node);
               }
               temp = temp.getNext();
           }
        }
        size++;

    }

    private void insertElementAtBeginning(int value) {
        Node node = new Node();
        node.setData(value);
        if (isEmpty()) {
            start = node;
        } else {
            node.setNext(start);
            start = node;
        }
        size++;
    }

    private boolean isEmpty() {
        if (size == 0)
            return true;
        return false;
    }


}
