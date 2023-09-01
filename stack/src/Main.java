public class Main {
    public static void main(String[] args) {
        // 10 + 2 * 5
        // 10 2 5 * + in reversed Polish notation
        Item[] expr = {
                Item.createValueItem(10),
                Item.createValueItem(2),
                Item.createValueItem(5),
                Item.createOperationItem(Item.ItemType.MUL),
                Item.createOperationItem(Item.ItemType.ADD)
        };
        Calculator calc = new Calculator(expr, new StaticStack(3));
        int res = calc.run();
        System.out.println(" Calculator: res = " + res);
    }
}