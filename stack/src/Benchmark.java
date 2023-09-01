import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
public class Benchmark {
    public static void main(String[] args) {
        int maxStackSize = 1000000;
        int stepSize = 10000;

        try {
            PrintWriter printWriter = new PrintWriter(new FileWriter("stackBenchmarkResult.csv"));
            printWriter.println("Stack Type,Stack Size (elements),Execution Time (nanoseconds)");
            System.out.println("Dynamic stack benchmarks");
            for (int stackSize = 100; stackSize <= maxStackSize ; stackSize += stepSize) {

                DynamicStack dynamicStack = new DynamicStack(15);
                long startTime = System.nanoTime();

                for (int i = 0; i < stackSize; i++) {
                    dynamicStack.push(Item.createValueItem(i));
                }

                for (int i = 0; i < stackSize; i++) {
                    dynamicStack.pop();
                }

                long endTime = System.nanoTime();
                long elapsedTime = endTime - startTime;
                printWriter.println("Dynamic," + stackSize + "," + elapsedTime);
                //System.out.println("Stack size: " + stackSize + " : " + elapsedTime + " nanoseconds ");
            }


            System.out.println("\nstatic stack benchmark");
            for (int stackSize = 1024; stackSize <= maxStackSize; stackSize += stepSize) {
                StaticStack staticStack = new StaticStack(stackSize);
                long startTime = System.nanoTime();

                for (int i = 0; i < stackSize; i++) {
                    staticStack.push(Item.createValueItem(i));
                }

                for (int i = 0; i < stackSize; i++) {
                    staticStack.pop();
                }

                long endTime = System.nanoTime();
                long elapsedTime = endTime- startTime;
                printWriter.println("Dynamic," + stackSize + "," + elapsedTime);
                //System.out.println("Stack size: " + stackSize + " : " + elapsedTime + " nanoseconds ");

            }
            printWriter.close();

        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
