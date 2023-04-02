package org.alejandroArias.model;

import java.util.Objects;

/**
 * This class represents a circular list of nodes
 * A circular list is a list that has a head and a tail
 * and the tail points to the head
 * @author Alejandro
 */
public class CircularList<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public CircularList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
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

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    /**
     * This method adds a node to the list
     * @param data the data of the node
     */
    public void add(T data) {
        Node<T> node = new Node<>(data);
        if (head == null) {
            head = node;
            tail = node;
            tail.setNext(head);
        } else {
            tail.setNext(node);
            tail = node;
            tail.setNext(head);
        }
        size++;
    }

    /**
     * This method removes a node from the list
     * @param data the data of the node
     */
    public void remove(T data) {
        Node<T> current = head;
        Node<T> previous = null;
        if (head != null) {
            do {
                if (current.getData().equals(data)) {
                    if (current == head) {
                        head = head.getNext();
                        tail.setNext(head);
                    } else if (current == tail) {
                        tail = previous;
                        tail.setNext(head);
                    } else {
                        previous.setNext(current.getNext());
                    }
                    size--;
                }
                previous = current;
                current = current.getNext();
            } while (current != head);
        }
    }

    /**
     * This method searches for a node in the list
     * @param data the data of the node
     * @return the node if it is found, null otherwise
     */
    public T search(T data) {
        return Objects.requireNonNull(getNode(data)).getData();
    }

    /**
     * This method prints the list
     */

    public void printList() {
        Node<T> current = head;
        if (head != null) {
            do {
                System.out.println(current.getData());
                current = current.getNext();
            } while (current != head);
        }
    }

    /**
     * This method returns the node at the specified index
     * @param index the index of the node
     * @return the node at the specified index
     */
    public Node<T> getNode(int index) {
        Node<T> aux = head;
        int counter = 0;
        if (head != null) {
            do {
                if (counter == index) {
                    return aux;
                }
                aux = aux.getNext();
                counter++;
            } while (aux != head);
        }
        return null;

    }

    /**
     * This method returns the index of the specified node
     * @param node the node to search for
     * @return the index of the node
     */

    public int getIndex(Node<T> node) {
        Node<T> current = head;
        int counter = 0;
        if (head != null) {
            do {
                if (current == node) {
                    return counter;
                }
                current = current.getNext();
                counter++;
            } while (current != head);
        }
        return -1;

    }

    /**
     * This method returns the index of the specified data
     * @param data the data to search for
     * @return the index of the data
     */

    public int getIndex(T data) {
        Node<T> current = head;
        int counter = 0;
        if (head != null) {
            do {
                if (current.getData().equals(data)) {
                    return counter;
                }
                current = current.getNext();
                counter++;
            } while (current != head);
        }
        return -1;

    }

    /**
     * This method returns the data of the node at the specified index
     * @param index the index of the node
     * @return the data of the node
     */

    public T getData(int index) {
        Node<T> current = head;
        int counter = 0;
        if (head != null) {
            do {
                if (counter == index) {
                    return current.getData();
                }
                current = current.getNext();
                counter++;
            } while (current != head);
        }
        return null;

    }

    /**
     * This method returns the data of the node at the specified index
     * @return the data of the node
     */


    public T getData(Node<T> node) {
        Node<T> current = head;
        if (head != null) {
            do {
                if (current == node) {
                    return current.getData();
                }
                current = current.getNext();
            } while (current != head);
        }
        return null;

    }


    private Node<T> getNode(T data) {
        Node<T> current = head;
        if (head != null) {
            do {
                if (current.getData().equals(data)) {
                    return current;
                }
                current = current.getNext();
            } while (current != head);
        }
        return null;
    }


    public void printList(Node<T> node) {
        Node<T> current = node;
        if (head != null) {
            do {
                System.out.println(current.getData());
                current = current.getNext();
            } while (current != node);
        }
    }

    public void printList(Node<T> node, int size) {
        Node<T> current = node;
        if (head != null) {
            for (int i = 0; i < size; i++) {
                System.out.println(current.getData());
                current = current.getNext();
            }
        }
    }


    public void printList(Node<T> node, int size, int index) {
        Node<T> current = node;
        if (head != null) {
            for (int i = 0; i < size; i++) {
                if (i >= index) {
                    System.out.println(current.getData());
                }
                current = current.getNext();
            }
        }
    }

    /**
     * This method clears the list
     */

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public void reverse() {
        Node<T> current = head;
        Node<T> previous = null;
        Node<T> next = null;
        if (head != null) {
            do {
                next = current.getNext();
                current.setNext(previous);
                previous = current;
                current = next;
            } while (current != head);
            head = previous;
            tail = current;
            tail.setNext(head);
        }
    }

    public void reverse(Node<T> node) {
        Node<T> current = node;
        Node<T> previous = null;
        Node<T> next = null;
        if (head != null) {
            do {
                next = current.getNext();
                current.setNext(previous);
                previous = current;
                current = next;
            } while (current != node);
            node = previous;
        }
    }

    public void reverse(Node<T> node, int size) {
        Node<T> current = node;
        Node<T> previous = null;
        Node<T> next = null;
        if (head != null) {
            for (int i = 0; i < size; i++) {
                next = current.getNext();
                current.setNext(previous);
                previous = current;
                current = next;
            }
            node = previous;
        }
    }

    public void rotate(int index) {
        Node<T> current = head;
        Node<T> previous = null;
        Node<T> next = null;
        if (head != null) {
            for (int i = 0; i < index; i++) {
                next = current.getNext();
                current.setNext(previous);
                previous = current;
                current = next;
            }
            head = previous;
            tail = current;
            tail.setNext(head);
        }
    }

    public T[] toArray() {
        T[] array = (T[]) new Object[size];
        Node<T> current = head;
        if (head != null) {
            for (int i = 0; i < size; i++) {
                array[i] = current.getData();
                current = current.getNext();
            }
        }
        return array;
    }

    public T[] split(int index) {
        T[] array = (T[]) new Object[size];
        Node<T> current = head;
        if (head != null) {
            for (int i = 0; i < size; i++) {
                array[i] = current.getData();
                current = current.getNext();
            }
        }
        return array;
    }

    public void insertAfter(T data, T newData) {

        Node<T> current = head;
        if (head != null) {
            do {
                if (current.getData().equals(data)) {
                    Node<T> newNode = new Node<>(newData);
                    newNode.setNext(current.getNext());
                    current.setNext(newNode);
                    size++;
                    return;
                }
                current = current.getNext();
            } while (current != head);
        }
    }

    public void insertBefore(T data, T newData) {

        Node<T> current = head;
        if (head != null) {
            do {
                if (current.getNext().getData().equals(data)) {
                    Node<T> newNode = new Node<>(newData);
                    newNode.setNext(current.getNext());
                    current.setNext(newNode);
                    size++;
                    return;
                }
                current = current.getNext();
            } while (current != head);
        }
    }

    public void insertAt(int index, T newData) {

        Node<T> current = head;
        if (head != null) {
            for (int i = 0; i < size; i++) {
                if (i == index) {
                    Node<T> newNode = new Node<>(newData);
                    newNode.setNext(current.getNext());
                    current.setNext(newNode);
                    size++;
                    return;
                }
                current = current.getNext();
            }
        }
    }

    public CircularList<T> merge(CircularList<T> list) {
        CircularList<T> newList = new CircularList<>();
        Node<T> current = head;
        if (head != null) {
            do {
                newList.add(current.getData());
                current = current.getNext();
            } while (current != head);
        }
        current = list.head;
        if (list.head != null) {
            do {
                newList.add(current.getData());
                current = current.getNext();
            } while (current != list.head);
        }
        return newList;
    }

    public CircularList<T> subList(int index) {
        CircularList<T> newList = new CircularList<>();
        Node<T> current = head;
        if (head != null) {
            for (int i = 0; i < size; i++) {
                if (i >= index) {
                    newList.add(current.getData());
                }
                current = current.getNext();
            }
        }
        return newList;
    }

    public CircularList<T> subList(int fromIndex, int toIndex) {

        CircularList<T> newList = new CircularList<>();
        Node<T> current = head;
        if (head != null) {
            for (int i = 0; i < size; i++) {
                if (i >= fromIndex && i < toIndex) {
                    newList.add(current.getData());
                }
                current = current.getNext();
            }
        }
        return newList;
    }

    public boolean contains(T data) {
        Node<T> current = head;
        if (head != null) {
            do {
                if (current.getData().equals(data)) {
                    return true;
                }
                current = current.getNext();
            } while (current != head);
        }
        return false;
    }

    public int indexOf(T data) {
        Node<T> current = head;
        if (head != null) {
            for (int i = 0; i < size; i++) {
                if (current.getData().equals(data)) {
                    return i;
                }
                current = current.getNext();
            }
        }
        return -1;
    }

    public int lastIndexOf(T data) {
        Node<T> current = head;
        int index = -1;
        if (head != null) {
            for (int i = 0; i < size; i++) {
                if (current.getData().equals(data)) {
                    index = i;
                }
                current = current.getNext();
            }
        }
        return index;
    }

    public void swap(int index1, int index2) {
        Node<T> current = head;
        Node<T> current2 = head;
        if (head != null) {
            for (int i = 0; i < size; i++) {
                if (i == index1) {
                    for (int j = 0; j < size; j++) {
                        if (j == index2) {
                            T temp = current.getData();
                            current.setData(current2.getData());
                            current2.setData(temp);
                            return;
                        }
                        current2 = current2.getNext();
                    }
                }
                current = current.getNext();
            }
        }
    }

    public void print() {
        Node<T> current = head;
        if (head != null) {
            do {
                System.out.print(current.getData() + " ");
                current = current.getNext();
            } while (current != head);
        }
        System.out.println();
    }


    private static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
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


}
