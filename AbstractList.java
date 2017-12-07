package lists;

public abstract class AbstractList {

    public int size() {
        return 0;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void print() {
    }

    public void clear() {
    }

    public void add(Object element) {
    }

    public void add(int index, Object element) {
    }

    public Object get(int index) {
        return null;
    }

    public void set(int index, Object element) {
    }

    public boolean contains(Object element) {
        return indexOf(element) != -1;
    }

    public int indexOf(Object element) {
        return -1;
    }

    public void remove(Object element) {
    }

    public void removeI(int index) {
    }
}
