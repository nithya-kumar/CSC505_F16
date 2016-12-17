package matrixchainmult;

public class MatrixChainRecursion {
	
	static int recCount = 0;
	static int scaMult = 0;
	static int A[] = new int[] {5, 2, 4, 7, 3, 9, 7, 8, 6, 3, 7, 5, 5};
	static int n = A.length - 1;
	static int MAX = 99999;
	static int M[][] = new int[A.length][A.length];
	
	public static void main(String args[]) {
		long startTime = System.nanoTime();
		int optMult = RecursiveMatrixChain(A, 1, n);
		long endTime = System.nanoTime();
		System.out.println("M Matrix");
		PrintMMatrix();
		System.out.print("\n");
		System.out.println("Optimal no. of multiplications:::" + optMult);
		System.out.println("No. of recursive calls:::" + recCount);
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

	private static int RecursiveMatrixChain(int[] p, int i, int j) {
		recCount++;
	    if(i == j)
	        return 0;
	    int k;
	    M[i][j] = MAX;
	    int q;
	    for (k = i; k <j; k++)
	    {
	        q = RecursiveMatrixChain(p, i, k) + RecursiveMatrixChain(p, k+1, j) + p[i-1]*p[k]*p[j];
	        scaMult = scaMult + 2;
	        if (q < M[i][j])
	            M[i][j] = q;
	    }
	    return M[i][j];
	}
}