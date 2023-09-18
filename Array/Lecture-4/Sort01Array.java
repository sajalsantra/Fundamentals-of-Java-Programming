public class Sort01Array {

    public static void printArray(int []a){
        for(int x : a) System.out.print(x+" ");
        System.out.println();
    }

    public static void sortInNormal(int []arr){
        int zeroCount = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i]==0) zeroCount++;
        }
        for(int i=0; i<arr.length; i++){
            if(i<zeroCount) arr[i] = 0;
            else arr[i] = 1;
        }
    }

    private static void swap(int []arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void sortUsingTwoPointer(int []arr){
        int i = 0;
        int j = arr.length-1;
        while(i<=j){
            if(arr[i]==1 && arr[j]==0){
                swap(arr, i, j);
                i++;
                j--;
            }
            if(arr[i]==0){
                i++;
            }
            if(arr[j]==1){
                j--;
            }
        }
    }
    
    public static void main(String[] args) {
        int []arr = {1, 1, 1, 0, 1, 1};
        printArray(arr);
        // sortInNormal(arr);
        sortUsingTwoPointer(arr);
        System.out.println("After Sorting: ");
        printArray(arr);
    }    
}