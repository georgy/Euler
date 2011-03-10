
public class problem025 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "1";
		String b = "1";
		String c = "2";
		int cc = 3;
		while (true) {
			a = b;
			b = c;
			c = MyMath.veryLongSum(a, b);
			cc++;
			//System.out.println(cc+" "+c+" "+c.length());
			if(c.length() > 999) break;
		}
		System.out.println(cc+" "+c+" "+c.length());
	}

}
