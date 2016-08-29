package first.crackingthecode.tree;

import java.util.List;
import java.util.Map;

/**
 * @author Ritesh Dalvi (RD026600)
 */
public class RouteBetweenDirectedGraphDFS
{

    int time = 0;
    public void DFS(Graph graph, Vertex source) {

        for(Vertex u : graph.vertices) {
            u.color = "WHITE";
            u.parent = null;
            u.start = 0;
            u.finish = 0;
        }

        source.parent = null;
        source.color = "GRAY";
        source.start = 0; // source starts with 0.
        source.finish = 0;

        for(Vertex v : graph.adj.get(source)) {

            if(v.color == "WHITE") {
                v.parent = source;
                DFS_VISIT(v, graph);
            }
        }
    }

    public void DFS_VISIT(Vertex v, Graph g) {
        v.color = "GRAY";
        time = time+1;;
        v.start = time; // vertex has just been discovered.

        for(Vertex u : g.adj.get(v)) {
            u.parent = v;
            DFS_VISIT(u,g);
        }

        v.color = "BLACK";
        time = time+1;
        v.finish = time;
    }

    public class Graph
    {
        List<Vertex> vertices;
        Map<Vertex, List<Vertex>> adj;
    }

    public class Vertex {
        String color;
        int start;
        int finish;
        Vertex parent;
    }
}
