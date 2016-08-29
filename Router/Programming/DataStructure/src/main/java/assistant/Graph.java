package assistant;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Implement a graph
 * Created by ritesh on 12/19/15.
 */
public class Graph {

    List<Vertex> vertices;
    Map<Vertex, List<Vertex>> edges;

    public List<Vertex> getVertices() {
        return vertices;
    }

    public void setVertices(List<Vertex> vertices) {
        this.vertices = vertices;
    }

    public void setEdges(final Vertex source, final List<Vertex> vertices) {

        if (edges == null) {
            edges = new HashMap<Vertex, List<Vertex>>();
        }

        edges.put(source, vertices);
    }

    public void setEdges(final Map<Vertex, List<Vertex>> edges) {
        this.edges = edges;
    }

    public Map<Vertex, List<Vertex>> getEdges() {
        return edges;
    }
}

