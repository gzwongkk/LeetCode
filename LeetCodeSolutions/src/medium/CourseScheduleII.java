package medium;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class CourseScheduleII {

	/**
	 * There are a total of n courses you have to take, labeled from 0 to n-1. Some courses may
	 * have prerequisites, for example to take course 0 you have to first take course 1, which is
	 * expressed as a pair: [0, 1]. 
	 * Given the total number of courses and a list of prerequisites pairs, return the ordering of
	 * courses you should take to finish all courses. There may be multiple correct orders, you just
	 * need to return one of them. If it is impossible to finish all courses, return an empty array.
	 * For example:
	 * 2, [[1,0]]	There are a total of 2 courses to take. To take course 1 you should have finished
	 * course 0. So the correct course order is [0,1].
	 * 4, [[1,0],[2,0],[3,1],[3,2]]	There are a total of 4 courses to take. To take course 3 you should
	 * have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished 
	 * course 0. So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].
	 **/
	public static void main(String[] args) {
		int[][] prerequisites = new int[][]{{1,0},{2,0},{3,1},{3,2}};
		for( int pre : findOrder(4, prerequisites) )
			System.out.print(pre + " ");
	}

	/*
	 * After the training of Course Schedule One, this is much easier since it only requires to return the
	 * topological order. A few new things has been tried here just to increase my technique pool:
	 * i.  ArrayDeque has initial capacity 16. This might not be as good as LinkedList for queue, but it's fun.
	 * ii. use index == numCourses instead of deleting from prereq, not only that deleting requires some runtime,
	 * 			but also index is required for building the return array.
	 */
	public static int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, Set<Integer>> prereq = new HashMap<Integer, Set<Integer>>();
		int[] in_degree = new int[numCourses];
		for( int[] pre : prerequisites ){
			if( prereq.get(pre[0]) == null ) prereq.put(pre[0], new HashSet<Integer>());
			if( prereq.get(pre[0]).add(pre[1]) ) ++in_degree[pre[1]];
		}
		Queue<Integer> queue = new ArrayDeque<Integer>();
		int[] topological = new int[numCourses];
		for( int i = 0; i < numCourses; ++i ) if( in_degree[i] == 0 ) queue.offer(i);
		int index = 0;
		while( !queue.isEmpty() ){
			if( prereq.get(queue.peek()) != null )
				for( int pre : prereq.get(queue.peek()) ) 
					if( --in_degree[pre] == 0 ) queue.offer(pre);
			topological[numCourses - (index++) - 1] = queue.poll();
		}
		return index == numCourses? topological: new int[0];
    }
}
