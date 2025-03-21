import java.util.*;
public class TopologicalSort_BFS {
    private static  ArrayList<Integer> topologicalSort(List<List<Integer>> adjList){
        Queue<Integer> q=new LinkedList<>();
        int[] indegree=new int[adjList.size()];
        
        for (int i = 0; i < adjList.size(); i++) {
            for (int neighbor : adjList.get(i)) {
                indegree[neighbor]++;  // Increment indegree of the dependent node
            }
        }
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }
        ArrayList<Integer> res=new ArrayList<>();
        while(!q.isEmpty()){
            int node=q.poll();
            res.add(node);
            for(int i:adjList.get(node)){
                indegree[i]--;
                if(indegree[i]==0){
                    q.offer(i);
                }
            }

        }
        return res;

    }
    public static void main(String[] args) {
        List<List<Integer>> adjList=new ArrayList<>();
        adjList.add(new ArrayList<>(List.of(1)));
        adjList.add(new ArrayList<>(List.of(2)));
        adjList.add(new ArrayList<>(List.of(3)));
        adjList.add(new ArrayList<>());
        adjList.add(new ArrayList<>(List.of(5)));
        adjList.add(new ArrayList<>(List.of(1,2)));

        System.out.println("Topological Sort:"+ topologicalSort(adjList));

    }
    
}
