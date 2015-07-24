package medium;

public class ContainerWithMostWater {

	/**
	 * Given n non-negative integers, a1, a2, ..., an, where each represents a point 
	 * at coordinate(i, ai). n vertical lines are drawn such that the two end points 
	 * of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis 
	 * forms a container, such that the container contains the most water.
	 * Note: You may not slant the container.
	 **/
	public static void main(String[] args) {
		int[] height = new int[]{5,2,6,3,5,8,4,6,2};
		// 5 at first and 6 at second last
		System.out.println(maxArea(height));
	}

	/*
	 * A window problem, quite similar to binary search in implementation.
	 * This is greedy in nature which selects the largest area from the widest.
	 */
	public static int maxArea(int[] height){
		int max = 0, low = 0, high = height.length-1;
		while( low < high ){
			max = Math.max(max, (high - low) * Math.min(height[low], height[high]));
			if( height[low] < height[high] ) ++low;
			else --high;
		}
		return max;
	}
}
