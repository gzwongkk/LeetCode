package easy;

public class RectangleArea {
	
	/**
	 * Find the total area covered by two rectilinear rectangles in a 2D plane.
	 * Each rectangle is defined by its bottom left corner and top right corner
	 * as shown in the figure. Assume that the total area is never beyond the
	 * maximum possible value of int.
	 **/
	public static void main(String[] args) {
		System.out.println(computeArea(-3,0,3,4,0,-1,9,2));
	}
	
	/*
	 * In probability, (A U B) = A + B - (A n B). Checking overlap is rather a 
	 * venn diagram challenge.
	 */
	public static int computeArea(int A, int B, int C, int D, int E, int F, int G, int H){
		int overlapW = (Math.min(C, G) > Math.max(A, E))?Math.min(C, G) - Math.max(A, E):0;
		int overlapH = (Math.min(D, H) > Math.max(B, F))?Math.min(D, H) - Math.max(B, F):0;
		return (C-A)*(D-B) + (G-E)*(H-F) - overlapW*overlapH;
	}
}
