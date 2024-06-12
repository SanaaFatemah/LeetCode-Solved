class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites.length == 0) return true;
        //Creating a hash map that will serve as an adjacency list
        //this map shows which node is dependent on which node.
        //independent : <List of dependent nodes>
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        //This array is created to show that which node has how many dependencies, the count of it
        int[] inDeg = new int[numCourses];

        //creating the adjacency list
        for (int[] pre : prerequisites) {
            inDeg[pre[0]]++;
            if (!map.containsKey(pre[1])) {
                map.put(pre[1], new ArrayList<>());
            }
            map.get(pre[1]).add(pre[0]);
        }

        //This queue is used to process all the independent nodes first,
        // it will start the node that has an indegree count of 0
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;

        for (int i = 0; i < numCourses; i++) {
            if (inDeg[i] == 0) {
                queue.add(i);
                count++;
            }

        }
        //using the value in the queue to search the adjacency list and looking for all the nodes dependent on it.
        //this is bascially a way of completeting the independent course which is a pre requisite for the other courses
        //once we start with the independent node we look for that key in map and get a list of the courses that are dependednt on it
        //we reduce their indegree value as now they are completed for that course in the queue
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            List<Integer> children = map.get(curr);
            if (children != null) {
                for (int child : children) {
                    inDeg[child]--;
                    if (inDeg[child] == 0) {
                        queue.add(child);
                        count++;
                        if(count == numCourses) return true;
                    }

                }
            }


        }
        return false;

    }
}