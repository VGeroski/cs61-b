package cs61b.projects.proj1b.deque;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayDeque61B<T> implements Deque61B<T> {

    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque61B() {
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = items.length - 1;
        nextLast = 0;
    }

    @Override
    public void addFirst(T x) {
        items[nextFirst] = x;
        nextFirst = Math.floorMod(nextFirst - 1, items.length);
        size++;
    }

    @Override
    public void addLast(T x) {
        items[nextLast] = x;
        nextLast = Math.floorMod(nextLast + 1, items.length);
        size++;
    }

    @Override
    public List toList() {
        List<T> returnList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            T item = get(i);
            returnList.add(item);
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
        nextFirst++;
        T item = items[nextFirst];
        items[nextFirst] = null;
        size--;
        return item;
    }

    @Override
    public T removeLast() {
        nextLast--;
        T item = items[nextLast];
        items[nextLast] = null;
        size--;
        return item;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return items[Math.floorMod(nextFirst + 1 + index, items.length)];
    }

    @Override
    public T getRecursive(int index) {
        throw new UnsupportedOperationException("No need to implement getRecursive for proj 1b");
    }
}
