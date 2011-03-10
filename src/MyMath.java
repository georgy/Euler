import java.util.*;

public class MyMath {
	
	public static List<Integer> genPrimeFactorsByMax(int max) {
		List<Integer> res = new LinkedList<Integer>();
		double q;
		if (max < 2)
			return res;
		else {
			res.add(2);
			if (max == 2)
				return res;
			else {
				boolean flag;
				for (int i = 3; i <= max; i++) {
					flag = true;
					q = Math.sqrt(i);
					for (int j : res) {
						if (j > q)
							break;
						if (i%j == 0) {
							flag = false;
							break;
						}
					}
					if (flag)
						res.add(i);
				}
				return res;
			}
		}
	}
	public static List<Integer> genPrimeFactors(int quant) {
		List<Integer> res = new LinkedList<Integer>();
		double q;
		if (quant < 1)
			return res;
		else {
			res.add(2);
			if (quant == 1)
				return res;
			else {
				boolean flag;
				for (int i = 3; res.size() < quant; i++) {
					flag = true;
					q = Math.sqrt(i);
					for (int j : res) {
						if (j > q)
							break;
						if (i%j == 0) {
							flag = false;
							break;
						}
					}
					if (flag)
						res.add(i);
				}
				return res;
			}
		}
	}
	public static List<Integer> expandNumberToPrimeFactors(int num) {
		List<Integer> res = new LinkedList<Integer>();
		List<Integer> pf = genPrimeFactorsByMax((int)Math.sqrt(num));
		for (int i : pf) {
			while (num % i == 0) {
				res.add(i);
				num /= i;
			}
		}
		if (num > 1)
			res.add(num);
		return res;
	}
	public static List<Integer> genAbundantNumbersByMax(int max) {
		// Избыточные числа - сумма делителей больше самого числа
		List<Integer> res = new LinkedList<Integer>();
		int sum;
		for (int i = 1; i < max; i++) {
			sum = 0;
			for (int j = 1; j <= i/2; j++) {
				if (i % j == 0) sum += j;
			}
			if(sum > i) res.add(i);
		}
		return res;
	}
	/**
	 *  НОК - наименьшее общее кратное, т.е. это наименьшее число,
	 *  которое делится без остатка на оба исходных числа
    */
	public static int getLowestCommonMultiple(int num1, int num2) {
		List<Integer> res = new LinkedList<Integer>();
		List<Integer> l_num1 = expandNumberToPrimeFactors(num1);
		List<Integer> l_num2 = expandNumberToPrimeFactors(num2);

		res = new LinkedList<Integer>(l_num1);
		
		List<Integer> tmp = new LinkedList<Integer>(l_num2);
		List<Integer> tmp2 = new LinkedList<Integer>(res);
		boolean flag = true;
		boolean flag2 = true;
		int val = 0;
		while(flag && !tmp.isEmpty() && !tmp2.isEmpty()) {
			if(!flag2) {
				tmp.remove(tmp.indexOf(val));
				tmp2.remove(tmp2.indexOf(val));
			}
			flag2 = true;
			for (int i : tmp) {
				if(flag2 && !tmp.isEmpty() && !tmp2.isEmpty()) {
					for (int j : tmp2) {
						if (i == j && flag2) {
							flag2 = false;
							val = i;
						}
					}
				}
			}
			if(flag2)
				flag = false;
		}
		res.addAll(tmp);
		int mul = 1;
		for (int i : res) {
			mul *= i;
		}
		return mul;
	}
	public static int getQuantityOfDivisors(int num) {
		List<Integer> fact = expandNumberToPrimeFactors(num);
		List<Integer> count = new LinkedList<Integer>();
		int p = 0;
		if (num == 120)
			p = 0;
		for (int c : fact) {
			if (c == p)
				count.set(count.size()-1, count.get(count.size()-1)+1);
			else {
				count.add(2);
				p = c;
			}
		}
		int prod = 1;
		for (int i : count)
			prod *= i;
		return prod;
	}
	public static String getVeryLongSum(String a, String b) {
		String sum = "";
		int al = a.length();
		int bl = b.length();
		int m = Math.max(al, bl);
		int x;
		int y;
		Integer z;
		int p = 0;
		for (int i = 0; i < m; i++) {
			if(i < al)
				x = Integer.parseInt(a.substring(al-i-1, al-i));
			else
				x = 0;
			if(i < bl)
				y = Integer.parseInt(b.substring(bl-i-1, bl-i));
			else
				y = 0;
			z = x + y + p;
			if(z < 10) {
				sum = z.toString() + sum;
				p = 0;
			}
			else {
				sum = Integer.toString(z-10) + sum;
				p = 1;
			}
		}
		if(p == 1)
			sum = "1" + sum;
		return sum;
	}
	public static String veryLongMultiplication(String a, String b) {
		String mul = "";
		String cur;
		List<String> list = new LinkedList<String>();
		int al = a.length();
		int bl = b.length();
		int x;
		int y;
		int z;
		Integer d;
		Integer p = 0;
		for (int i = 0; i < bl; i++) {
			cur = "";
			for (int j = 0; j < i; j++)
				cur = "0" + cur;
			for (int j = 0; j < al; j++) {
				x = a.charAt(al - j - 1) - 48;
				y = b.charAt(bl - i - 1) - 48;
				z = x * y + p;
				d = z % 10;
				p = (z - d) / 10;
				cur = d.toString() + cur; 
			}
			if(p > 0)
				cur = p.toString() + cur;
			list.add(new String(cur));
		}
		mul = list.get(0);
		if(list.size() > 1)
			for (int i = 1; i < list.size(); i++) 
				mul = getVeryLongSum(mul, list.get(i));
		return mul;
	}
	/**
	 * Result: (a > b) = 1; (a < b) = -1; (a = b) = 0;
	 * */
	public static int getVeryLongCompare(String a, String b) {
		if(a.equals(b))
			return 0;
		else {
			int result = 0;
			boolean minus = false;
			if(a.charAt(0) == 45 && b.charAt(0) != 45) return -1;
			if(a.charAt(0) != 45 && b.charAt(0) == 45) return 1;
			if(a.charAt(0) == 45 && b.charAt(0) == 45) { 
				minus = true;
				a = a.substring(1,a.length());
				b = b.substring(1,b.length());
			}
			if (a.charAt(0) == 46) a = "0" + a;
			if (b.charAt(0) == 46) b = "0" + b;
			while(a.charAt(0) == 48 && a.charAt(1) != 46)
				a = a.substring(1,a.length());
			while(b.charAt(0) == 48 && b.charAt(1) != 46)
				b = b.substring(1,b.length());
			boolean done = false;
			int aPointPos = a.indexOf(".");
			int bPointPos = b.indexOf(".");
			int aLength = a.length();
			int bLength = b.length();
			int aIntegerPart = aLength; 
			int bIntegerPart = bLength;
			int aCurDigit = 0;
			int bCurDigit = 0;
			if (aPointPos > -1) {
				aIntegerPart = aPointPos;
			}
			if (bPointPos > -1) {
				bIntegerPart = bPointPos;
			}
			if (aIntegerPart != bIntegerPart) {
				done = true;
				if(aIntegerPart > bIntegerPart)	result = 1;
				else result = -1;
			} else {
				for (int i = 0; i < aIntegerPart; i++) {
					aCurDigit = a.charAt(i) - 48;
					bCurDigit = b.charAt(i) - 48;
					if(aCurDigit != bCurDigit) {
						done = true;
						if(aCurDigit > bCurDigit) { result = 1; }
						else { result = -1; }
						break;
					}
				}
				int maxFloatPart = Math.max(aLength - aIntegerPart - 1, bLength - bIntegerPart - 1);
				if(!done) {
					for (int i = 0; i < maxFloatPart; i++) {
						if(aLength < aIntegerPart + i + 2) {
							aCurDigit = 0;
						} else {
							aCurDigit = a.charAt(aIntegerPart + i + 1) - 48;
						}
						if(bLength < bIntegerPart + i + 2) {
							bCurDigit = 0;
						} else {
							bCurDigit = b.charAt(bIntegerPart + i + 1) - 48;
						}
						if(aCurDigit != bCurDigit) {
							done = true;
							if(aCurDigit > bCurDigit) { result = 1; }
							else { result = -1; }
						}
					}
				}
			}
			if(minus) result = 0 - result;
			return result;
		}
	}
	public static String very_long_div(String a, String b, int e) {
		return "";
	}
	public static long getFactorial(int n) {
		if (n > 1)
			return n * getFactorial(n-1);
		return 1;		
	}
	public static Long getProductionOfDigitsFromString(String source) {
		Long mul = 1L;
		String s;
		for (Character c : source.toCharArray()) {
			s = c.toString();
			mul *= Integer.parseInt(s); 
		}
		return mul;
	}
	public static int getSumOfDigitsFromString(String source) {
		int sum = 0;
		String s;
		for (Character c : source.toCharArray()) {
			s = c.toString();
			sum += Integer.parseInt(s); 
		}
		return sum;
	}
	public static String getSpellOfSum(int sum) {
		String res = "";
		if(sum == 0)
			res = "zero";
		else {
			String s_sum = String.valueOf(sum);
			String[] s0_num = {"Error!","one","two","three","four","five","six","seven","eight","nine"};
			String[] s1_num = {"ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"};
			String[] s2_num = {"Error!","Error!","twenty","thirty","forty","fifty","sixty","seventy","eighty","ninety"};

			boolean flag = false;
			int[] n = new int[7];
			for (int i = 0; i < s_sum.length() && i < 7; i++) {
				n[i] = Integer.valueOf(s_sum.substring(s_sum.length()-i-1, s_sum.length()-i));
			}
			if(n[0] > 0 && n[1] != 1) {
				res = s0_num[n[0]] + res;
				flag = true;
			}
		
			if(n[1] == 1) {
				res = s1_num[n[0]] + res;
				flag = true;
			}
		
			if(n[1] > 1) {
				if(flag)
					res = "-" + res;
				res = s2_num[n[1]] + res;
				flag = true;
			}
		
			if(n[2] > 0) {
				if(flag)
					res = " and " + res;
				res = s0_num[n[2]] + " hundred" + res;
				flag = true;
			}

			if(n[3] > 0) {
				if(flag)
					res = " and " + res;
				res = s0_num[n[3]] + " thousand" + res;
			}
		}
		return res;
	}
	public static String getNextPermutation(String src) {
		boolean flag = false;
		int pos = 0;
		int val = 0;
		List<Integer> list = new LinkedList<Integer>();
		for (int i = src.length() - 1; i > 0; i--) {
			list.add(new Integer(src.charAt(i)-48));
			if(src.charAt(i) > src.charAt(i-1)) {
				list.add(new Integer(src.charAt(i-1)-48));
				flag = true;
				pos = i;
				val = src.charAt(i-1) - 48;
				break;
			}
		}
		if(flag) {
			String next = src.substring(0,pos-1);
			Collections.sort(list);
			int p = 0;
			for (int i : list) {
				if(i > val) {
					p = list.indexOf(i);
					break;
				}
			}
			next += list.get(p).toString();
			list.remove(p);
			for (Integer i : list) {
				next += i.toString();
			}
			return next;
		} else
			return null;
	}

}
