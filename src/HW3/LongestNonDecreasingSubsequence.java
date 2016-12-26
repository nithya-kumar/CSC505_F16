package HW3;

public class LongestNonDecreasingSubsequence {
	public static void main (String args[]) {
		int A[] = new int [] {1,12,7,0,23,11,52,31,61,69,70,2};
    	System.out.println(LNDS(A));
	}

	private static String LNDS(int[] A) {
		int n = A.length;
		int l[] = new int [n+1];
		for (int i = 1; i <= n; i++) {
			int max = 0;
			for (int j = 1; j <= i; j++) {
				if (A[i] >= A[j]) {
					if (max != 0 || max < l[j] + 1) {
						max = l[j] + 1;
					}
				}
			}
			if (max == 0) {
				max = 1;
			}
			l[i] = max;
		}
		int index = findMax(l);
		return printLNDS(A, l, l[index], index);
	}

	private static int findMax(int[] l) {
		int max = 0;
		int index = 0;
		for (int i = 0; i < l.length; i++) {
			if (max < l[i]) {
				max = l[i];
				index = i;
			}
		}
		return index;
	}

	private static String printLNDS(int[] A, int[] l, int max, int index) {
		String LNDS = A[index] + "";
		int max1;
		for (int i = index - 1; i > 0; i--) {
			max1 = max - 1;
			if (l[i] == max1) {
				LNDS = A[i] + "," + LNDS;
				max1--;
			}
		}
		return LNDS;
	}
}
