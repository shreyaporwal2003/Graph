package Graph;
import java.util.*;
public class AdjacencyList{
   static  ArrayList<ArrayList<Integer>> AL=new ArrayList<>();
    public static void adjacencyList(int u,int v){
        //undirected graph
        AL.get(u).add(v);
        // AL.get(v).add(u);


    }
    public static void main(String[] args) {
        
        int noOfVertex=4;
        for(int i=0;i<noOfVertex;i++){
            AL.add(new ArrayList<>());
        }
    
        adjacencyList(0,1);
        adjacencyList(1,0);
        adjacencyList(1,2);
        adjacencyList(1,3);
        
        adjacencyList(2,1);
        adjacencyList(2,3);
        adjacencyList(3,1);
        adjacencyList(3,2);
        System.out.println(AL);



    }

}