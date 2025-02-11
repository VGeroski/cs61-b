package cs61b.projects.proj1a;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class LinkedListDeque61B<T> implements Deque61B<T> {
    private class Node {
        T item;
        Node next;
        Node prev;

        /**
         * Node constructor
         * @param item item in node
         * @param prev pointer to previous node in list
         * @param next pointer to next node in list
         */
        Node(T item, Node prev, Node next) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }

    Node sentinel;
    int size;

    public LinkedListDeque61B() {
        sentinel = new Node(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    @Override
    public void addFirst(T x) {
        Node oldFirst = sentinel.next;
        sentinel.next = new Node(x, sentinel, oldFirst);
        oldFirst.prev = sentinel.next;
        size++;
    }

    @Override
    public void addLast(T x) {
        Node oldLast = sentinel.prev;
        oldLast.next = new Node(x, oldLast, sentinel);
        sentinel.prev = oldLast.next;
        size++;
    }

    @Override
    public List<T> toList() {
        List<T> returnList = new ArrayList<>();
        int locSize = this.size;
        Node tmp = sentinel.next;
        while (locSize > 0) {
            returnList.add(tmp.item);
            tmp = tmp.next;
            locSize--;
        }
        return returnList;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) throw new NoSuchElementException("Deque underflow.");

        Node oldFirst = sentinel.next;
        T itemToReturn = oldFirst.item;
        sentinel.next = oldFirst.next;
        oldFirst.next.prev = sentinel;

        oldFirst = null;
        size--;
        return itemToReturn;
    }

    @Override
    public T removeLast() {
        if (isEmpty()) throw new NoSuchElementException("Deque underflow.");

        Node oldLast = sentinel.prev;
        T itemToReturn = oldLast.item;

        oldLast.prev.next = sentinel;
        sentinel.prev = oldLast.prev;

        oldLast = null;
        size--;
        return itemToReturn;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) return null;

        Node tmp = sentinel.next;
        while (index != 0) {
            tmp = tmp.next;
            index--;
        }
        return tmp.item;
    }

    @Override
    public T getRecursive(int index) {
        if (index < 0 || index >= size) return null;
        return getRecursiveHelper(sentinel.next, index);
    }

    private T getRecursiveHelper(Node node, int index) {
        if (index == 0) {
            return node.item;
        }
        return getRecursiveHelper(node.next, --index);
    }
}
