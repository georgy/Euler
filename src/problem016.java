
public class problem016 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String sum = "1";
		for (int i = 0; i < 1001; i++) {
			
			System.out.println(i+" "+
					MyMath.getSumOfDigitsFromString(sum)+
					" "+sum);
			sum = MyMath.getVeryLongSum(sum, sum);
		}
	}
}
