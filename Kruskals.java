package Graph;
import java.util.*;

public class Kruskals {
    static int V=4;
    static int[] parent=new int[V];
    static int find(int x){
        if(parent[x]==x)
            return x;
        return find(parent[x]);

    }


    static void union(int x,int y){
        int a=find(x);
        int b=find(y);
        parent[b]=a;

    }

    static int spanningTree(int V,ArrayList<int[]> edges){
        //sort the edges
        Collections.sort(edges,Comparator.comparingInt(a->a[2]));
         
        int cost=0;
        //parent of vertex is itself
        for(int i=0;i<V;i++){
            parent[i]=i;
        }
        for(int[] i:edges){
            int u=i[0];
            int v=i[1];
            int w=i[2];
            //check for cycle - u and v cannot have same parent
            if(find(u)!=find(v)){
                cost+=w;
                union(u,v);
            }
        }
        return cost;

        
        


    }
    public static void main(String[] args) {
        int V=4;
        ArrayList<int[]> edges=new ArrayList<>();
        edges.add(new int[]{0,1,2});
        edges.add(new int[]{0,2,3});
        edges.add(new int[]{1,2,1});
        edges.add(new int[]{1,3,4});
        edges.add(new int[]{2,3,5});
        
        int result=spanningTree(V,edges);
        System.out.println("Sum of weights in Minimum Spanning Tree:"+ result);
        
    }
    
}
