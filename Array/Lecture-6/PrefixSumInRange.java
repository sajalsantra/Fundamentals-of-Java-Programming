import java.util.Scanner;

class PrefixSumInRange {
    private static int[] prefixSum(int[] arr) {
        int[] prefixSum = new int[arr.length];
        prefixSum[0] = arr[0];
        for (int i = 1; i < arr.length; i++)
            prefixSum[i] = arr[i] + prefixSum[i - 1];
        return prefixSum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Array Size: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        int[] prefixSumArray = prefixSum(arr);
        System.out.print("PreFix Sum Array: ");
        for (int i = 0; i < prefixSumArray.length; i++)
            System.out.print(prefixSumArray[i] + " ");
        System.out.println();
        System.out.print("Enter Query: ");
        int q = sc.nextInt();
        System.out.println("Enter lower and upper Ranges[1-n]: ");
        while (q-- > 0) {
            int l = sc.nextInt();
            int h = sc.nextInt();
            System.out.println(prefixSumArray[h - 1] - prefixSumArray[l - 1]);
        }
    }
}