/**
 * ListNode:
 * A class represents a node in the list.
 * This class has some method to get and set the data and next node and get the length of the list.
 *
 * @param <T> The node can store any type of the data.
 */
public class ListNode<T> {
    private T data;
    private ListNode<T> next;


    /**
     * Default constructor method.
     */
    public ListNode(T data) {
        this.data = data;
    }


    /**
     * A method to get the data in the node.
     *
     * @return The data in the node.
     */
    public T getData() {
        return data;
    }

    /**
     * A method to get the next node in the list after this one
     *
     * @return A reference to the next node (or null if there is no next node)
     */
    public ListNode<T> getNext() {
        return next;
    }

    /**
     * A method to set the next node in the list after this one
     *
     * @param next A reference to a ListNode object which represents the next node in the list after this one.
     */
    public void setNext(ListNode<T> next) {
        this.next = next;
    }

    /**
     * A method to get the length of the list.
     * @return The length of the list.
     */
    public int getLength() {
        int count = 0;
        ListNode<T> current = this;
        while (current != null) {
            count++;
            current = current.getNext();
        }
        return count;
    }
}

