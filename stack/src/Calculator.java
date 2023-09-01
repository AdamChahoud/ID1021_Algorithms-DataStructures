public class Calculator {
    Item[] expr;
    int ip;
    Stack stack;
    public Calculator(Item[] expr, Stack stack) {
        this.expr = expr;
        this.ip = 0;
        this.stack = stack;
    }
    public int run() {
        while ( ip < expr.length ) {
            step();
        }
        return stack.pop().getValue();
    }
    public void step() {
        Item nxt = expr[ip++];
        switch(nxt.getType()) {
            case ADD : {
                int y = stack.pop().getValue();
                int x = stack.pop().getValue();
                stack.push(Item.createValueItem(x + y));
                break;

            }
            case SUB : {
                int y = stack.pop().getValue();
                int x = stack.pop().getValue();
                stack.push(Item.createValueItem(x - y));
                break;
            }
            case MUL : {
                int y = stack.pop().getValue();
                int x = stack.pop().getValue();
                stack.push(Item.createValueItem(x * y));
                break;
            }
            case DIV : {
                int y = stack.pop().getValue();
                int x = stack.pop().getValue();
                stack.push(Item.createValueItem(x / y));
                break;
            }
            case VALUE : {
                stack.push(Item.createValueItem(nxt.getValue()));
                break;
            }
        }
    }
}
