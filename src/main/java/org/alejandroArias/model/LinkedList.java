package org.alejandroArias.model;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;

/**
 * This class represents a LinkedList data structure
 * @author Alejandro Arias
 * @version 1.0
 * @since 2023-04-16
 * @see <a href="https://en.wikipedia.org/wiki/Linked_list">Linked List</a>
 */
public class LinkedList<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * Adds a new node to the end of the list
     * @param data the data to be added
     */
    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.setNext(newNode);
            this.tail = newNode;
        }
        this.size++;
    }

    /**
     * Adds a new node to the list at the specified index
     * @param index the index where the new node will be added
     * @param data the data to be added
     * @return true if the node was added, false otherwise
     */
    public boolean add(int index, T data) {
        if (index < 0 || index > this.size) {
            return false;
        }
        Node<T> newNode = new Node<>(data);
        if (index == 0) {
            newNode.setNext(this.head);
            this.head = newNode;
            if (this.size == 0) {
                this.tail = newNode;
            }
        } else {
            Node<T> previous = null;
            Node<T> current = this.head;
            for (int i = 0; i < index; i++) {
                previous = current;
                current = current.getNext();
            }
            newNode.setNext(current);
            previous.setNext(newNode);
            if (index == this.size) {
                this.tail = newNode;
            }
        }
        this.size++;
        return true;
    }

    /**
     * Returns the data stored in the node at the specified index
     * @param index the index of the node
     * @return the data stored in the node
     */
    public T get(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> current = this.head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getData();
    }

    /**
     * Removes the node at the specified index
     * @param index the index of the node to be removed
     * @return true if the node was removed, false otherwise
     */
    public boolean remove(int index) {
        if (index < 0 || index >= this.size) {
            return false;
        }
        if (index == 0) {
            this.head = this.head.getNext();
            if (this.size == 1) {
                this.tail = null;
            }
        } else {
            Node<T> previous = null;
            Node<T> current = this.head;
            for (int i = 0; i < index; i++) {
                previous = current;
                current = current.getNext();
            }
            previous.setNext(current.getNext());
            if (index == this.size - 1) {
                this.tail = previous;
            }
        }
        this.size--;
        return true;
    }

    /**
     * returns the size of the list
     * @return the size of the list
     */
    public int size() {
        return this.size;
    }

    /**
     * Checks if the list is empty
     * @return true if the list is empty, false otherwise
     */
    public boolean isEmpty() {
        return this.size == 0;
    }
    /**
     * Removes all the nodes from the list
     */
    public void clear(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * Returns the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element.
     * @param data the data to be searched
     * @return the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element.
     */
    public int indexOf(T data) {
        Node<T> current = this.head;
        for (int i = 0; i < this.size; i++) {
            if (current.getData().equals(data)) {
                return i;
            }
            current = current.getNext();
        }
        return -1;
    }

    /**
     * Returns true if this list contains the specified element.
     * @param data the data to be searched
     * @return true if this list contains the specified element.
     */
    public boolean contains(T data) {
        return this.indexOf(data) != -1;
    }

    /**
     * Prints the data stored in the nodes of the list
     */
    public void print() {
        StringBuilder output = new StringBuilder();
        Node<T> current = this.head;
        while (current != null) {
            output.append(current.getData()).append(" ");
            current = current.getNext();
        }
        System.out.println(output.toString());
    }

    /**
     * Reverses the list
     */
    public void reverse() {
        Node<T> current = this.head;
        Node<T> previous = null;
        Node<T> next;
        while (current != null) {
            next = current.getNext();
            current.setNext(previous);
            previous = current;
            current = next;
        }
        this.tail = this.head;
        this.head = previous;
    }

    /**
     * Sorts the list using the compareTo method of the data stored in the nodes
     * the type of the data stored in the nodes
     * must implement the Comparable interface
     * and the compareTo method must be implemented
     * to compare the data stored in the nodes
     * of the list
     */
    public void sort() {
        Node<T> current = this.head;
        Node<T> index = null;
        T temp;
        if (this.head == null) {
            return;
        } else {
            while (current != null) {
                index = current.getNext();
                while (index != null) {
                    if (current.getData().toString().compareTo(index.getData().toString()) > 0) {
                        temp = current.getData();
                        current.setData(index.getData());
                        index.setData(temp);
                    }
                    index = index.getNext();
                }
                current = current.getNext();
            }
        }
    }

    /**
     * Sorts the list using the specified comparator
     * @param comparator the comparator to be used to compare the data stored in the nodes
     */
    public void sort(Comparator<T> comparator) {
        Node<T> current = this.head;
        Node<T> index = null;
        T temp;
        if (this.head == null) {
            return;
        } else {
            while (current != null) {
                index = current.getNext();
                while (index != null) {
                    if (comparator.compare(current.getData(), index.getData()) > 0) {
                        temp = current.getData();
                        current.setData(index.getData());
                        index.setData(temp);
                    }
                    index = index.getNext();
                }
                current = current.getNext();
            }
        }
    }

    /**
     * Sorts the list using the specified comparator
     * @param comparator the comparator to be used to compare the data stored in the nodes
     * @param reverse if true the list will be sorted in descending order
     */

    public void sort(Comparator<T> comparator, boolean reverse) {
        if (reverse) {
            this.sort(comparator);
            this.reverse();
        } else {
            this.sort(comparator);
        }
    }

    /**
     * To string method
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        Node<T> current = this.head;
        while (current != null) {
            result.append(current.getData()).append(" ");
            current = current.getNext();
        }
        return result.toString();
    }

    /**
     * Node class
     * @param <T> the type of the data stored in the node
     */
    private static class Node<T> implements Iterator<T>, Comparable<T>{

        private T data; // data stored in the node
        private Node<T> next; // reference to the next node

        public Node(T data) {
            this.data = data;
            this.next = null;
        }

        public T getData() {
            return this.data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node<T> getNext() {
            return this.next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }


        @Override
        public boolean hasNext() {
            return this.next != null;
        }

        @Override
        public T next() {
            return this.next.data;
        }


        @Override
        public int compareTo(T o) {

            if (this.data.equals(o)) return 0;
            if(this.data.hashCode() > o.hashCode()) return 1;
            return -1;

        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node<?> node = (Node<?>) o;
            return Objects.equals(data, node.data) && Objects.equals(next, node.next);
        }

        @Override
        public int hashCode() {
            return Objects.hash(data, next);
        }
    }


}
