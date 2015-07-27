package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;

public class CourseSchedule {

	/**
	 * There are a total of n courses you have to take, labeled from 0 to n - 1. Some courses
	 * may have prerequisites, for example to take course 0 you have to first take course 1, 
	 * which is expressed as a pair: [0, 1]. 
	 * Given the total number of courses and a list of prerequisite pairs, is it possible for you 
	 * to finish all courses?
	 * For example: 2, [[1,0]] There are a total of 2 courses to take. To take course 1 you should
	 * have finished course 0. So it is possible.
	 * 2, [[1,0],[0,1]] There are a total of 2 courses to take. To take course 1 you should have
	 * finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
	 **/
	public static void main(String[] args) {
		int numCourses = 10;
		int[][] prerequisites = new int[][]{{5,8},{3,5},{1,9},{4,5},{0,2},{1,9},{7,8},{4,9}};
		System.out.println(canFinish(numCourses, prerequisites));
		System.out.println(canFinishDFS(numCourses, prerequisites));
	}

	/*
	 * This is a very good exercise to review graph problems.
	 * Topological sort in BFS is easy to implement, and it is really fast.
	 * 1) This version uses a HashMap and HashSet to maintain the adjacency list. Its advantage
	 * 			is redundant information is neglected, and allow a variety of course code data
	 * 			type. The most elegant solution amongst all.
	 * 2) This version uses list of lists to represent graphs. Remember that Generic containers
	 * 			are forbidden to form an array. And for lists, even if you have declared its
	 * 			capacity, you must initialize it yourself, unlike C++'s vector.
	 * 3) This version does not use a queue to perform topological sort. It sacrifices runtime
	 * 			for spaces. The performance is affected around 25%.
	 * 4) This version uses the DFS approach. I tried for a long time to do it iteratively instead
	 * 			of recursion. I was stuck at unpredictable errors; However I finally realized that
	 * 			not only the node itself has to be put in the stack, one of the most important step
	 * 			in topological sort, which is setting mark back to false, has to be put in stack 
	 * 			also. It might not be worthy or save that much time to implement, given the 
	 * 			convenience	of function stack.
	 */
	public static boolean canFinish(int numCourses, int[][] prerequisites){
		HashMap<Integer, Set<Integer>> prereq = new HashMap<Integer, Set<Integer>>();
		int[] in_degree = new int[numCourses];
		for( int i = 0; i < prerequisites.length; ++i ){
			if( !prereq.containsKey(prerequisites[i][0]) )
				prereq.put(prerequisites[i][0], new HashSet<Integer>());
			if( prereq.get(prerequisites[i][0]).add(prerequisites[i][1]) )
				++in_degree[prerequisites[i][1]];
		}

		Queue<Integer> queue = new LinkedList<Integer>();
		for( int i = 0; i < numCourses; ++i ) if( in_degree[i] == 0 ) queue.add(i);
		while( !queue.isEmpty() ){
			if( prereq.get(queue.peek()) != null )
				for( int pre : prereq.get(queue.peek()) )
					if( --in_degree[pre] == 0 ) queue.add(pre);
			prereq.remove(queue.poll());
		}
		return prereq.isEmpty();
	}

	public static boolean canFinishAdjacencyList(int numCourses, int[][] prerequisites){
		List<List<Integer>> prereq = new ArrayList<List<Integer>>(numCourses);
		for( int i = 0; i < numCourses; ++i ) prereq.add(new LinkedList<Integer>());
		int[] in_degree = new int[numCourses];
		for( int[] prerequisite: prerequisites ){
			prereq.get(prerequisite[0]).add(prerequisite[1]);
			++in_degree[prerequisite[1]];
		}

		Queue<Integer> queue = new LinkedList<Integer>();
		for( int i = 0; i < numCourses; ++i ) if( in_degree[i] == 0 ) queue.add(i);
		while( !queue.isEmpty() ){
			for( int pre : prereq.get(queue.peek()) )
				if( --in_degree[pre] == 0 ) queue.add(pre);
			prereq.set(queue.poll(), null);
		}
		for( List<Integer> pre: prereq ) if( pre != null ) return false;
		return true;
	}

	public boolean canFinishTopologicalWithoutQueue(int numCourses, int[][] prerequisites) {
		HashMap<Integer, ArrayList<Integer>> prereq = new HashMap<Integer, ArrayList<Integer>>();
		int[] in_degree = new int[numCourses];
		for( int i = 0; i < prerequisites.length; ++i ){
			if( !prereq.containsKey(prerequisites[i][0]) )
				prereq.put(prerequisites[i][0], new ArrayList<Integer>());
			prereq.get(prerequisites[i][0]).add(prerequisites[i][1]);
			++in_degree[prerequisites[i][1]];
		}

		while( !prereq.isEmpty() ){
			boolean shouldStop = true;
			for(Entry<Integer, ArrayList<Integer>> course : prereq.entrySet()){
				if( in_degree[course.getKey()] == 0 ){
					for( int pre : course.getValue() ) --in_degree[pre];
					prereq.remove(course.getKey());
					shouldStop = false;
					break;
				}
			}
			if( shouldStop ) return false;
		}
		return true;
	}

	public static boolean canFinishDFS(int numCourses, int[][] prerequisites){
		HashMap<Integer, Set<Integer>> prereq = new HashMap<Integer, Set<Integer>>();
		for( int i = 0; i < prerequisites.length; ++i ){
			if( !prereq.containsKey(prerequisites[i][0]) )
				prereq.put(prerequisites[i][0], new HashSet<Integer>());
			prereq.get(prerequisites[i][0]).add(prerequisites[i][1]);
		}

		boolean[] mark = new boolean[numCourses], visited = new boolean[numCourses];
		for( int i = 0; i < numCourses; ++i )
			if( !visited[i] && !topologicalDFS(prereq, visited, mark, i) ) return false;
		return true;
	}

	public static boolean topologicalDFS(HashMap<Integer, Set<Integer>> prereq, 
			boolean[] visited, boolean[] mark, int i){
		if( mark[i] ) return false;
		if( visited[i] ) return true;
		mark[i] = true;
		if( prereq.get(i) != null)
			for( int pre : prereq.get(i) )
				if( !topologicalDFS(prereq, visited, mark, pre) ) return false;
		mark[i] = false;
		visited[i] = true;
		return true;
	}
}
