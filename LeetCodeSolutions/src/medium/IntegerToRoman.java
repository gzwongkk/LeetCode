package medium;

public class IntegerToRoman {

	/**
	 * Given an integer, convert it to a Roman numeral.
	 * Input is guaranteed to be within the range from 1 to 3999.
	 **/
	public static void main(String[] args) {
		System.out.println(intToRoman(2046));
	}

	/*
	 * Simple java intuitive solution can be drawn, using the idea of huffman's code.
	 * However, to improve runtime (don't iterate more than one time for one digit),
	 * using arrays instead of cases should be a better way to go. Elegant.
	 */
	public static String intToRoman(int num){
		String M[] = {"", "M", "MM", "MMM"};
		String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
		String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
		String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
		return M[ num / 1000 ] + C[( num % 1000 ) / 100] + X[( num % 100 ) / 10 ] + I[ num % 10 ];
	}
	
	public static String intToRomanIntuitive(int num){
		String roman = "";
		while( num > 0 ){
			if( num >= 1000 ){
				num -= 1000;
				roman += 'M';
			} else if ( num >= 900 ){
				num -= 900;
				roman += "CM";
			} else if ( num >= 500 ){
				num -= 500;
				roman += 'D';
			} else if ( num >= 400 ){
				num -= 400;
				roman += "CD";
			} else if ( num >= 100 ){
				num -= 100;
				roman += 'C';
			} else if ( num >= 90 ){
				num -= 90;
				roman += "XC";
			} else if ( num >= 50 ){
				num -= 50;
				roman += 'L';
			} else if ( num >= 40 ){
				num -= 40;
				roman += "XL";
			} else if ( num >= 10 ){
				num -= 10;
				roman += 'X';
			} else if ( num == 9 ){
				return roman + "IX";
			} else if ( num >= 5 ){
				num -= 5;
				roman += 'V';
			} else if ( num == 4 ){
				return roman + "IV";
			} else {
				--num;
				roman += 'I';
			}
		}
		return roman;
	}
}
