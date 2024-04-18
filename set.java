import java.util.Arrays;

public class set {
//TODO- leetcode 26
    static int removeDuplicates(int[] arr) {
    
    int len = 0;
    for(int i = 1; i< arr.length;i++) {
        if(arr[i] != arr[len]) {
          len++;        
          arr[len] = arr[i];
        }
    }
    return len+1;
    } 

  public static void main(String[] args) {
    int[] ar1 = {3,3,3,5,6,7}; 
    int len1 = removeDuplicates(ar1);
    System.out.println("Intial Given Array1: "+ Arrays.toString(ar1));
    System.out.println("After Removal Of Duplicates");
    for(int i = 0; i < len1;i++) {
      System.out.print(ar1[i] + " "); 
    } 
    System.out.println();
    
    
    int[] ar2 = {9,9,10,11,11,11,11,64,64,99}; 
    int len2 = removeDuplicates(ar2);
    System.out.println("Intial Given Array2: " + Arrays.toString(ar2));
    System.out.println("After Removal Of Duplicates");
    for(int i = 0; i < len2;i++) {
      System.out.print(ar2[i] + " ");  
    }
    System.out.println();
}
} 