import java.util.Arrays;
public class DynamicStack extends Stack {
    private static final int DEFAULT_CAPACITY = 10;
    private Item[] stackArray;
    private int size;

    public DynamicStack() {
        stackArray = new Item[DEFAULT_CAPACITY];
        size = 0;
    }
    public DynamicStack(int initialSize) {
        stackArray = new Item[initialSize];
        size = 0;
    }

    @Override
    public void push(Item item) {
        ensureCapacity(size + 1);
        stackArray[size] = item;
        size++;
    }

    @Override
    public Item pop() {
        if (!isEmpty()) {
            Item poppedItem = stackArray[size - 1];
            stackArray[size - 1] = null;
            size--;
            return poppedItem;
        } else {
            throw new IllegalStateException("Stack underflow: Cannot pop from an empty stack.");
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return false; // Dynamic stack can never be full
    }

    private void ensureCapacity(int capacity) {
        if (capacity > stackArray.length) {
            int newCapacity = Math.max(stackArray.length * 2, capacity);
            Item[] newStackArray = new Item[newCapacity];
            for (int i = 0; i < size; i++) {
                newStackArray[i] = stackArray[i];
            }
            stackArray = newStackArray;
        }
    }
}