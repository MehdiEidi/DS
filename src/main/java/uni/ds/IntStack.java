package uni.ds;

public class IntStack {
    private final IntList list = new IntList();

    /**
     * To return the size of the stack.
     * @return Returns the size of the stack.
     */
    public int size() {
        return list.size();
    }

    /**
     * Removes the last element of the stack.
     * @return Returns the IntStack.
     */
    public IntStack pop() {
        list.removeBack();
        return this;
    }

    /**
     * Adds a value to the stack.
     * @param value The value to be added to the stack.
     * @return Returns the IntStack.
     */
    public IntStack push(int value) {
        list.pushBack(value);
        return this;
    }

    /**
     * Returns a string representing of the stack.
     * @return Returns a string.
     */
    public String toString() {
        return list.toString();
    }

    public static void main(String[] args) {
        IntStack stack = new IntStack();

        stack.push(2).push(4).push(1).push(12);
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
        System.out.println(stack.size());
    }
}
