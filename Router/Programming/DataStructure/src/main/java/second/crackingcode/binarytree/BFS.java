package second.crackingcode.binarytree;

import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Breath First Search.
 * @author Ritesh Dalvi (RD026600)
 */
public class BFS
{

    public void BFS(Graph graph, Vertex source) {

        final Queue<Vertex> queue = new PriorityQueue();

        for(Vertex vertex : graph.vertices) {
            vertex.color = "WHITE";
            vertex.distance = 0;
            vertex.parent = null;
        }

        source.distance = 0;
        source.parent = null;
        source.color = "GRAY";

        queue.add(source);

        while(!queue.isEmpty())
        {
            Vertex u = queue.element();
            for (Vertex vertex : graph.adj.get(u))
            {
                if (vertex.color == "WHITE")
                {
                    vertex.color = "GRAY";
                    vertex.distance = vertex.distance + u.distance;
                    vertex.parent = u;

                    queue.add(vertex);
                }
            }

            u.color = "BLACK";
        }

    }


    class Graph {

        List<Vertex> vertices;
        Map<Vertex, List<Vertex>> adj;
    }

    class Vertex {
        int distance;
        Vertex parent;
        String color;
    }
}
