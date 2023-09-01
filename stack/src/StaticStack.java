public class StaticStack extends Stack {
    private int maxSize;
    private Item[] stackArray;
    private int top;

    public StaticStack(int size) {
        maxSize = size;
        stackArray = new Item[maxSize];
        top = -1;
    }

    @Override
    public void push(Item item) {
        if (top < maxSize - 1) {
            top++;
            stackArray[top] = item;
        } else {
            throw new IllegalStateException("Stack overflow: Cannot push onto a full stack.");
        }
    }

    @Override
    public Item pop() {
        if (top >= 0) {
            Item poppedItem = stackArray[top];
            stackArray[top] = null;
            top--;
            return poppedItem;
        } else {
            throw new IllegalStateException("Stack underflow: Cannot pop from an empty stack.");
        }
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public boolean isFull() {
        return top == maxSize - 1;
    }
    public int size() {
        return maxSize;
    }
}