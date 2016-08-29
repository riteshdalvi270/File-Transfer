package first.crackingthecode.tree;

import java.util.*;

/**
 * @author Ritesh Dalvi (RD026600)
 */
public class RouteBetweenDirectedGraphsBFS
{


    public void shortestPath(Graph graph, Vertex source) {

        // use queue instead.
        Queue<Vertex> queue = new PriorityQueue<Vertex>();

        for(Vertex u : graph.vetices)
        {
            u.color = "white";
            u.distance = 0;
            u.parent = null;
        }

            source.color="GRAY";
            source.distance = 0;
            source.parent = null;

        queue.add(source);

            while(!queue.isEmpty()) {

                Vertex u = queue.element();

                for(Vertex v : graph.adj.get(u)) {
                    if(v.color == "WHITE") {
                        v.color = "GRAY";
                        v.distance = u.distance+v.distance;
                        v.parent = u;

                        queue.add(v);
                    }
                    u.color="BLACK";
            }
        }
    }

    public class Graph {
        List<Vertex> vetices;
        Map<Vertex,List<Vertex>> adj;
    }

    public class Vertex {
        String color;
        Vertex parent;
        int distance;
    }
}
