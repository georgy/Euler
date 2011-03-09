public class problem002 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 1;
		int b = 2;
		int c = a + b;
		long sum = a + b + c;
		while (c <= 4000000) {
			a = b + c;
			b = c + a;
			c = a + b;
			sum += b;
		}
		System.out.println(sum);
	}
}
