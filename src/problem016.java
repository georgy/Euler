
public class problem016 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String sum = "1";
		for (int i = 0; i < 1001; i++) {
			
			System.out.println(i+" "+
					MyMath.sum_digs_from_str(sum)+
					" "+sum);
			sum = MyMath.very_long_sum(sum, sum);
		}
	}
}
