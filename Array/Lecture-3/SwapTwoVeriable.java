public class SwapTwoVeriable {
    private static void swap (int []arr, int i, int j){ //Using Temp
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    private static void swap2 (int []arr, int i, int j){    //Not Using Temp variable
        arr[i] = arr[i] + arr[j];
        arr[j] = arr[i] - arr[j];
        arr[i] = arr[i] - arr[j];
    }
    public static void main(String[] args) {
        int []arr = {9, 3};
        swap(arr, 0, 1);
        System.out.println(arr[0] +" "+arr[1]);
        swap2(arr, 0, 1);
        System.out.println(arr[0] +" "+arr[1]);
    }
}