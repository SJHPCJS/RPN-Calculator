/**
 * Stack:
 * A class represents a stack.
 *
 * @param <T> The stack can store any type of the data.
 */
public class Stack<T> {
    List<T> theStack;

    /**
     * A method to initialise the stack.
     */
    public void initialiseStack() {
        theStack = new List<>();
    }

    /**
     * A method to push the data into the stack.
     *
     * @param data The data need to be pushed.
     */
    public void push(T data) {
        if (ifStackEmpty()) {
            initialiseStack();
        }
        theStack.addToList(data);
    }

    /**
     * A method to pop the data out of the stack.
     *
     * @return The data need to be popped.
     */
    public T pop() {
        if (ifStackEmpty()) {
            initialiseStack();
        }
        return theStack.deleteFirstNode();
    }

    /**
     * A method to get the size of the stack.
     *
     * @return The size of the stack.
     */
    public int size() {
        if (ifStackEmpty()) {
            return 0;
        }
        return theStack.getHead().getLength();
    }

    /**
     * A method to clean all the data in the stack.
     */
    public void clean() {
        theStack = null;
    }

    /**
     * A method to check if the stack is empty.
     *
     * @return A boolean represents if the stack is empty.
     */
    public boolean ifStackEmpty() {
        return theStack == null;
    }

}
