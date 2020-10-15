package uni.ds;

public class IntQueue {
    private final IntList list = new IntList();

    /**
     * To add new element to the queue.
     * @param value the value to be added to the queue.
     * @return returns the queue.
     */
    public IntQueue add(int value) {
        list.pushBack(value);
        return this;
    }

    /**
     * Removes the first element in the queue.
     * @return returns the queue.
     */
    public IntQueue take() {
        list.removeFront();
        return this;
    }

    /**
     * To return the size of the queue.
     * @return returns the size of the queue.
     */
    public int size() {
        return list.size();
    }

    /**
     * To represent the queue as a string.
     * @return Returns a string.
     */
    public String toString() {
        return list.toString();
    }

    public static void main(String[] args) {
        IntQueue queue = new IntQueue();

        queue.add(3).add(4).add(43).add(232);
        System.out.println(queue);

        queue.take().take();

        System.out.println(queue);
        System.out.println(queue.size());
    }
}
