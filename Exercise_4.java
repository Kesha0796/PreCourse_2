public class MergeSort 
{ 
    // Merges two subarrays of arr[]. 
    // First subarray is arr[l..m] 
    // Second subarray is arr[m+1..r] 
    void merge(int arr[], int l, int m, int r) 
    {  
       //Your code here 
       int[] L = new int[m - l + 2];
	
        for (int i = l; i <= m; i++) {
            L[i - l] = arr[i];
        }
        L[m - l + 1] = Integer.MAX_VALUE;
        int[] R = new int[r - m + 1];
        
        for (int i = m + 1; i <= r; i++) {
            R[i - m - 1] = arr[i];
        }
        R[r - m] = Integer.MAX_VALUE;
        int i = 0, j = 0;
        
        for (int k = l; k <= r; k++) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
        }  
    } 
  
    // Main function that sorts arr[l..r] using 
    // merge() 
    void sort(int arr[], int l, int r) 
    { 
	//Write your code here
        //Call mergeSort from here 
        if (l == r)
		return;
	    else {
		int midIndex = (l + r) / 2;
		sort(arr, l, midIndex);
		sort(arr, midIndex + 1, r);
		merge(arr, l, midIndex, r);
	} 
        
    } 
  
    /* A utility function to print array of size n */
    static void printArray(int arr[]) 
    { 
        int n = arr.length; 
        for (int i=0; i<n; ++i) 
            System.out.print(arr[i] + " "); 
        System.out.println(); 
    } 
  
    // Driver method 
    public static void main(String args[]) 
    { 
        int arr[] = {12, 11, 13, 5, 6, 7}; 
  
        System.out.println("Given Array"); 
        printArray(arr); 
  
        MergeSort ob = new MergeSort(); 
        ob.sort(arr, 0, arr.length-1); 
  
        System.out.println("\nSorted array"); 
        printArray(arr); 
    } 
} 