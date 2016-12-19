package HW2;

public class ChangingNCents {
	static int D[] = new int[] {9, 6, 5, 1};
	static int n = D.length - 1;
	static int numCoins = 0;
	static int MAX = 99999;
	
	public static void main(String args[]) {
		int amount = 11;
		int numCoins = changeNCentsRecursive(amount);
		System.out.println("CHANGE N CENTS RECURSIVE");
		System.out.println("No. of coins needed to change " + amount + " cents is: " + numCoins);
		System.out.println("CHANGE N CENTS DP");
		numCoins = changeNCentsDP(amount);
		System.out.println("No. of coins needed to change " + amount + " cents is: " + numCoins);
	}

	private static int changeNCentsDP(int amount) {
		int A[] = new int[amount + 1];
		for (int i = 1; i <= amount; i++) {
			A[i] = MAX;
		}
		for (int i = 1; i <= amount; i++) {
			for (int j = 1; j <= n; j++) {
				if (D[j] <= i) {
					int rem = A[i - D[j]];
					if (rem != MAX && (rem + 1) < A[i]) {
						A[i] = rem + 1;
					}
				}
			}
		}
		return A[amount];
	}

	private static int changeNCentsRecursive(int amount) {
		if (amount == 0) {
			return 1;
		}
		if (amount < 0) {
			return 0;
		}
		int i = 0;
		while (amount < D[i]) {
			i ++;
		}
		++ numCoins;
		changeNCentsRecursive(amount - D[i]);
		return numCoins;
	}
}
