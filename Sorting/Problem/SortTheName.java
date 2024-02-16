package Sorting.Problem;

public class SortTheName {
    public static void printFruits(String []fruits){
        for(String str : fruits){
            System.out.print(str +" ");
        }
        System.out.println();
    }

    public static void sortFruits(String []fruits){
        for(int i=0; i<fruits.length; i++){
            int idx = i;
            for(int j=i; j<fruits.length; j++){
                if(fruits[i].compareTo(fruits[j])>0){
                    idx = j;
                }
            }
            if(idx!=i){
                String temp = fruits[i];
                fruits[i] = fruits[idx];
                fruits[idx] = temp;
            }
        }
    }
    public static void main(String[] args) {
        String []fruits = {"kiwi", "apple", "papya", "mango"};
        sortFruits(fruits);
        printFruits(fruits);
    }
}