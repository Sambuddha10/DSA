import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // graph.get(course) contains all courses unlocked after completing course
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // indegree[course] = number of prerequisites still required
        int[] indegree = new int[numCourses];

        // Build graph: prerequisite -> course
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int requiredCourse = prerequisite[1];

            graph.get(requiredCourse).add(course);
            indegree[course]++;
        }

        // Courses with no prerequisites can be taken first
        Deque<Integer> queue = new ArrayDeque<>();

        for (int course = 0; course < numCourses; course++) {
            if (indegree[course] == 0) {
                queue.offer(course);
            }
        }

        int completedCourses = 0;

        while (!queue.isEmpty()) {
            int currentCourse = queue.poll();
            completedCourses++;

            // Completing currentCourse may unlock other courses
            for (int nextCourse : graph.get(currentCourse)) {
                indegree[nextCourse]--;

                if (indegree[nextCourse] == 0) {
                    queue.offer(nextCourse);
                }
            }
        }

        // If every course was processed, there is no cycle
        return completedCourses == numCourses;
    }
}