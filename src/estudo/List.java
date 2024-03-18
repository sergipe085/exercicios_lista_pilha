package estudo;

import estudo.Exceptions.EmptyListException;

public interface List<Podi> {
    int size();
    void add(Podi value);
    void insert(Podi value);
    void insert(int index, Podi value) throws IndexOutOfBoundsException;
    boolean isEmpty();
    Podi removeLast() throws EmptyListException;
    Podi removeFirst() throws EmptyListException;
    Podi removeByIndex(int index) throws EmptyListException, IndexOutOfBoundsException;
    void set(int index, Podi value) throws IndexOutOfBoundsException;
    Podi get(int index) throws IndexOutOfBoundsException;
    void clear();    
}
