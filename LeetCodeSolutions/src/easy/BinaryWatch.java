package easy;

import java.util.ArrayList;
import java.util.List;

public class BinaryWatch {
	/**
	 * A binary watch has 4 LEDs on the top which represent the hours (0-11), 
	 * and the 6 LEDs on the bottom represent the minutes (0-59).
	 * Each LED represents a zero or one, with the least significant bit on the right.
	 * 
	 * Given a non-negative integer n which represents the number of LEDs that are 
	 * currently on, return all possible times the watch could represent.
	 * 
	 * Example:
	 * Input: n = 1
	 * Return: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
	 * Note:
	 * The order of output does not matter.
	 * The hour must not contain a leading zero, for example "01:00" is not valid, it should be "1:00".
	 * The minute must be consist of two digits and may contain a leading zero, for example "10:2" is not valid, it should be "10:02".
	 **/
	public static void main(String[] args) {
		System.out.println(readBinaryWatchDFS(0));
		System.out.println(readBinaryWatchBruteForce(0));

		System.out.println(readBinaryWatchDFS(1));
		System.out.println(readBinaryWatchBruteForce(1));

		System.out.println(readBinaryWatchDFS(2));
		System.out.println(readBinaryWatchBruteForce(2));
	}

	// Answer by cuberyao, extremely fast but is specific to the question, yet it is what real world demands.
	public static List<String> readBinaryWatch(int num) {
		String[][] hours = {{"0"}, 
				{"1", "2", "4", "8"},
				{"3", "5", "6", "9", "10"},
				{"7", "11"}};
		String[][] minutes = {{"00"},
				{"01", "02", "04", "08", "16", "32"},
				{"03", "05", "06", "09", "10", "12", "17", "18", "20", "24", "33", "34", "36", "40", "48"},
				{"07", "11", "13", "14", "19", "21", "22", "25", "26", "28", "35", "37", "38", "41", "42", "44", "49", "50", "52", "56"},
				{"15", "23", "27", "29", "30", "39", "43", "45", "46", "51", "53", "54", "57", "58"},
				{"31", "47", "55", "59"}};
		
		List<String> ans = new ArrayList<String>();
		for ( int i = 0; i < 4 && i <= num; ++i ) {
			if ( num - i <= 5 ) {
				for ( String hour : hours[i] ) {
					for ( String minute : minutes[num-i] ) {
						ans.add(hour+':'+minute);
					}
				}
			}
		}
		
		return ans;
	}

	// Brute Force
	public static List<String> readBinaryWatchBruteForce(int num) {
		List<String> ans = new ArrayList<String>();
		for ( int hour = 0; hour < 12; ++hour ) {
			for ( int minute = 0; minute < 60; ++minute ) {
				if ( Integer.bitCount((hour<<6)+minute) == num )
					ans.add(String.format("%d:%02d", hour, minute));
			}
		}
		return ans;
	}

	// DFS, slowest but general
	public static List<String> readBinaryWatchDFS(int num) {
		List<String> ans = new ArrayList<String>();
		DFS(ans, num, 0, 0, 0);
		return ans;
	}

	public static void DFS(List<String> ans, int num, int i, int n, int b){
		if ( num == n ) {
			int hour = b >> 6;
				int minute = b & 63;
				if ( hour < 12 && minute < 60 )
					ans.add(String.format("%d:%02d", hour, minute));
				return;
		} 
		else if ( i == 10 || n > 8 ) return; // because hour can have at most 3 on-bits and minutes 5.
		else {
			DFS(ans, num, i+1, n , b);
			DFS(ans, num, i+1, n+1 , b | (1 << i));
		}
	}
}
