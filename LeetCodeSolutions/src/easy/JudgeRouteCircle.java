package easy;

public class JudgeRouteCircle {
	/**
	 * 
	 * Initially, there is a Robot at position (0, 0). Given a sequence of its moves, 
	 * judge if this robot makes a circle, which means it moves back to the original place.
	 * 
	 * The move sequence is represented by a string. And each move is represent by a character. 
	 * The valid robot moves are R (Right), L (Left), U (Up) and D (down). The output should be 
	 * true or false representing whether the robot makes a circle.
	 * 
	 * Example 1:
	 * Input: "UD"
	 * Output: true
	 * 
	 * Example 2:
	 * Input: "LL"
	 * Output: false
	 * 
	 **/
	public static void main(String[] args) {
		System.out.println(judgeCircle("UD"));
		System.out.println(judgeCircle("LL"));
	}

	// Lazy way
	public static boolean judgeCircle(String moves) {
		char[] ms = moves.toCharArray();
		int[] count = new int[26];
		for ( char m : ms ) {
			count[m-'A']++;
		}
		return count['U'-'A'] == count['D'-'A'] && count['L'-'A'] == count['R'-'A'];
	}

	// Naive but accurate
	public static boolean judgeCircleNaive(String moves) {
		char[] ms = moves.toCharArray();
		int x = 0, y = 0;
		for ( char m : ms ) {
			if ( m == 'U' ) ++y;
			else if ( m == 'D' ) --y;
			else if ( m == 'L' ) --x;
			else if ( m == 'R' ) ++x;
		}
		return x == 0 && y == 0;
	}
}
