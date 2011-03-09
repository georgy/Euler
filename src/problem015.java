public class problem015 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long matrix[][] = new long[20][20];
		matrix[0][0] = 1;
		for (int i = 1; i < 20; i++) {
			matrix[i][0] = 1;
			for (int j = 1; j < i; j++) {
				matrix[i][j] = matrix[i][j-1] + matrix[i-1][j];
			}
			matrix[i][i] = matrix[i][i-1] * 2;
		}
		for (long[] i : matrix) {
			long sum = 0;
			for (long j : i) {
				System.out.print(j+" ");
				sum += j;
			}
			System.out.println(sum*2);
		}
	}
}
