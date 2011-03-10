
public class problem017 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "";
		for (int i = 1; i <= 1000; i++) {
			s += my_math.sum_to_words(i).replaceAll(" ", "");
			System.out.println(i+" "+my_math.sum_to_words(i)+
					" "+my_math.sum_to_words(i).replaceAll(" ","").replaceAll("-", "").length());
		}
		s = s.replaceAll("-", "");
		System.out.println(s.length());
	}

}
