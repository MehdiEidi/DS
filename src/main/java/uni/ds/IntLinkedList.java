package uni.ds;

import java.util.NoSuchElementException;

public class IntLinkedList {
    /**
     * This class is an abstract data structure for storing each entity of the linked list. Each Node contains a value and
     * another Node reference. The goal is to chain these nodes together and make a whole data structure called LinkedList.
     */
    private static class Node {
        int value;
        Node next; //Reference of the Node in which this Node must be connected to and that node comes after this node.

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        public int getValue() {
            return value;
        }

        public Node getNext() {
            return next;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    /**
     * Store the first Node of the list as the head.
     */
    private Node head = null;

    /**
     * Store the last Node of the list as the tail.
     */
    private Node tail = null;

    /**
     * Store the size of the list.
     */
    private int size = 0;

    /**
     * To return the size of list.
     * @return size of the list.
     */
    public int size() {
        return size;
    }

    /**
     * Check to see if the list is empty or not.
     * @return true if the list is empty.
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * To add a value to the beginning of the list.
     * @param value the value to be added.
     * @return the list itself.
     */
    public IntLinkedList addFront(int value) {
        head = new Node(value, head);

        if (isEmpty()) {
            tail = head;
        }

        size++;

        return this;
    }

    /**
     * To add a value to the end of the list.
     * @param value the value to be added.
     * @return the list itself.
     */
    public IntLinkedList addLast(int value) {
        Node node = new Node(value, null);

        if (isEmpty()) {
            head = node;
        } else {
            tail.setNext(node);
        }

        tail = node;

        size++;

        return this;
    }

    /**
     * To return the value stored in the given index.(The value of the node in the given position)
     * @param index the index of the value to be returned.
     * @return the value.
     */
    public int get(int index) {
        if (isEmpty() || index < 0) {
            throw new NoSuchElementException("Index is out of bounds: " + index);
        }

        Node current = head;
        int i = 0;
        while (i != index) {
            current = current.getNext();
            i++;

            if (current == null) {
                throw new NoSuchElementException("Index is out of bounds: " + index);
            }
        }

        return current.getValue();
    }

    public static void main(String[] args) {
        IntLinkedList list = new IntLinkedList();
        
        list.addFront(32).addFront(100).addFront(3323);

        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println(list.size());
    }
}