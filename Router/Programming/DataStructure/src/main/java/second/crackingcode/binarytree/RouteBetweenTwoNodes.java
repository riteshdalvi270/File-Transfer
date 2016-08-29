package second.crackingcode.binarytree;

import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Given directed graph, find route between two nodes.
 * @author Ritesh Dalvi (RD026600)
 */
public class RouteBetweenTwoNodes
{

    public void BFS(Graph graph, Vertex source, Vertex destination)
    {

        final Queue<Vertex> queue = new PriorityQueue<Vertex>();

        for (Vertex vertex : graph.vertices)
        {
            vertex.color = "WHITE";
            vertex.parent = null;
            vertex.distance = 0;
        }

        source.distance = 0;
        source.parent = null;
        source.color = "GRAY";

        queue.add(source);

        while (!queue.isEmpty())
        {

            Vertex u = queue.element();

            for (Vertex v : graph.adj.get(u))
            {

                if (v.color == "WHITE")
                {
                    v.color = "GRAY";
                    v.parent = u;
                    v.distance = u.distance + v.distance;

                    queue.add(v);
                }
            }

            u.color = "BLACK";
        }
    }

    public boolean determinePath(Graph g, Vertex source, Vertex destination) {

        if(source == null) {
            return false;
        }

        if(source == destination) {
            return true;
        }

        return determinePath(g,source,destination.parent);
    }

    class Graph
    {

        List<Vertex> vertices;
        Map<Vertex, List<Vertex>> adj;
    }

    class Vertex
    {
        int distance;
        Vertex parent;
        String color;
    }
}
