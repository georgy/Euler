import java.util.*;

public class problem023 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> lst = my_math.gen_abundant_by_max(30000);
		int n = lst.size();
		boolean[] a = new boolean[30000];
		for (int i = 0; i < n; i++) {
			a[lst.get(i)] = true;
		}
		int m;
		int c;
		boolean flag;
		int sum = 0;
		for (int i = 1; i < 30000; i++) {
			m = i/2;
			flag = true;
			for (int j = 0; j < n; j++) {
				c = lst.get(j);
				if(c > m) break;
				if(a[i-c]) {
					flag = false;
					break;
				}
			}
			if(flag) sum += i;
		}
		System.out.println(sum);
	}
}
