package Array;

public class CountLastOccarence{
    public static int greaterElement(int []arr, int x){
        int count = 0;
        for(int val : arr){
            if(val > x) count++;
        }
        return count;
    }
    public static int lastOccarence(int []arr, int x){
        int idx = -1;
        for(int i=0; i<arr.length; i++){
            if(arr[i] == x) idx = i;
        }
        return idx;
    }
    public static void main(String[] args) {
        int []arr = {1,2,3,4,6,7,3,9};
        System.out.println(greaterElement(arr, 3));
        System.out.println(lastOccarence(arr, 3));
    }
}