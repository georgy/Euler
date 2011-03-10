import java.util.*;

public class problem010 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long t1 = System.currentTimeMillis();
		List<Integer> pf = MyMath.genPrimeFactorsByMax(2000000);
		long sum = 0;
		for (int i : pf)
			sum += i;
		long t2 = System.currentTimeMillis();
		System.out.println(sum+" "+(t2-t1));
	}
}
