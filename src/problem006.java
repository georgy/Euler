public class problem006 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 100;
		int sum_sq = 0;
		int sq_sum;
		for (int i = 1; i <= n; i++)
			sum_sq += i*i;
		sq_sum = (n*n*n*n + 2*n*n*n + n*n) / 4;
		System.out.println(sq_sum-sum_sq);
	}

}
