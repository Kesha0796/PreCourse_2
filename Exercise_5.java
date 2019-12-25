import java.util.Stack;
public class IterativeQuickSort { 
    void swap(int arr[], int i, int j) 
    { 
	//Try swapping without extra variable 
        int temp = arr[i]; 
        arr[i] = arr[j]; 
        arr[j] = temp;
    }
  
    /* This function is same in both iterative and 
       recursive*/
    int partition(int arr[],int position, int l, int h) 
    { 
        int start = l; 
        int end = h - 2; 
        int piv = arr[position]; 
        swap(arr, position, h - 1); 
        while (start < end) 
        { 
            if (arr[start] < piv) 
            { start++; } 
            else if (arr[end] >= piv) 
            { end--; } 
            else 
            { swap(arr, start, end); } 
        } 
            int idx = end; 
            if (arr[end] < piv) 
            { idx++; } 
            swap(arr, h - 1, idx); 
            return idx;


    } 
  
    // Sorts arr[l..h] using iterative QuickSort 
    void QuickSort(int arr[], int l, int h) 
    { 
        //Try using Stack Data Structure to remove recursion.
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        stack.push(arr.length);

        while (!stack.isEmpty()) 
        { 
            int end = stack.pop(); 
            int start = stack.pop(); 
            if (end - start < 2) 
            { continue; } 
            int p = start + ((end - start) / 2); 
            p = partition(arr, p, start, end); 
            stack.push(p + 1); 
            stack.push(end); 
            stack.push(start); 
            stack.push(p); 
        }

    } 
  
    // A utility function to print contents of arr 
    void printArr(int arr[], int n) 
    { 
        int i; 
        for (i = 0; i < n; ++i) 
            System.out.print(arr[i] + " "); 
    } 
  
    // Driver code to test above 
    public static void main(String args[]) 
    { 
        IterativeQuickSort ob = new IterativeQuickSort(); 
        int arr[] = { 4, 3, 5, 2, 1, 3, 2, 3 }; 
        ob.QuickSort(arr, 0, arr.length - 1); 
        ob.printArr(arr, arr.length); 
    } 
} 