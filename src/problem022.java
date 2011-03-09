import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;


public class problem022 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileReader fr;
		try {
			fr = new FileReader("src/problem022.txt");
			BufferedReader in = new BufferedReader(fr);
			String str = in.readLine();
			String[] s = str.split(",");
			Arrays.sort(s);
			long sum = 0;
			long cur;
			for (int i = 0; i < s.length; i++) {
				cur = 0;
				for (int j = 1; j < s[i].length()-1; j++) {
					cur += (int)s[i].charAt(j) - 64;
				}
				sum += cur * (i + 1);
			}
			System.out.println(sum);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
