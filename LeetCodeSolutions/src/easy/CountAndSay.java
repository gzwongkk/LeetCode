package easy;

public class CountAndSay {

	/**
	 * The count-and-say sequence is the sequence of integers beginning as follows:
	 * 1, 11, 21, 1211, 111221, ...
	 * 1 is read off as "one 1" or 11.
	 * 11 is read off as "two 1s" or 21.
	 * 21 is read off as "one 2", then "one 1" or 1211.
	 * Given an integer n, generate the nth sequence.
	 * Note: The sequence of integers will be represented as a string.
	 */
	public static void main(String[] args) {
		int n = 5;
		System.out.println(countAndSay(n));
	}

	/*
	 * Be careful of the definition of problem. It is asking for the nth element which 
	 * means it must be build bottom-up given by its nature.
	 */
	public static String countAndSay(int n){
		StringBuilder ans = new StringBuilder("1");
		for( int i = 1; i < n; ++i ){
			StringBuilder sequence = new StringBuilder();
			int digit = ans.charAt(0), count = 1;
			for( int j = 1; j < ans.length(); ++j ){
				if( ans.charAt(j) == digit ) ++count;
				else{
					sequence.append(count);
					sequence.append((char)digit);
					digit = ans.charAt(j);
					count = 1;
				}
			}
			sequence.append(count);
			sequence.append((char)digit);
			ans = sequence;
		}
		return ans.toString();
	}
}
