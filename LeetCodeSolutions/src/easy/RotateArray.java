package easy;

public class RotateArray {

	/**
	 * Rotate an array of n elements to the right by k steps.
	 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
	 */
	public static void main(String[] args) {
		int[] nums = new int[]{1,2,3,4,5,6,7};
		int k = 3;
		for( int i = 0; i < nums.length; ++i )
			System.out.print(nums[i]+" ");
		System.out.println();
		rotateSwapBack(nums, k);
		for( int i = 0; i < nums.length; ++i )
			System.out.print(nums[i]+" ");
	}

	/*
	 * 1) Create a new array, copy elements in order.
	 * 2) Swap elements: Reverse the whole array. Reverse 0 - k elements. Reverse k - size elements.
	 * 3) Swap elements: Swap k elements from back to front in one iteration, 
	 * 			the group required to swap next is then always at the back.
	 */
	public static void rotate(int[] nums, int k){
		k %= nums.length;
		int[] newNums = new int[nums.length];
		int shift = nums.length - k;
		for(int i = 0; i < k; ++i)
			newNums[i] = nums[shift + i];
		for(int i = 0; i < shift; ++i)
			newNums[i+k] = nums[i];
		for( int i = 0; i < nums.length; ++i )
			nums[i] = newNums[i];
	}
	
	public static void rotateSwap(int[] nums, int k){
		k %= nums.length;
		int half = nums.length/2, temp;
		int offset = nums.length%2 == 0?1:0;
		for(int i = 0; i < half; ++i){
			temp = nums[i];
			nums[i] = nums[i+2*(half-i)-offset];
			nums[i+2*(half-i)-offset] = temp;
		}
		half = k/2;
		offset = k%2 == 0?1:0;
		for(int i = 0; i < half; ++i){
			temp = nums[i];
			nums[i] = nums[i+2*(half-i)-offset];
			nums[i+2*(half-i)-offset] = temp;
		}
		half = (nums.length-k)/2+k;
		offset = (nums.length-k)%2 == 0?1:0;
		for(int i = k; i < half; ++i){
			temp = nums[i];
			nums[i] = nums[i+2*(half-i)-offset];
			nums[i+2*(half-i)-offset] = temp;
		}
	}
	
	public static void rotateSwapBack(int[] nums, int k){
		for( int i = 0, n = nums.length; (k%=n)!= 0; n-= k){
			for( int j = 0; j < k; ++j ){
				int temp = nums[i];
				nums[i] = nums[i+n-k];
				nums[i+n-k] = temp;
				++i;
			}
		}
	}
}
