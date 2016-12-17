package matrixchainmult;

public class MatrixChainMemoized {
	
	static int recCount = 0;
	static int scaMult = 0;
	static int A[] = new int[] {5, 2, 4, 7, 3, 9, 7, 8, 6, 3, 7, 5, 5};
	static int n = A.length - 1;
	static int MAX = 99999;
	static int M[][] = new int[A.length][A.length];
	
	public static void main(String args[]) {
		long startTime = System.nanoTime();
		int optMult = MemoizedMatrixChain(A);
		long endTime = System.nanoTime();
		System.out.println("M Matrix");
		PrintMMatrix();
		System.out.println("\nOptimal no. of multiplications:::" + optMult);
		System.out.println("\nNo. of recursive calls:::" + recCount);
		System.out.println("No. of scalar of multiplications:::" + scaMult);
		System.out.println("Running Time:::" + (endTime-startTime)/1000);
	}

	private static void PrintMMatrix() {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				System.out.print(M[i][j]+"\t");
			}
			System.out.print("\n");
		}
	}

	private static int MemoizedMatrixChain(int[] p) {
		for (int i = 1; i <= n; i++) {
	        for (int j = 1; j <= n; j++) {
	            M[i][j] = MAX;
	        }
	    }
		return LookupChain(M, p, 1, n);
	}

	private static int LookupChain(int[][] M, int[] p, int i, int j) {
		recCount ++;
		if (M[i][j] < MAX) {
			return M[i][j];
		}
		if (i == j) {
			M[i][j] = 0;
		}
		else {
			for (int k = i; k<=j-1; k++) {
				scaMult = scaMult + 2;
				int q = LookupChain(M, p, i, k) + LookupChain(M, p, k+1, j) + p[i-1]*p[k]*p[j];
				if (q < M[i][j]) {
					M[i][j] = q;
				}
			}
	     }
		return M[i][j];
	}
}