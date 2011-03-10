public class problem012 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int t;
		int cur;
		int max = 0;
		int total = 0;
		int num = 0;
		long time1 = System.currentTimeMillis();
		int i = 1;
		while (max <= 500) {
			t = gen_triangle(i);

			cur = my_math.get_num_of_divisors(t);
			if(cur > max)
				max = cur;
			if(max > 500){
				total = t;
				num = i;
			}
			i++;
		}
		System.out.println(num+";"+total+";"+max);
		long time2 = System.currentTimeMillis();
		System.out.println("finish "+max+" "+(time2-time1));
	}

	public static int gen_triangle(int pos) {
		return (pos*pos+pos)/2;
	}
}
