package sorting;
import java.util.Scanner;

public class quickSort {
    static void getArray(int []arr){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter array element");
        for(int i=0;i<arr.length;i++){
            arr[i]=sc.nextInt();
        }
    }
    static void printArray(int []arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    static void swap(int[]arr,int index1,int index2){
        int temp=arr[index1];
        arr[index1]=arr[index2];
        arr[index2]=temp;
    }
    static int partition(int []arr,int s,int e){
        int pivotIndex=s;
        int pivotElement=arr[s];
        for(int i=s+1;i<arr.length;i++){
            if(arr[i]<pivotElement){
                pivotIndex++;
            }
        }
        swap(arr,s,pivotIndex);
        int i=s,j=e;
        while(i<pivotIndex&&j>pivotIndex){
            if(arr[i]>arr[pivotIndex]&&arr[j]<arr[pivotIndex]){
                swap(arr,i,j);
                i++;j--;
            }
            if(arr[i]<arr[pivotIndex]) i++;
            if(arr[j]>arr[pivotIndex]) j--;
        }
        return pivotIndex;
    }
    static void quickSort(int []arr,int s,int e){
        if(s>=e) return;
        int pivotIndex=partition(arr,s,e);
//        swap(arr,s,pivotIndex);
//        int i=s,j=e;
//        while(i<pivotIndex&&j>pivotIndex){
//            if(arr[i]>arr[pivotIndex]&&arr[j]<arr[pivotIndex]){
//                swap(arr,i,j);
//                i++;j--;
//            }
//            if(arr[i]<arr[pivotIndex]) i++;
//            if(arr[j]>arr[pivotIndex]) j--;
//        }
        quickSort(arr,s,pivotIndex-1);
        quickSort(arr,pivotIndex+1,e);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array:");
        int n = sc.nextInt();
        int[] arr = new int[n];
        getArray(arr);
        System.out.println("Your Entered array is:");
        printArray(arr);
        System.out.println("Sorted arr is:");
        quickSort(arr, 0, n - 1);
        printArray(arr);
    }
}
