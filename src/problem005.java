public class problem005 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int prod = 1;
		for (int i = 2; i <= 20; i++)
			prod = MyMath.nok(i,prod);
		System.out.println(prod);
	}
}
	
