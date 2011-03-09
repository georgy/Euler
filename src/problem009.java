public class problem009 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int c;
		for (int b = 0; b < 500; b++) {
			for (int a = 0; a < b; a++) {
				c = 1000 - a - b;
				if (c*c == a*a+b*b)
					System.out.println(a*b*c);
			}
		}
	}

}
