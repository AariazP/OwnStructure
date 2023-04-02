package org.alejandroArias.model;

import java.util.Comparator;

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

    public void add(int index, T data) {
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> newNode = new Node<>(data);
        if (index == 0) {
            newNode.setNext(this.head);
            this.head = newNode;
        } else if (index == this.size) {
            this.tail.setNext(newNode);
            this.tail = newNode;
        } else {
            Node<T> current = this.head;
            for (int i = 0; i < index - 1; i++) {
                current = current.getNext();
            }
            newNode.setNext(current.getNext());
            current.setNext(newNode);
        }
        this.size++;
    }

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

    public void remove(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            this.head = this.head.getNext();
        } else {
            Node<T> current = this.head;
            for (int i = 0; i < index - 1; i++) {
                current = current.getNext();
            }
            current.setNext(current.getNext().getNext());
            if (index == this.size - 1) {
                this.tail = current;
            }
        }
        this.size--;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void clear(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

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

    public boolean contains(T data) {
        return this.indexOf(data) != -1;
    }

    public void print() {
        Node<T> current = this.head;
        while (current != null) {
            System.out.println(current.getData());
            current = current.getNext();
        }
    }

    public void reverse() {
        Node<T> current = this.head;
        Node<T> previous = null;
        Node<T> next = null;
        while (current != null) {
            next = current.getNext();
            current.setNext(previous);
            previous = current;
            current = next;
        }
        this.tail = this.head;
        this.head = previous;
    }

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
     *
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


    private static class Node<T> {

        private T data;
        private Node<T> next;

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

    }


}
