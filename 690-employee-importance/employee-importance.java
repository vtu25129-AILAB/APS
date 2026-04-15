import java.util.*;

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee e : employees) {
            map.put(e.id, e);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(id);
        int total = 0;
        
        while (!queue.isEmpty()) {
            int currId = queue.poll();
            Employee emp = map.get(currId);
            
            total += emp.importance;
            
            for (int subId : emp.subordinates) {
                queue.offer(subId);
            }
        }
        
        return total;
    }
}