package crackingcodefive.binary;

import java.util.*;

/**
 * Created by ritesh on 8/25/16.
 */
public class RouteBetweenTwoNodes {

    public static void main(String args[]) {

        final Graph graph = new Graph();

        final Vertex source = new Vertex();

        final Vertex destination = new Vertex();

        routeBetweenTwoNodesBFS(graph, source, destination);
    }

    public static boolean routeBetweenTwoNodesBFS(final Graph graph, final Vertex source, final Vertex destination) {

        final List<Vertex> vertices = graph.getVertices();
        final Map<Vertex, List<Vertex>> edges = graph.getEdges();

        final Queue<Vertex> queue = new ArrayDeque<>();

        for(final Vertex vertex : vertices) {

            vertex.setColor("white");

            if(source == vertex) {
                vertex.setColor("black");
                queue.add(vertex);
            }
        }

        while(!queue.isEmpty()) {

            final Vertex vertex = queue.remove();

            if(vertex == destination) {
                return true;
            }

            if(vertex.getColor().equals("white")) {

                vertex.setColor("black");

                List<Vertex> adjVertices = edges.get(vertex);

                for (final Vertex adjVertex : adjVertices) {
                    queue.add(adjVertex);
                }
            }

        }

        return false;
    }


    public static boolean routeBetweenNodesDFS(final Graph graph, final Vertex source, final Vertex destination) {

        final List<Vertex> vertices = graph.getVertices();
        final Map<Vertex, List<Vertex>> edges = graph.getEdges();

        final Stack<Vertex> stack = new Stack<>();

        for(final Vertex vertex : vertices) {

            vertex.setColor("white");

            if(source == vertex) {
                vertex.setColor("black");
                stack.add(vertex);
            }
        }

        while(!stack.isEmpty()) {

           final Vertex vertex =  stack.pop();

            if(vertex == destination) {
                return true;
            }

            vertex.setColor("black");

            final List<Vertex> adjVertices = edges.get(vertex);

            for(final Vertex adjVertex : adjVertices) {
                stack.add(adjVertex);
            }
        }

        return false;
    }

    static class Graph {

        List<Vertex> vertices;
        Map<Vertex, List<Vertex>> edges;

        public List<Vertex> getVertices() {
            return vertices;
        }

        public Map<Vertex, List<Vertex>> getEdges() {
            return edges;
        }
    }

    static class Vertex {

        String data;
        String color;
        Vertex parent;

        public String getData() {
            return data;
        }

        public String getColor() {
            return color;
        }

        public Vertex getParent() {
            return parent;
        }

        public void setColor(final String color) {
            this.color = color;
        }
    }
}
