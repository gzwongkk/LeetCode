package easy;

public class RemoveElement {

	/**
	 * Given an array and a value, remove all instances of that value in place and 
	 * return the new length. The order of elements can be changed. It doesn't matter
	 * what you leave beyond the new length.
	 */
	public static void main(String[] args) {

	}

	/*
	 * Just a simple modification from the partition algorithm is quick sort. (Hoare's algorithm)
	 * Note that deleting the value does not require swapping, overwriting is good enough.
	 */
	public static int removeElement(int[] nums, int val){
		int newSize = 0, partition = nums.length;
		while( newSize < nums.length && newSize < partition ){
			if( nums[newSize] == val ){
				nums[newSize] = nums[--partition];
				continue; 
				//not changing the newSize here is important because there is no guarantee that
				//the last element must not be the required value.
			}
			newSize++;
		}
		return newSize;
	}
	
	//Similar runtime
	public static int removeElementAssignment(int[] nums, int val){
		int newSize = 0;
		for( int i = 0; i < nums.length; ++i )
			if( nums[i] != val )
				nums[newSize++] = nums[i];
		return newSize;
	}
}
