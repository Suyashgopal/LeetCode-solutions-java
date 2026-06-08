/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> list, int id) {
        Queue<Integer> q= new LinkedList<>();
        HashMap<Integer, Employee> map= new HashMap<>();  
        for(int i=0;i<list.size();i++){
            Employee temp= list.get(i);
            map.put(temp.id, temp);
            
        }


        q.add(id);
        int imp=0;
        while(!q.isEmpty()){
            int curr= q.poll();
            Employee t1= map.get(curr);
            imp= imp + t1.importance;
            for(int a: t1.subordinates){
                q.add(a);
            }

        } 
 return imp;
     
          
    }
 
}