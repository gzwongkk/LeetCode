package medium;
import java.util.*;

public class Combinations {
	/**
	 * Given two integers n and k, return all possible combinations of k numbers out of 1...n.
	 * For example, if n = 4 and k = 2, a solution is:
	 * [
	 * 	[2,4],
	 * 	[3,4],
	 * 	[2,3],
	 * 	[1,2],
	 * 	[1,3],
	 * 	[1,4]
	 * ]
	 **/
	public static void main(String[] args) {
		System.out.println(combine(4, 2));
		combine(4,2).forEach(e -> System.out.println(e+"; "));
		combine(4,2).forEach(System.out::println);
	}

	/*
	 * nCr = (n-1)C(r-1) + (n-1)C r, thus it can be expressed as C(n, r) = C(n-1, r-1) + C(n-1, r)
	 * A new interface Consumer is used here. This uses a lambda expression or method reference for assignment.
	 */
	public static List<List<Integer> > combine(int n, int k){
		List<List<Integer> > ans;
		if( n == k || k == 0 ){
			ans = new ArrayList<>();
			ArrayList<Integer> base = new ArrayList<>();
			for( int i = 1; i <= k; ++i )
				base.add(i);
			ans.add(base);
		} else {
			ans = combine(n-1, k-1);
			ans.forEach(e -> e.add(n));
			ans.addAll(combine(n-1, k));
		}
		return ans;
	}
}
