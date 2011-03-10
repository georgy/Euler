public class problem004 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int max = 1;
		Integer cur;
		String s, sr;
		for (int i = 1; i<1000; i++) {
			for (int j = i; j<1000; j++) {
				cur = i*j;
				s = cur.toString();
				sr = new StringBuffer(s).reverse().toString();
				if (s.equals(sr)) {
					if(cur > max)
						max = cur;
				}
			}
		}
		System.out.println(max);
	}
}
