class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites.length == 0) return true;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int[] inDeg = new int[numCourses];

        for (int[] pre : prerequisites) {
            inDeg[pre[0]]++;
            if (!map.containsKey(pre[1])) {
                map.put(pre[1], new ArrayList<>());
            }
            map.get(pre[1]).add(pre[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        int count = 0;

        for (int i = 0; i < numCourses; i++) {
            if (inDeg[i] == 0) {
                queue.add(i);
                count++;
            }

        }
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