import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * @author Yesho Vir
 */

public class BasicDoubleLinkedList<T> implements Iterable<T> {

    // Inner class representing a single node in the list
    protected class ListNode<E> {
        private E data;
        private ListNode<E> previous;
        private ListNode<E> next;

        /**
         * 
         * @param data
         */

        public ListNode(E data) {
            this.data = data;
            this.previous = null;
            this.next = null;
        }

        /**
         * 
         * @param next
         */

        // Getters and setters for previous, next, and data fields
        public void setNext(ListNode<E> next) {
            this.next = next;
        }

        /**
         * 
         * @param previous
         */

        public void setPrevious(ListNode<E> previous) {
            this.previous = previous;
        }

        /**
         * 
         * @return next
         */

        public ListNode<E> getNext() {
            return next;
        }

        /**
         * 
         * @return previous
         */

        public ListNode<E> getPrevious() {
            return previous;
        }

        /**
         * 
         * @return data
         */

        public E getData() {
            return data;
        }
    }

    // Inner class implementing ListIterator for list traversal
    private class BasicDoubleLinkedListIterator<E> implements ListIterator<E> {
        private ListNode<E> currentNode;
        private int currentIndex;

        /**
         * 
         * @param head
         */

        public BasicDoubleLinkedListIterator(ListNode<E> head) {
            this.currentNode = head;
            this.currentIndex = 0;
        }

        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        @Override
        public E next() throws NoSuchElementException {
            if (!hasNext()) {
                throw new NoSuchElementException("No more elements.");
            }
            E data = currentNode.getData();
            currentNode = currentNode.getNext();
            currentIndex++;
            return data;
        }

        @Override
        public boolean hasPrevious() {
            return currentNode != null && currentNode.getPrevious() != null;
        }

        @Override
        public E previous() throws NoSuchElementException {
            if (!hasPrevious()) {
                throw new NoSuchElementException("No previous element.");
            }
            currentNode = currentNode.getPrevious();
            currentIndex--;
            return currentNode.getData();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Remove not supported.");
        }

        // These methods are not needed and will remain unsupported
        @Override
        public int nextIndex() {
            throw new UnsupportedOperationException();
        }

        @Override
        public int previousIndex() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void set(E e) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void add(E e) {
            throw new UnsupportedOperationException();
        }
    }

    // Attributes to track the head, tail, and size of the list
    protected ListNode<T> head;
    protected ListNode<T> tail;
    protected int size;

    // Constructor initializes an empty list
    public BasicDoubleLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * 
     * @param data
     * @return
     */

    // Adds an element to the end of the list
    public BasicDoubleLinkedList<T> addToEnd(T data) {
        ListNode<T> newNode = new ListNode<>(data);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.setNext(newNode);
            newNode.setPrevious(tail);
            tail = newNode;
        }
        size++;
        return this;
    }

    /**
     * 
     * @param data
     * @return
     */

    // Adds an element to the front of the list
    public BasicDoubleLinkedList<T> addToFront(T data) {
        ListNode<T> newNode = new ListNode<>(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.setNext(head);
            head.setPrevious(newNode);
            head = newNode;
        }
        size++;
        return this;
    }

    /**
     * 
     * @return
     */

    // Retrieves the first element without removing it
    public T getFirst() {
        if (head == null) return null;
        return head.getData();
    }

    /**
     * 
     * @return
     */

    // Retrieves the last element without removing it
    public T getLast() {
        if (tail == null) return null;
        return tail.getData();
    }

    /**
     * 
     * @return
     */

    // Returns the size of the list
    public int getSize() {
        return size;
    }

    /**
     * 
     * @return
     */

    // Removes the first element and returns its data
    public T retrieveFirstElement() {
        if (head == null) return null;
        T data = head.getData();
        if (head == tail) { // Only one element
            head = tail = null;
        } else {
            head = head.getNext();
            head.setPrevious(null);
        }
        size--;
        return data;
    }

    /**
     * 
     * @return
     */

    // Removes the last element and returns its data
    public T retrieveLastElement() {
        if (tail == null) return null;
        T data = tail.getData();
        if (head == tail) { // Only one element
            head = tail = null;
        } else {
            tail = tail.getPrevious();
            tail.setNext(null);
        }
        size--;
        return data;
    }

    /**
     * 
     * @return
     */

    // Converts the list to an ArrayList
    public ArrayList<T> toArrayList() {
        ArrayList<T> list = new ArrayList<>();
        ListNode<T> current = head;
        while (current != null) {
            list.add(current.getData());
            current = current.getNext();
        }
        return list;
    }

    // Iterator method to provide a ListIterator for the list
    @Override
    public ListIterator<T> iterator() {
        return new BasicDoubleLinkedListIterator<>(head);
    }

    /**
     * 
     * @param targetData
     * @param comparator
     * @return
     */

    // Removes a node containing the target data if found
    public BasicDoubleLinkedList<T> remove(T targetData, Comparator<T> comparator) {
        if (head == null) return this;
        ListNode<T> current = head;

        while (current != null) {
            if (comparator.compare(current.getData(), targetData) == 0) {
                if (current == head) {
                    retrieveFirstElement();
                } else if (current == tail) {
                    retrieveLastElement();
                } else {
                    current.getPrevious().setNext(current.getNext());
                    current.getNext().setPrevious(current.getPrevious());
                    size--;
                }
                break;
            }
            current = current.getNext();
        }
        return this;
    }
}
