import java.util.Comparator;
import java.util.ListIterator;

/**
 * @author Yesho Vir
 */

public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T> {

    // Comparator used for sorting elements
    private Comparator<T> comparator;

    /**
     * 
     * @param comparator
     */

    // Constructor that initializes the comparator
    public SortedDoubleLinkedList(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    /**
     * 
     * @param data
     * @return
     */

    // Custom add method to insert elements in sorted order
    public SortedDoubleLinkedList<T> add(T data) {
        ListNode<T> newNode = new ListNode<>(data);

        // If the list is empty, set head and tail to the new node
        if (head == null) {
            head = tail = newNode;
        } else {
            ListNode<T> currentNode = head;

            // Traverse the list to find the correct position for insertion
            while (currentNode != null) {
                if (comparator.compare(newNode.getData(), currentNode.getData()) <= 0) {
                    // Insert newNode before currentNode
                    newNode.setNext(currentNode);
                    newNode.setPrevious(currentNode.getPrevious());

                    if (currentNode == head) {
                        head = newNode; // Update head if new node is at the front
                    } else {
                        currentNode.getPrevious().setNext(newNode);
                    }
                    currentNode.setPrevious(newNode);
                    break; // Insertion complete, exit the loop
                } else if (currentNode == tail) {
                    // If at the tail, insert newNode at the end
                    tail.setNext(newNode);
                    newNode.setPrevious(tail);
                    tail = newNode;
                    break;
                }
                currentNode = currentNode.getNext();
            }
        }
        size++; // Increment the size after insertion
        return this;
    }

    // Unsupported operation for addToEnd in a sorted list
    @Override
    public BasicDoubleLinkedList<T> addToEnd(T data) {
        throw new UnsupportedOperationException("Invalid operation for sorted list");
    }

    // Unsupported operation for addToFront in a sorted list
    @Override
    public BasicDoubleLinkedList<T> addToFront(T data) {
        throw new UnsupportedOperationException("Invalid operation for sorted list");
    }

    // Provides an iterator for the sorted list
    @Override
    public ListIterator<T> iterator() {
        return super.iterator();
    }

    // Removes a specific element using the comparator
    public SortedDoubleLinkedList<T> remove(T data, Comparator<T> comparator) {
        super.remove(data, comparator); // Call parent class remove method
        return this;
    }
}
