import java.util.*;
public class DirectedGraphCycleDetection{
    private static boolean hasCycle(ArrayList<ArrayList<Integer>> adjList){
        boolean[] vis=new boolean[adjList.size()];
        boolean[] recStack=new boolean[adjList.size()];
        for(int i=0;i<adjList.size();i++){
            if(!vis[i]){
                if(isCyclic(adjList,vis,recStack,i)){
                    return true;
                }
            }
        }
        return false;

    }
    private static boolean isCyclic(ArrayList<ArrayList<Integer>> adjList,boolean[] vis,boolean[] recStack,int node){

        vis[node]=true;
        recStack[node]=true;
        for(int i:adjList.get(node)){
            if(!vis[i]){
                if(isCyclic(adjList, vis, recStack, i)){
                    return true;
                }

            }
            else if(recStack[i]){
                return true;
            }
        }
        recStack[node]=false;
        return false;

    }
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adjList=new ArrayList<>();
        adjList.add(new ArrayList<>(List.of(1,2)));
        adjList.add(new ArrayList<>(List.of(2)));
        adjList.add(new ArrayList<>(List.of(0,3)));
        adjList.add(new ArrayList<>());

        if(hasCycle(adjList)){
            System.out.println("Graph contains the cycle");
        }
        else{
            System.err.println("Graph does not contain cycle");
        }


        
    }
}