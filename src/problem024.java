public class problem024 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String src = "0123456789";
		int num = 1;
		while (src != null) {
			if(num >= 1000000)
				break;
			num++;
			src = MyMath.getNextPermutation(src);
		}
		System.out.println(src + " " + num);
	}
}
