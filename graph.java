import java.util.LinkedList;
import java.util.Stack;

class Graph
{
    private int V;
    private int E;
    LinkedList<Integer>[] adj;

    Graph(int V)
    {
        this.V = V;
        adj = (LinkedList<Integer> [])new LinkedList[V];

        for(int i = 0; i < V; i++)
            adj[i] = new LinkedList<Integer>();
    }

    public void addEdge(int v, int w)
    {
        E++;
        adj[v].add(w);
        adj[w].add(v);
    }

    public LinkedList<Integer> adj(int i)
    {
        return this.adj[i];
    }

    public int V()
    {
        return this.V;
    }

    public int E()
    {
        return this.E;
    }

    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("Number of Vertices: " + V + "Number of Edges: E" + E+ "\n");

         for(int i = 0; i < V; i++)
         {
             sb.append("Adj List " + i + " : ");

             for(Integer x : adj[i])
                 sb.append(x + " ");
             sb.append("\n");
         }
         return sb.toString();
    }

}

class DFS
{
    private int s;
    private Graph g;
    private boolean marked[];
    private int edgeTo[];

    public DFS(Graph g, int s)
    {
        this.s = s;
        this.g = g;
        marked = new boolean[g.V()];
        edgeTo = new int[g.V()];

        dfs(s);
    }

    private void dfs(int v)
    {
        marked[v] = true;

        for(int w : g.adj(v))
        {
            if(!marked[w])
            {
                edgeTo[w] = v;
                dfs(w);
            }
        }
    }

    public boolean hasPathTo(int v)
    {
        return marked[v];
    }

    public Stack<Integer> pathTo(int v) { 
         if(!hasPathTo(v)) return null; 
         Stack stack = new Stack(); 
         for(int x = v; x != s; x = edgeTo[x]) 
               stack.push(x);
     return stack; 
     }
} 
 public class GraphClient
{
    public static void main(String[] args)
    {
         Graph g = new Graph(13);

         g.addEdge(0,5);
         g.addEdge(4,3);
         g.addEdge(0,1);
         g.addEdge(9,12);
         g.addEdge(6,4);
         g.addEdge(5, 4);
         g.addEdge(0,2);
         g.addEdge(11,12);
         g.addEdge(9,10);
         g.addEdge(0,6);
         g.addEdge(7,8);
         g.addEdge(9,11);
         g.addEdge(5, 3);

         System.out.println(g);

         DFS dfs = new DFS(g, 0);

         System.out.println(dfs.hasPathTo(11));
         System.out.println(dfs.hasPathTo(3));

         System.out.print("Path : ");
         for(int i : dfs.pathTo(3))
             System.out.print(i + " ");
    }
}