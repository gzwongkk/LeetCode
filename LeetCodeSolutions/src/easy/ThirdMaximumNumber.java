package easy;

import java.util.TreeSet;

public class ThirdMaximumNumber {
	/**
	 * Given a non-empty array of integers, return the third maximum number in this array. 
	 * If it does not exist, return the maximum number. The time complexity must be in O(n).
	 **/
	public static void main(String[] args) {
		System.out.println(thirdMax(new int[]{2,2,3,1}));
		System.out.println(thirdMax(new int[]{2,2,3,1,4,10}));
		System.out.println(thirdMax(new int[]{-2147483648,1,1}));
	}

	/*
	 * 1.	Trivial and Long initialization ~4ms
	 * 2.	Integer type ~10ms
	 * 3.	TreeSet ~20ms
	 */
	public static int thirdMax(int[] nums) {
		return thirdMaxInteger(nums);
	}
	
	// Use Long to escape boundary cases, but it's ugly.
	public static int thirdMaxTrivial(int[] nums) {
		if ( nums.length == 1 ) return nums[0];
		else if ( nums.length == 2) return Math.max(nums[0], nums[1]);
		long a = nums[0], b = Long.MIN_VALUE, c = Long.MIN_VALUE;
		for ( int i = 1; i < nums.length; ++i ) {
			if ( nums[i] > c && nums[i] != b && nums[i] != a ) {
				c = nums[i];
				if ( c > b ) {
					long t = c;
					c = b;
					b = t;
					if ( b > a ) {
						t = a;
						a = b;
						b = t;
					}
				}
			}
			
		}
		return (int) (c == Long.MIN_VALUE? a: c);
	}
	
	// answer by yuxiaofei2016. Integer type can prevent Integer.MIN_VALUE initialization.
	public static int thirdMaxInteger(int[] nums) {
		Integer max1 = null, max2 = null, max3 = null;
		for ( Integer n : nums ) {
			if (n.equals(max1) || n.equals(max2) || n.equals(max3)) continue;
			if ( max1 == null || n > max1 ) {
				max3 = max2;
				max2 = max1;
				max1 = n;
			} else if ( max2 == null || n > max2 ) {
				max3 = max2;
				max2 = n;
			} else if ( max3 == null || n > max3 ) {
				max3 = n;
			}
		}
		return (max3 == null)? max1: max3;
	}
	
	// An ordered data structure which is more general to handle everything. Neat and clean.
	public static int thirdMaxTreeSet(int[] nums) {
		TreeSet<Integer> set = new TreeSet<>();
		for ( int num : nums ) {
			if ( set.add(num) && set.size() > 3 ) set.pollFirst();
		}
		return set.size() < 3? set.pollLast(): set.pollFirst();
	}
}
