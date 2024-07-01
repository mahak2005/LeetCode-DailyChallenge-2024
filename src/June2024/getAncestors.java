package June2024;
import java.util.*;
public class getAncestors {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {

        List<List<Integer>> adjList=new ArrayList<>();
        List<List<Integer>> res=new ArrayList<>();

        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
            res.add(new ArrayList<>());
        }
        for(int[] edge: edges){
            int from=edge[0];
            int to=edge[1];
            adjList.get(from).add(to);
        }

        for(int node=0;node<n;node++){
            int[] visited=new int[n];
            visited[node]=-1;
            dfs(node,visited,res,node, adjList);
        }
        return res;
    }

    private void dfs(int currentNode, int[] visited, List<List<Integer>> res,
                     int source,  List<List<Integer>> adjList ){

        for(int neighbour: adjList.get(currentNode)){
            if(visited[neighbour]!=-1){
                visited[neighbour]=-1;
                res.get(neighbour).add(source);
                dfs(neighbour,visited,res,source,adjList);
            }
        }

    }

}
