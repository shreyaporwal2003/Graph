import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class BiPartite{
    public static boolean isBipartite(List<List<Integer>> graph) {
        int n = graph.size();
        boolean[] visited = new boolean[n]; // Track visited nodes
        Queue<Integer> queue = new LinkedList<>();

        for (int start = 0; start < n; start++) { 
            if (!visited[start]) { 
                Set<Integer> setA = new HashSet<>(); 
                Set<Integer> setB = new HashSet<>();
                
                queue.offer(start);
                setA.add(start);
                
                while (!queue.isEmpty()) {
                    int node = queue.poll();
                    visited[node] = true;

                    for (int neighbor : graph.get(node)) {
                        if (setA.contains(node)) {
                            if (setA.contains(neighbor)) return false;
                            setB.add(neighbor);
                        } else {
                            if (setB.contains(neighbor)) return false;
                            setA.add(neighbor);
                        }
                        if (!visited[neighbor]) queue.offer(neighbor);
                    }
                }
            }
        }
        return true; 
    }
    public static void main(String[] args) {
         List<List<Integer>> graph = new ArrayList<>();
        
        // Example Graph:
        //  0 -- 1
        //  |    |
        //  3 -- 2
        graph.add(Arrays.asList(1, 3)); // Node 0
        graph.add(Arrays.asList(0, 2)); // Node 1
        graph.add(Arrays.asList(1, 3)); // Node 2
        graph.add(Arrays.asList(0, 2)); // Node 3

        System.out.println("Is the graph bipartite? " + isBipartite(graph)); // Output: true
    }
}