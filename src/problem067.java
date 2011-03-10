import java.io.*;

public class problem067 {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileReader fr = new FileReader("src/problem067.txt");
		BufferedReader in = new BufferedReader(fr);
		String str;
		Integer matrix[][] = new Integer[100][100];
		int r = 0;
		int c;
		while((str = in.readLine()) != null) {
			c = 0;
			for (String num : str.split(" ")) {
				matrix[r][c] = Integer.valueOf(num);
				c++;
			}
			r++;
		}
		Integer matrix2[] = matrix[matrix.length - 1];
		for (int i = matrix.length - 2; i >= 0; i--) {
			for (int j = 0; j < i + 1; j++) {
				matrix2[j] = Math.max(matrix2[j], matrix2[j+1]) + matrix[i][j];
				System.out.print(matrix2[j]+" ");
			}
			System.out.println(" ");
		}
	}

}
