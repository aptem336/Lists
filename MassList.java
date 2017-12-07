package lists;

public class MassList extends AbstractList {

    private int size = 0;
    private Object[] dataMass;

    public MassList() {
        dataMass = new Object[10];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void print() {
        if (size == 0) {
            System.out.println("null");
        } else {
            for (int i = 0; i < size; i++) {
                System.out.print(dataMass[i] + " ");
            }
            System.out.println("");
        }
    }

    @Override
    public void clear() {
        dataMass = null;
        dataMass = new Object[10];
        size = 0;
    }

    @Override
    public void add(Object element) {
        if (dataMass.length < size + 1) {
            Object[] temp = dataMass;
            dataMass = new Object[(size * 3) / 2 + 1];
            System.arraycopy(temp, 0, dataMass, 0, size);
        }
        dataMass[size] = element;
        size++;
    }

    @Override
    public void add(int index, Object element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        if (dataMass.length < size + 1) {
            Object[] temp = dataMass;
            dataMass = new Object[(size * 3) / 2 + 1];
            System.arraycopy(temp, 0, dataMass, 0, size);
        }
        System.arraycopy(dataMass, index, dataMass, index + 1, size - index);
        dataMass[index] = element;
        size++;
    }

    @Override
    public Object get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return dataMass[index];
    }

    @Override
    public void set(int index, Object element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        dataMass[index] = element;
    }

    @Override
    public int indexOf(Object element) {
        for (int i = 0; i < size; i++) {
            if (dataMass[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void remove(Object element) {
        int index = indexOf(element);
        int numMoved = size - index - 1;
        System.arraycopy(dataMass, index + 1, dataMass, index, numMoved);
        dataMass[--size] = null;
    }

    @Override
    public void removeI(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        int numMoved = size - index - 1;
        System.arraycopy(dataMass, index + 1, dataMass, index, numMoved);
        dataMass[--size] = null;
    }

    public void trimToSize() {
        Object[] temp = new Object[size];
        System.arraycopy(dataMass, 0, temp, 0, size);
        dataMass = temp;
    }
}
