import java.util.Random;
public class Main {
    static Random random = new Random();
    public static void main(String[] args) {

        /*for (int i = 100; i <=1000000 ; i*=10) {
            int key = random.nextInt(i);
            System.out.println("the key is: " + key );
            System.out.println("the number of elements: " + i);
            int[] array = GenerateArray(i);
            long startTime = System.nanoTime();
            boolean founded = Search.search_unsorted(array, key);
            long endTime = System.nanoTime();
            long elapsedTime = endTime- startTime;
            System.out.println(" is the key founded: " + founded);
            System.out.println("the time to look for the key: " + elapsedTime + " nanoseconds \n_________________________________________________");

            int [] array2 = sorted(i);
            long startTime2 = System.nanoTime();
            boolean founded2 = Search.search_sorted(array2,key);
            long endTime2 = System.nanoTime();
            long elapsedTime2 = endTime2- startTime2;
            System.out.println("sorted\n " + "is the key founded: " + founded2);
            System.out.println("the time to look for the key: " + elapsedTime2 + " nanoseconds \n_________________________________________________");


            int[] array3 = sorted(i);
            long startTime3 = System.nanoTime();
            boolean founded3 = Search.binary_search(array3, key);
            long endTime3 = System.nanoTime();
            long elapsedTime3 = endTime3- startTime3;
            System.out.println("sorted binary \n " + "is the key founded: " + founded3);
            System.out.println("the time to look for the key: " + elapsedTime3 + " nanoseconds \n_________________________________________________");

        }*/

        for (int i = 500; i <= 2000 ; i*=2) {
            int [] array1 = sorted(i);
            int [] array2 = sorted(i);
            long startTime1 = System.nanoTime();
            int res1 = Search.findDupOG(array1,array2);
            long endTime1 = System.nanoTime();
            long elapsedTime1 = endTime1-startTime1;
            System.out.println("number of duplicits:  " + res1 + " array size: " + i + " " +elapsedTime1 + " nanoseconds");

            long startTime2 = System.nanoTime();
            int res2 = Search.findDuplicits(array1,array2);
            long endTime2 = System.nanoTime();
            long elapsedTime2 = endTime2-startTime2;
            System.out.println("number of duplicits:  " + res2 + " array size " + i + " " +elapsedTime2 + " nanoseconds\n");
        }
    }
    public static int[] GenerateArray(int size) {

        int[] randomArray = new int[size];
        for (int i = 0; i < size; i++) {
            randomArray[i] = random.nextInt(size);
        }
        return randomArray;
    }
    private static int[] sorted(int n) {
        Random rnd = new Random();
        int[] array = new int[n];
        int nxt = 0;
        for (int i = 0; i < n ; i++) {
            nxt += rnd.nextInt(10) + 1;
            array[i] = nxt;
        }
        return array;
    }
}