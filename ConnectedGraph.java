import java.util.*;
public class ConnectedGraph{
    private static boolean isConnected(List<List<Integer>> adj){
        if(adj.size()==0){
            return false;
        }
        boolean[] visited=new boolean[adj.size()];
        dfs(adj,0,visited);
        for(boolean v:visited){
            if(!v){
                return false;
            }
        }
        return true;
    }
    private static void dfs(List<List<Integer>> adj,int node,boolean[] visited ){
        visited[node]=true;
        for(int neighbor:adj.get(node)){
            if(!visited[neighbor]){
                dfs(adj,neighbor,visited);
            }


        }
    }
    public static void main(String[] args) {
      
        
        List<List<Integer>> adj=new ArrayList<>();
        int n=4;
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        //sample graph: 0->1->2->3
        adj.get(0).add(1);
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);

        System.out.println("Is this graph is connexted: "+ isConnected(adj));
       

        


        

        
    }
}