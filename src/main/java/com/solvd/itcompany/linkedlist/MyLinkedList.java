package com.solvd.itcompany.linkedlist;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private static final Logger logger = LogManager.getLogger(MyLinkedList.class);

    private static class Node<T> {
        T data;
        Node<T> next;

        public Node() {

        }

        public Node(T data) {
            this.data = data;
        }

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }


    }

    public MyLinkedList() {

    }

    public MyLinkedList(Node<T> node) {
        this.head = node;
        this.tail = node.next;
    }

    public MyLinkedList(Node<T> head, Node<T> tail) {
        this.head = head;
        this.tail = tail;
        head.next = tail;
    }

    public void add(int index, T data){
        Node<T> newNode = new Node<>(data);
        Node<T> current = head;
        int count = 0;
        // This loop is used to count the number of nodes in the linked list
        while(current != null){
            count++;
            current = current.next;
        }
        // if index is 0 then add it to the beginning of the linkedlist
        if (index >= 0 && index <= count){
            if (index == 0){
                newNode.next = head;
                head = newNode;
            }
            else{
                // searching for where the index is in the linkedlist
                Node<T> previous = head;
                int counter = 0;
                while(counter < index - 1){
                    previous = previous.next;
                    counter++;
                }
                current = previous.next;
                newNode.next = current;
                previous.next = newNode;
            }

        }
        else {
            throw new IndexOutOfBoundsException();
        }
    }


    public void add(T data){
        // code to add a new node to the list
        Node<T> newNode = new Node<>(data);
        if (head == null){
            head = newNode;
            tail = newNode;
        }
        else{
            tail.next = newNode;
            tail = newNode;
        }

    }


    public void remove(int index, T data){
        // code to remove the first occurrence of the given data from the list
        Node<T> newNode = new Node<>(data);
        Node<T> current = head;
        int count = 0;
        while(current != null){
            count++;
            current = current.next;
        }
        if (head == null){
            logger.info("Linked List is empty.");
        }
        else if (index < 0 || index > count) {
            throw new IndexOutOfBoundsException();
        }
        else if (index == 0){
            head = head.next;
        }
        else{
            Node<T> newCurrent = head;
            for (int i = 0; i < index - 1; i++){
                newCurrent = newCurrent.next;
            }
            newCurrent.next = newCurrent.next.next;
        }
    }

    public void print(){
        Node<T> current = head;
        if (current == null){
            logger.info("Linked List is empty.");
        }
        while(current != null){
            logger.info(current.data);
            current = current.next;
        }
    }

    public Node<T> getHead() {
        return head;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }

    public Node<T> getTail() {
        return tail;
    }

    public void setTail(Node<T> tail) {
        this.tail = tail;
    }


}
