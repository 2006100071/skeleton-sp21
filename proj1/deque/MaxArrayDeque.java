package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends  ArrayDeque<T> {
    private Comparator<T> comparator;
    public MaxArrayDeque(Comparator<T> c) {
        comparator = c;
    }

    public T max(Comparator<T> c) {
        if (isEmpty()) {
            return null;
        }
        int maxidex = 0;
        for (int i = 0; i < size(); i++) {
            if (c.compare(get(i), get(maxidex)) > 0) {
                maxidex = i;
            }
        }

        return  get(maxidex);
    }

    public T max() {
        if (isEmpty()) {
            return null;
        }
        return max(comparator);
    }

//    @Override
//    public boolean equals(Object o) {
//        if (o == null) {
//            return false;
//        }
//        if (o == this) {
//            return true;
//        }
//        if (!(o instanceof MaxArrayDeque)) {
//            return false;
//        }
//        if (((MaxArrayDeque<?>) o).max() != max() ) {
//            return false;
//        }
//        return super.equals(o);
//    }
}
