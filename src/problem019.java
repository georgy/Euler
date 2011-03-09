
public class problem019 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int d = 1;
		int m = 1;
		int y = 1900;
		int w = 1;
		int count = 0;
		while(y < 2001) {
			if (y >= 1901 && y <= 2000 && d == 1 && w == 7) {
				System.out.println(d+":"+m+":"+y+" "+w);
				count++;
			}
			d++;
			w++;
			if(w > 7) w = 1;
			switch (m) {
				case 1: case 3: case 5: case 7: case 8: case 10: case 12:
					if(d > 31) {
						d = 1;
						m++;
					}
					break;
				case 4: case 6: case 9: case 11:
					if(d > 30) {
						d = 1;
						m++;
					}
					break;
				case 2:
					if((y%4 == 0 && d > 29) || (y%4 != 0 && d > 28)) {
						d = 1;
						m++;
					}
			}
			if (m > 12) {
				m = 1;
				y++;
			}
		}
		System.out.println(count);
	}
}
