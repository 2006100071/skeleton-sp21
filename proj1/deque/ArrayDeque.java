package deque;

public class ArrayDeque<Item> {
    private  Item [] items;
    private  int size;

    private int first;

    private  int end;

    public ArrayDeque()
    {
        items = (Item[]) new Object[8];
        first = 0;
        end = 1;
        size = 0;
    }
    /** Resizes the underlying array to the target capacity. */
    public  void  resize(int capacity)
    {
        Item []p = (Item[]) new  Object[capacity];
        int tfirst = first;
        for (int i = 1; i <= size; i++) {
            p[i] = items[++tfirst];
        }
        first = 0;
        end = size + 1;
        items = p;
    }

    public void addFirst(Item item)
    {
        // 1 2 3 4 5 6 7 0
        // 8 7 6 5 4 3 2 1
        if (size < (items.length / 4) && items.length > 16)
        {
            resize(items.length / 4);
        }
        if (size > (items.length / 4 * 3))
        {
            resize(items.length * 2);
        }
        items[first] = item;
        first = (first - 1 + items.length) % items.length ;
        size++;
    }

    public void addLast(Item item)
    {
        if (size < (items.length / 4) && items.length > 16)
        {
            resize(items.length / 4);
        }
        if (size > (items.length / 4 * 3))
        {
            resize(items.length * 2);
        }
        items[end] = item;
        end = (end + 1 ) % items.length ;
        size++;
    }

    public boolean isEmpty()
    {
        return  size == 0;
    }

    public int size()
    {
        return  size;
    }

    public void printDeque()
    {
        for (int i = (first + 1) % items.length; i <= size; i = (i + 1) % items.length) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }

    public Item removeFirst()
    {
        if (size == 0)return  null;
        first = (first + 1) % items.length;
        Item x = items[first];
        size--;
        if (size < (items.length / 4) && items.length > 16)
        {
            resize(items.length / 4);
        }
        return x;
    }

    public Item removeLast()
    {
        if (size == 0)return  null;
        end = (end - 1 + items.length) % items.length;
        Item x = items[end];
        size--;
        if (size < (items.length / 4) && items.length > 16)
        {
            resize(items.length / 4);
        }
        return x;
    }

    public Item get(int index)
    {
        if (index < 0 || index >= size)
            return  null;
        return items[(first + 1 + index) % items.length];
    }
}
