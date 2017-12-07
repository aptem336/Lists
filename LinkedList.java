package lists;

public class LinkedList extends AbstractList {

    private Node head = null;
    private Node tail = null;
    private int size = 0;

    @Override
    public int size() {
        return size;
    }

    @Override
    public void print() {
        if (head == null) {
            System.out.print("null");
        } else {
            print(head);
        }
        System.out.println("");
    }

    private void print(Node node) {
        System.out.print(node.value + " ");
        if (node.next != null) {
            print(node.next);
        }
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public void add(Object element) {
        Node newNode = new Node(element);
        if (head == null) {
            head = newNode;
            tail = newNode;
            head.next = tail;
            tail.back = head;
        }
        tail.next = newNode;
        newNode.back = tail;
        tail = newNode;
        size++;
    }

    @Override
    public void add(int index, Object element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        size++;
        int counter = 0;
        Node current = head;
        Node newNode = new Node(element);
        while (counter != index) {
            current = current.next;
            counter++;
        }
        newNode.next = current;
        newNode.back = current.back;
        current.back.next = newNode;
        current.back = newNode;
    }

    @Override
    public Object get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        int counter = 0;
        Node current = head;
        while (counter != index) {
            current = current.next;
            counter++;
        }
        return current.value;
    }

    @Override
    public void set(int index, Object element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        int counter = 0;
        Node current = head;
        while (counter != index) {
            current = current.next;
            counter++;
        }
        current.value = element;
    }

    @Override
    public int indexOf(Object element) {
        if (head == null) {
            return -1;
        }
        int counter = 0;
        Node current = head;
        if (current.value.equals(element)) {
            return counter;
        }
        while (current.next != null) {
            current = current.next;
            counter++;
            if (current.value.equals(element)) {
                return counter;
            }
        }
        return -1;
    }

    @Override
    public void remove(Object element) {
        size--;
        if (element == head.value) {
            head = head.next;
            head.back = null;
            return;
        }
        if (element == tail.value) {
            tail = tail.back;
            tail.next = null;
            return;
        }
        Node current = head;
        while (!current.value.equals(element)) {
            current = current.next;
        }
        current.back.next = current.next;
        current.next.back = current.back;
        current.next = current.back = null;
    }

    @Override
    public void removeI(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        size--;
        if (index == 0) {
            head = head.next;
            head.back = null;
            return;
        }
        if (index == size) {
            tail = tail.back;
            tail.next = null;
            return;
        }
        int counter = 0;
        Node current = head;
        while (counter != index) {
            current = current.next;
            counter++;
        }
        current.back.next = current.next;
        current.next.back = current.back;
        current.next = current.back = null;
    }

    private static class Node<E> {

        E value;
        Node next;
        Node back;

        Node(E value) {
            this.value = value;
        }

    }
}
