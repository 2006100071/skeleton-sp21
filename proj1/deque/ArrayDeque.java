package deque;

import java.util.Iterator;

public class ArrayDeque<T> implements Deque<T>, Iterable<T> {
    private  T [] items;
    private  int size;

    private int first;

    private  int end;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        first = 0;
        end = 1;
        size = 0;
    }
    /** Resizes the underlying array to the target capacity. */

    private void resize(int capacity) {
        T [] p = (T[]) new  Object[capacity];
        int tfirst = first;
        for (int i = 1; i <= size; i++) {
            p[i] = items[(++tfirst) % items.length];
        }
        first = 0;
        end = size + 1;
        items = p;
    }

    @Override
    public void addFirst(T item) {
        // 1 2 3 4 5 6 7 0
        // 8 7 6 5 4 3 2 1
        if (size < (items.length / 4) && items.length > 16) {
            resize(items.length / 4);
        }
        if (size > (items.length / 4 * 3)) {
            resize(items.length * 2);
        }
        items[first] = item;
        first = (first - 1 + items.length) % items.length;
        size++;
    }

    @Override
    public void addLast(T item) {
        if (size < (items.length / 4) && items.length > 16) {
            resize(items.length / 4);
        }
        if (size > (items.length / 4 * 3)) {
            resize(items.length * 2);
        }
        items[end] = item;
        end = (end + 1) % items.length;
        size++;
    }

//    public boolean isEmpty()
//    {
//        return  size == 0;
//    }

    @Override
    public int size() {
        return  size;
    }


    public void printDeque() {
        for (int i = (first + 1) % items.length; i <= size; i = (i + 1) % items.length) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }

    @Override
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        first = (first + 1) % items.length;
        T x = items[first];
        size--;
        if (size < (items.length / 4) && items.length > 16) {
            resize(items.length / 4);
        }
        return x;
    }

    @Override
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        end = (end - 1 + items.length) % items.length;
        T x = items[end];
        size--;
        if (size < (items.length / 4) && items.length > 16) {
            resize(items.length / 4);
        }
        return x;
    }


    public T get(int index) {
        if (index < 0 || index >= size) {
            return  null;
        }
        return items[(first + 1 + index) % items.length];
    }

    public Iterator<T> iterator() {

        Iterator<T> p = new Iterator<T>() {
            private  int index = 0;
            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public T next() {
                T x = get(index);
                index++;
                return x;
            }
        };
        return p;
    }

    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (o == this) {
            return true;
        }
        if (!(o instanceof ArrayDeque)) {
            return false;
        }
        ArrayDeque<T> p = (ArrayDeque<T>) o;
        if (p.size() != size) {
            return  false;
        }
        for (int i = 0; i < size; i++) {
            T x = p.get(i);
            T y = get(i);
            if (!x.equals(y)) {
//                System.out.println(x + "  " + y);
                return  false;
            }
        }

        return  true;
    }
}
