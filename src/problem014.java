
public class problem014 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int max = 0;
		int num = 0;
		long t1 = System.currentTimeMillis();
		for (int i = 1; i < 1000000; i++) {
			if(get_num(i)>max) {
				max = get_num(i);
				num = i;
			}
		}
		System.out.println(num+" "+max+" "+(System.currentTimeMillis()-t1));
	}
	
	public static int get_num(long start) {
		int sum = 1;
		while (start != 1) {
			if (start % 2 == 0)
				start /= 2;
			else
				start = 3 * start + 1;
			sum++;
		}
		return sum;
	}
}
