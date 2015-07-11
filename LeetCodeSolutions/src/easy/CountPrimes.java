package easy;

import java.util.BitSet;

public class CountPrimes {

	/**
	 * Count the number of prime numbers less than a non-negative number, n.
	 */
	public static void main(String[] args) {
		int n = 100;
		System.out.println(countPrimes(n));
	}

	/*
	 * Sieve of Eratosthenes is an ancient algorithm that solve this problem.
	 * BitSet can be a useful substitution of boolean array, faster for around 1/5 time.
	 */
	public static int countPrimes(int n){
		if( n < 2 ) return 0;
		BitSet primeTable = new BitSet();
		primeTable.set(0, 2);
		int size = (int) Math.sqrt(n);
		for( int i = 2; i <= size; ++i )
			if( !primeTable.get(i) )
				for( int j = i+i; j < n; j+=i )
					primeTable.set(j);
		return n - primeTable.cardinality();
	}

	public static int countPrimesArray(int n){
		boolean[] primeTable = new boolean[n];
		int prime = 0;
		for( int i = 2; i < n; ++i ){
			if( !primeTable[i] ){
				for( int j = i; j < n; j+=i )
					primeTable[j] = true;
				prime++;
			}
		}
		return prime;
	}
}
