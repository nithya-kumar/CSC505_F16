package HW2;

public class TailRecursiveQuickSort {
	
	static int A[] = new int[] {5, 2, 4, 7, 3, 9, 8, 6};
	static int B[] = new int[] {10, 46, 9, 12, 34, 23, 98, 51};
	static int n = A.length - 1;
	
	public static void main(String args[]) {
		System.out.println("TAIL RECURSIVE QUICK SORT");
		System.out.println("Array before sorting..");
		printArray(A);
		tailRecursiveQuickSort(A, 0, n);
		System.out.println("\nArray after sorting..");
		printArray(A);
		System.out.println("\n\nTAIL RECURSIVE QUICK SORT MODIFIED STACK DEPTH O(lg n)");
		System.out.println("Array before sorting..");
		printArray(B);
		tailRecursiveQuickSortMod(B, 0, n);
		System.out.println("\nArray after sorting..");
		printArray(B);
	}

	private static void tailRecursiveQuickSort(int[] A, int p, int r) {
		int q = 0;
		while (p < r) {
			q = partition(A, p, r);
			tailRecursiveQuickSort(A, p, q - 1);
			p = q + 1;
		}
		
	}
	
	private static void tailRecursiveQuickSortMod(int[] A, int p, int r) {
		int q = 0;
		while (p < r) {
			q = partition(B, p, r);
			if ((q - p) < (r - q)) {
				tailRecursiveQuickSortMod(B, p, q - 1);
				p = q + 1;
			} else {
				tailRecursiveQuickSortMod(B, q + 1, r);
				r = q - 1;
			}
		}
		
	}
	
	private static int partition(int[] arr, int p, int r) {
		int pivot = arr[r];  
		int i = p - 1;

	    for (int j = p; j <= r - 1; j++)
	    {
	        if (arr[j] <= pivot)
	        {
	            i++;
	            swap(arr, i, j);
	        }
	    }
	    swap (arr, i + 1, r);
	    return i + 1;
	}

	private static void swap(int[] arr, int i, int j) {
		int temp;
		temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		
	}

	private static void printArray(int[] arr) {
		for (int i = 0; i <= n; i++) {
			System.out.print(arr[i]+"\t");
		}
	}
}