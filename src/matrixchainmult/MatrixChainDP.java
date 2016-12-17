package matrixchainmult;

public class MatrixChainDP {
	
	static int recCount = 0;
	static int scaMult = 0;
	static int A[] = new int[] {5, 2, 4, 7, 3, 9, 7, 8, 6, 3, 7, 5, 5};
	static int n = A.length - 1;
	static int MAX = 99999;
	static int M[][] = new int[A.length][A.length];
	static int S[][] = new int[A.length][A.length];
	
	public static void main(String args[]) {
		long startTime = System.nanoTime();
		int optMult = MatrixChainOrder(A, n);
		long endTime = System.nanoTime();
		System.out.println("M Matrix");
		PrintMMatrix();
		System.out.println("\nS Matrix");
		PrintSMatrix();
		System.out.print("\n");
		System.out.print("Optimal Parenthesization:::");
		PrintOptimalParens(1, n);
		System.out.println("\nOptimal no. of multiplications:::" + optMult);
		System.out.println("\nNo. of recursive calls:::" + recCount);
		System.out.println("No. of scalar of multiplications:::" + scaMult);
		System.out.println("Running Time:::" + (endTime-startTime)/1000);
	}

	private static int MatrixChainOrder(int[] p, int n) {
	    for (int i = 1; i <= n; i++)
	        M[i][i] = 0;
	    for (int l = 2; l <= n; l++) {
	        for (int i = 1; i <= n-l+1; i++) {
	            int j = i+l-1;
	            M[i][j] = MAX;
	            for (int k = i; k <= j-1; k++) {
	            	scaMult = scaMult + 2;
	                int q = M[i][k] + M[k+1][j] + p[i-1]*p[k]*p[j];
	                if (q < M[i][j]) {
	                    M[i][j] = q;
	                    S[i][j] = k;
	                }
	            }
	        }
	    }
	    return M[1][n];
	}
	
	private static void PrintOptimalParens(int i, int j) {
		if (i == j) {
			System.out.print("A"+i);
		}
		else {
			System.out.print("(");
			PrintOptimalParens(i, S[i][j]);
			PrintOptimalParens(S[i][j] + 1, j);
			System.out.print(")");
		}
	}
	
	private static void PrintSMatrix() {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				System.out.print(S[i][j]+"\t");
			}
			System.out.print("\n");
		}
	}

	private static void PrintMMatrix() {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				System.out.print(M[i][j]+"\t");
			}
			System.out.print("\n");
		}
	}
}