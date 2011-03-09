
public class problem021 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a;
		int sum = 0;
		for (int b = 1; b < 10000; b++) {
			a = d(b);
			if(d(a) == b && a != b) 
				sum += a + b;
		}
		System.out.println(sum/2);
	}

	public static int d(int n) {
		int sum = 0;
		for (int i = 1; i <= n/2; i++) {
			if(n % i == 0) sum += i;
		}
		return sum;
	}

}
