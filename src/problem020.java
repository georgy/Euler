
public class problem020 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "1";
		String s1;
		int c = 0;
		for (int i = 2; i < 101; i++) {
			s1 = "0";
			for (int j = 0; j < i; j++) {
				s1 = MyMath.getVeryLongSum(s1, s);
				c++;
			}
			s = s1;
			System.out.println(i+" "+s+" "+MyMath.getSumOfDigitsFromString(s)+" "+c);
		}
	}
}
