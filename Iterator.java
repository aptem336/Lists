package lists;

public class Iterator {

    private AbstractList list;
    private Object current;

    public Iterator(AbstractList list) {
        this.list = list;
        current = null;
    }

    public boolean hasNext() {
        return (list.indexOf(current) < list.size() - 1);
    }

    public Object next() {
        current = list.get(list.indexOf(current) + 1);
        return current;
    }

}
