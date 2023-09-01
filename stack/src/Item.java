public class Item {
    private ItemType type;
    private int value = 0;
    public enum ItemType {
        ADD,
        SUB,
        MUL,
        DIV,
        VALUE
    }

    public Item (ItemType type){
        this.type = type;
    }

    public Item (ItemType type, int value){
        this.type = type;
        this.value = value;
    }

    public ItemType getType() {
        return type;
    }

    /*
    public void setType(ItemType type) {
        this.type = type;
    }
    */

    public int getValue() {
        if(type == ItemType.VALUE){
            return value;
        }
        else {
            throw new UnsupportedOperationException("this item is not a value");
        }
    }
    public static Item createValueItem(int value) {
        return new Item(ItemType.VALUE, value);
    }

    public static Item createOperationItem(ItemType type) {
        if (type == ItemType.VALUE) {
            throw new IllegalArgumentException("Invalid operation type. Operation type cannot be VALUE.");
        }
        return new Item(type);
    }
}
