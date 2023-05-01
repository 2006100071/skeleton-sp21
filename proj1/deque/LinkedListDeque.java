package deque;

import java.util.concurrent.RecursiveAction;

public class LinkedListDeque<Item>{
    private  class IntNode{
        public  Item value;
        public  IntNode pre;
        public  IntNode next;

        public  IntNode(Item i, IntNode m, IntNode n)
        {
            value = i;
            pre = m;
            next = n;
        }

    }

    /* The first item (if it exists) is at sentinel.next. */
    private IntNode sentinel;
    private  int size;

    /** Creates an empty LinkedListDeque. */
    public  LinkedListDeque()
    {
        sentinel = new IntNode(null,null,null);
        sentinel.pre = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    public  LinkedListDeque(Item x)
    {
        sentinel = new IntNode(null,null,null);
        sentinel.next = new IntNode(x,sentinel,null);
        sentinel.next.next = sentinel;
        sentinel.pre = sentinel.next;
        size = 1;
    }


    /** Adds x to the front of the list. */
    public  void  addFirst(Item x)
    {
        sentinel.next = new IntNode(x,sentinel,sentinel.next);
        sentinel.next.next.pre = sentinel.next;
        size += 1;
    }

    public void  addLast(Item x)
    {
        sentinel.pre = new IntNode(x,sentinel.pre,sentinel);
        sentinel.pre.pre.next = sentinel.pre;
        size += 1;
    }

    public boolean isEmpty()
    {
        if (size == 0)
            return  true;
        else
            return  false;
    }

    public int size()
    {
        return  size;
    }

    public void printDeque()
    {
        IntNode p = sentinel.next;
        for (int i = 0; i < size; i++) {
            System.out.print(p.value + " ");
            p = p.next;
        }
        System.out.println();
    }

    public Item removeFirst()
    {
        if (sentinel.next == sentinel)
            return  null;
        IntNode p = sentinel.next;
        p.next.pre = sentinel;
        sentinel.next = p.next;
        size -= 1;
        return  p.value;
    }

    public Item removeLast()
    {
        if (sentinel.pre == sentinel)
            return  null;
        IntNode p = sentinel.pre;
        p.pre.next = p.next;
        p.next.pre = p.pre;
        size --;
        return  p.value;
    }

    public Item get(int index)
    {
        if (index < 0 || index > size)
            return  null;
        IntNode p = sentinel.next;
        for (int i = 0; i < size; i++) {
            if (index == i)
                return  p.value;
            p = p.next;
        }
        return  null;
    }

    public Item Recursive(int index, int count, IntNode p)
    {
        if (index == count)
            return p.value;
        else
            return Recursive(index,count + 1,p.next);
    }
    public Item getRecursive(int index)
    {
        if (index < 0 || index >= size)
            return  null;
        IntNode p = sentinel.next;
        return Recursive(index,0,p);
    }

}
