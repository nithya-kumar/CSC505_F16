package HW2;

// To implement a non recursive solution for finding power of number in O(lg n)
public class PowerOfNumber {
	public static void main (String args[]) {
		int a = 16;
		int n = 4;
		int power = powerExpoBySquaring(a, n);
		System.out.println(a + " to the power of " + n + " is: " + power);
	}

	private static int powerExpoBySquaring(int a, int n) {
		int b = 1;
		while (n > 1) {
			if (n % 2 == 0) {
				a = a * a;
				n = n/2;
			}
			else {
				b = a * b;
				a = a * a;
				n = (n - 1) / 2;
			}
		}
		return a * b;
	}
}
