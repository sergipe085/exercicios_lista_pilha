package estudo;

import estudo.Exceptions.EmptyListException;

public class LinkedList<Podi> implements List<Podi> {

    Node<Podi> head = null;
    Node<Podi> tail = null;
    int size = 0;

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(Podi value) {
        Node<Podi> newNode = new Node<Podi>();
        newNode.value = value;

        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }

        size++;
    }

    @Override
    public void insert(Podi value) {
        Node<Podi> newNode = new Node<Podi>();
        newNode.value = value;
        newNode.next = head;
        head = newNode;
        size++;
    }

    @Override
    public void insert(int index, Podi value) throws IndexOutOfBoundsException {
        Node<Podi> newNode = new Node<Podi>();
        if (index == size-1) {
            add(value);
        } else if (index == 0) {
            insert(value);
        } else {
            Node<Podi> auxNode = getNode(index - 1);
            newNode.value = value;
            newNode.next = auxNode.next;
            auxNode.next = newNode;
        }

        size++;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Podi removeLast() throws EmptyListException {
        Node<Podi> auxNode = getNode(size - 2);
        Podi removedValue = auxNode.next.value;
        auxNode.next = null;
        tail = auxNode;
        size--;

        return removedValue;
    }

    @Override
    public Podi removeFirst() throws EmptyListException {
        Node<Podi> auxNode = head;
        Podi removedValue = auxNode.value;
        head = auxNode.next;
        auxNode.next = null;
        size--;
        return removedValue;
    }

    @Override
    public Podi removeByIndex(int index) throws EmptyListException, IndexOutOfBoundsException {
        Node<Podi> auxNode;
        Podi removedValue;
        if (index == 0) {
            return removeFirst();
        } else if (index == size - 1) {
            return removeLast();
        } else {
            auxNode = getNode(index - 1);
            removedValue = auxNode.next.value;
            auxNode.next = auxNode.next.next;
            auxNode.next.next = null;
            size--;

            return removedValue;
        }

    }

    @Override
    public void set(int index, Podi value) throws IndexOutOfBoundsException {
        getNode(index).value = value;
    }

    @Override
    public Podi get(int index) throws IndexOutOfBoundsException {
        return getNode(index).value;
    }

    public Node<Podi> getNode(int index) {
        Node<Podi> auxNode = head;
        int i = 0;
        while (auxNode != null) {
            if (index == i) {
                return auxNode;
            }

            auxNode = auxNode.next;
            i++;
        }

        return null;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public String toString() {
        String str = "[";

        Node<Podi> auxNode = head;
        while (auxNode != null) {
            str += auxNode.value;
            if (auxNode.next != null)
                str += ", ";
            auxNode = auxNode.next;
        }

        str += "]";
        return str;
    }
}
