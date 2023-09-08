public class Search {

    public static boolean search_unsorted(int[] array, int key) {
        for (int index = 0; index < array.length ; index++) {
            if (array[index] == key) {
                return true;
            }
        }
        return false;
    }
    public static boolean search_sorted(int[] array, int key) {
        for (int index = 0; index < array.length ; index++) {
            if (array[index] == key) {
                return true;
            } else if (array[index] > key) {
                return false;
                
            }
        }
        return false;
    }
    public static int findDuplicits(int[] array1,int[] array2){
        int numberDups = 0;
        int index1 = 0;
        int index2 = 0;
        while (index1 < array1.length && index2 < array2.length) {

            if (array1[index1] == array2[index2]){
                numberDups++;
                index1++;
            }
            else if (array1[index1] > array2[index2]) {
                index2++;
                
            }
            else {
                index1++;
            }

        }
        return numberDups;
    }
    public static int findDupOG (int[] array1, int [] array2){
        int ndup = 0;
        for (int i = 0; i < array1.length; i++) {
            if(binary_search(array2, array1[i])){
                ndup++;
            }

        }
        return ndup;
    }
    public static boolean binary_search(int[] array, int key) {
        int first = 0;
        int last = array.length-1;
        while (true) {
// jump to the middle
            int index = first + (last-first) / 2;
            if (array[index] == key) {
// hmm what now?
                return true;
            }
            if (array[index] < key && index < last) {
// The index position holds something that is less than
// what we're looking for, what is the first possible page?
                first = index + 1  ;
                continue;
            }
            if (array[index] > key && index > first) {
// The index position holds something that is larger than
// what we're looking for, what is the last possible page?
                last = index - 1  ;
                continue;
            }
            return false;
// Why do we land here? What should we do?

        }
    }
}
