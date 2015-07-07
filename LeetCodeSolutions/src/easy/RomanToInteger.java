package easy;

public class RomanToInteger {

	/**
	 * Given a Roman numeral, convert it to an integer.
	 * Input is guaranteed to be within the range from 1 to 3999.
	 */
	public static void main(String[] args) {
		String roman = "MMXXXVI";
		System.out.println(romanToInt(roman));
	}

	/*
	 * To decode something, it seems to be always better to do in bottom-up order.
	 */
	public static int romanToInt(String s){
		int ans = 0;
		for( int i = s.length() - 1; i >= 0; --i ){
			switch(s.charAt(i)){
			case 'I':
				ans += ( ans >= 5 ? -1 : 1 );
				break;
			case 'V':
				ans += 5;
				break;
			case 'X':
				ans += (ans >= 50 ? -10 : 10 );
				break;
			case 'L':
				ans += 50;
				break;
			case 'C':
				ans += (ans >= 500 ? -100 : 100 );
				break;
			case 'D':
				ans += 500;
				break;
			case 'M':
				ans += 1000;
				break;
			}
		}
		return ans;
	}
}
