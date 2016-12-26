package HW3;

public class GreedyCellPhoneTower {
	
	public static void main(String[] args) {
	    int x[] =  {1,3,5,9,15,20};
	    int d = 3;
	    int n = x.length;
	    printBuildTowerLocation(x, n, d);
    }

	private static void printBuildTowerLocation(int[] x, int n, int d) {

		System.out.print("Build towers at the foll. locations: ");
		int y[] = new int [n];
		y[0] = x[0] + d;
		System.out.print(y[0]);
		int j = 0;
		for (int i = 1; i < n; i++) {
			if (Math.abs(y[j] - x[i]) > d) {
				y[j+1] = x[i] + d;
				System.out.print("," + y[j+1]);
				j++;
			}
		}
	}
}
