
public class problem017 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "";
		for (int i = 1; i <= 1000; i++) {
			s += MyMath.getSpellOfSum(i).replaceAll(" ", "");
			System.out.println(i+" "+MyMath.getSpellOfSum(i)+
					" "+MyMath.getSpellOfSum(i).replaceAll(" ","").replaceAll("-", "").length());
		}
		s = s.replaceAll("-", "");
		System.out.println(s.length());
	}

}
