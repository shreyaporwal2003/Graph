import java.util.*;
public class TopologicalSort {
    private  static void dfs(List<List<Integer>> adjList,boolean[] vis,int V,Stack<Integer> stack ){
        vis[V]=true;
        for(int i: adjList.get(V)){
            if(!vis[i]){
                dfs(adjList,vis,i,stack);
            }
        }
        stack.push(V);

        
    }
    private  static ArrayList<Integer> topologicalSort(List<List<Integer>> adjList){
        boolean[] vis=new boolean[adjList.size()];
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<adjList.size();i++){
            if(!vis[i]) dfs(adjList,vis,i,stack);

        }
        ArrayList<Integer> res=new ArrayList<>();
        while(!stack.isEmpty()){
            res.add(stack.pop());

        }
        return res;


    }
    public static void main(String[] args) {
        List<List<Integer>> adjList=new ArrayList<>();
        adjList.add(new ArrayList<>());
        adjList.add(new ArrayList<>());
        adjList.add(new ArrayList<>(List.of(3)));
        adjList.add(new ArrayList<>(List.of(1)));
        adjList.add(new ArrayList<>(List.of(0,1)));
        adjList.add(new ArrayList<>(List.of(0,2)));

        System.out.println("Topological Sort: "+ topologicalSort(adjList));
       

        


    }
    
}