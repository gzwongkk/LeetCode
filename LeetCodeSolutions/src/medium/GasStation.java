package medium;

public class Anagrams {

	/**
	 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
	 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to
	 * its next station (i+1). You begin the journey with an empty tank at one of the gas stations.
	 * Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
	 * Note: The solution is guaranteed to be unique.
	 * 
	 **/
	public static void main(String[] args) {
	}

	/*
	 * At first I thought of DP since it is very similar to all pairs shortest path. But actually it will
	 * have done a huge amount of extra work by computing the net gain of gas everytime in dp. So a circular
	 * specific window solution is implemented here, and it is O(n) time O(1) space, super fast.
	 */
	public static int canCompleteCircuit(int[] gas, int[] cost){
        int start = gas.length-1, end = 0, gasTank = gas[start] - cost[start];
        while( start > end ){
            if( gasTank >= 0 ){t
                gasTank += gas[end] - cost[end];
                ++end;
            } else {
                --start;
                gasTank += gas[start] - cost[start];
            }
        }
        return gasTank >= 0? start: -1;
	}
}
