/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {

        Queue<Integer> q = new LinkedList<>();
        HashMap<Integer, Employee> map = new HashMap<>();

        for(Employee e: employees)
        {
            map.put(e.id, e);
        }
        int total =0;
        q.add(id);
        while(!q.isEmpty())
        {
            int eid = q.poll();
            Employee e = map.get(eid);
            total+=e.importance;
            for(int subordinate: e.subordinates)
                {
                    q.add(subordinate);
                }               
        }
        return total;
    }
}