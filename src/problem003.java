import java.util.*;

public class problem003 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> pf = new LinkedList<Integer>();
		long num = 600851475143l;
		pf.add(2);
		int max = 2;
		double q;
		boolean flag;
		for(int i = 3; i <= Math.sqrt(num); i++) {
			flag = true;
			q = Math.sqrt(i);
			for (int j : pf) {
				if(j>q)
					break;
				if(i%j == 0)
					flag = false;
			}
			if(flag && num%i == 0) {
				pf.add(i);
				max = i;
			}
		}
		System.out.println(max);
	}

}
