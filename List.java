/**
 * List:
 * A class represents a linked list.
 * This class has method to get and set head, add node into the list and delete the node from the list.
 *
 * @param <T> The node can store any type of the data.
 */

public class List<T> {
    private ListNode<T> head;

    /**
     * Default constructor method.
     */
    public List() {
        head = null;
    }

    /**
     * A method to get the head of the list.
     *
     * @return A reference to a ListNode object which represents the head of the list (or null if the list is empty).
     */
    public ListNode<T> getHead() {
        return head;
    }

    /**
     * A method to set the head of the list to the given node.
     *
     * @param newHead A reference to a ListNode object which will be the head of the list.
     */
    public void setHead(ListNode<T> newHead) {
        head = newHead;
    }

    /**
     * A method to add the node with the data to the beginning of the list.
     *
     * @param data The data to store in the node.
     */
    public void addToList(T data) {
        ListNode<T> newNode = new ListNode<T>(data);
        newNode.setNext(head);
        head = newNode;
    }

    /**
     * A method to delete the node from the beginning of the list.
     * Meanwhile, the data will be returned to be used.
     *
     * @return The data stored in the node.
     */
    public T deleteFirstNode() {
        if (head != null) {
            ListNode<T> nodeToDelete = head;
            head = head.getNext();
            return nodeToDelete.getData();
        }
        return null;
    }

}


