
public class problem028 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 1;
		int i = 2;
		long sum = 1;
		while (i < 1001) {
			for (int j = 0; j < 4; j++) {
				n += i;
				sum += n;
				//System.out.println(n+" "+sum);
			}
			i += 2;
			//System.out.println("i="+i);
		}
		System.out.println(sum);
	}

}
