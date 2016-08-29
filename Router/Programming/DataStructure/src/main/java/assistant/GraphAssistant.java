package assistant;

import java.util.*;

/**
 * Assistant to create graphs.
 * Created by ritesh on 12/19/15.
 */
public class GraphAssistant {

    final Graph graph;
    List<Vertex> vertices = null;
    Map<Vertex, List<Vertex>> edges = null;

    public GraphAssistant(final Graph graph) {
        this.graph = graph;
    }

    public void addVertices(final List<Vertex> vertices) {
        this.vertices = vertices;
        graph.setVertices(this.vertices);
    }

    public List<Vertex> getVertices() {
        return graph.getVertices();
    }

    public Map<Vertex, List<Vertex>> getEdges() {
        return graph.getEdges();
    }

    public void addVertices(final String value) {

        if (vertices == null) {
            vertices = new ArrayList<Vertex>();
        }

        vertices.add(new Vertex(value));

        graph.setVertices(vertices);
    }

    public void changeColor(final String source, final String color) throws Exception {

        List<Vertex> vertices = graph.getVertices();

        boolean changedColor = false;
        for (final Vertex vertex : vertices) {

            if (vertex.getValue().equals(source)) {
                vertex.setColor(color);
                changedColor = true;
                break;
            }
        }

        if (!changedColor) {
            throw new Exception("Failed to change color, please verify the source");
        }
    }

    public void addEdges(final Vertex source, final List<Vertex> destination) {
        graph.setEdges(source, destination);
    }

    public void addEdges(final String source, final String destination) throws Exception {

        boolean sourceExist = false;
        boolean destinationExist = false;

        for (final Vertex vertex : vertices) {

            if (vertex.getValue().equals(source)) {
                sourceExist = true;
            } else if (vertex.getValue().equals(destination)) {
                destinationExist = true;
            }

            if (sourceExist && destinationExist) {
                break;
            }
        }

        if (!sourceExist || !destinationExist) {
            throw new Exception("Vertices do not exist for the graph");
        }

        if (edges == null) {
            edges = new HashMap<Vertex, List<Vertex>>();
        }

        Vertex destinationVertex = null;

        boolean edgeAlreadyExist = false;

        for (final Map.Entry<Vertex, List<Vertex>> entrySet : edges.entrySet()) {

            Vertex key = entrySet.getKey();

            if (key.getValue().equals(source)) {

                for (final Vertex vertex : graph.getVertices()) {

                    if (vertex.getValue().equals(destination)) {
                        destinationVertex = vertex;
                    }
                }

                edges.get(key).add(destinationVertex);
                edgeAlreadyExist = true;
                break;
            }
        }

        if (!edgeAlreadyExist) {

            Vertex sourceVertex = null;
            List<Vertex> vertices = graph.getVertices();

            for (final Vertex vertex : vertices) {

                if (vertex.getValue().equals(source)) {
                    sourceVertex = vertex;
                }

                if (vertex.getValue().equals(destination)) {
                    destinationVertex = vertex;
                }
            }

            final List<Vertex> destinations = new ArrayList<Vertex>();
            destinations.add(destinationVertex);

            edges.put(sourceVertex, destinations);
        }

        graph.setEdges(edges);
    }


    public void printNeighbors(final String source) throws Exception {

        List<Vertex> neighbors = null;
        for (final Map.Entry<Vertex, List<Vertex>> entrySet : edges.entrySet()) {

            Vertex key = entrySet.getKey();

            if (key.getValue().equals(source)) {
                neighbors = entrySet.getValue();
                break;
            }
        }

        if (neighbors == null) {
            return;
        }

        for (final Vertex neighbor : neighbors) {
            System.out.println("Source:" + source + "->" + neighbor.getValue());
        }
    }

    public List<Vertex> getNeightbors(final String source) {

        for (final Map.Entry<Vertex, List<Vertex>> entrySet : edges.entrySet()) {

            Vertex key = entrySet.getKey();

            if (key.getValue().equals(source)) {
                return entrySet.getValue();
            }
        }

        return new ArrayList<>();
    }
}
