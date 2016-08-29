package second.crackingcode.binarytree;

import java.util.List;
import java.util.Map;

/**
 * @author Ritesh Dalvi (RD026600)
 */
public class DFS
{
    int time = 0;

    public void DFS(Graph graph, Vertex source)
    {

        for (Vertex vertex : graph.vertices)
        {
            vertex.color = "WHITE";
            vertex.start = 0;
            vertex.finish = 0;
            vertex.parent = null;
        }

        source.start = 0;
        source.parent = null;
        source.color = "GRAY";

        for (Vertex v : graph.adj.get(source))
        {

            if (v.color == "WHITE")
            {
                v.parent = source;
                DFS_VISIT(graph, v);
            }
        }
    }

    public void DFS_VISIT(Graph graph, Vertex v)
    {
        v.color = "GRAY";
        time = time+1;
        v.start = time; // discovered vertex.

        for (Vertex u : graph.adj.get(v))
        {
                u.parent = v;
                DFS_VISIT(graph, u);
        }

        v.color = "BLACK";
        time= time+1;
        v.finish = time;

    }

    class Graph
    {

        List<Vertex> vertices;
        Map<Vertex, List<Vertex>> adj;
    }

    class Vertex
    {
        int start;
        int finish;
        Vertex parent;
        String color;
    }
}
