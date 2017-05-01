package easy;

public class StudentAttendanceRecord {
	/**
	 * You are given a string representing an attendance record for a student. The record only contains the following three characters:
	 * 
	 * 'A' : Absent.
	 * 'L' : Late.
	 * 'P' : Present.
	 * 
	 * A student could be rewarded if his attendance record doesn't contain more than one 'A' (absent) or more than two continuous 'L' (late).
	 * 
	 * You need to return whether the student could be rewarded according to his attendance record.
	 **/
	public static void main(String[] args) {
		System.out.println(checkRecord("PPALLP"));
		System.out.println(checkRecord("PPALLL"));
	}

	// Trivial coding from requirement
	public static boolean checkRecord(String s) {
		char[] records = s.toCharArray();

		boolean A = false;
		int L = 0;

		for ( char r : records ) {
			if ( r == 'A' ) {
				if ( A ) return false;
				else {
					A = true;
					L = 0;
				}
			} else if ( r == 'L') {
				if ( L == 2 ) return false;
				else L++;
			} else {
				L = 0;
			}
		}

		return true;
	}

	// slightly more overhead than above, but not much difference.
	public static boolean checkRecordStringOp(String s) {
		return !(s.contains("LLL") || s.indexOf('A') != s.lastIndexOf('A'));
	}

	// regular expression is the slowest.
	public static boolean checkRecordRegex(String s) {
		return !(s.matches(".*LLL.*") || s.matches(".*A.*A.*"));
	}
}
