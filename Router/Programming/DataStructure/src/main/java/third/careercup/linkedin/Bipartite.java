package third.careercup.linkedin;

import assistant.Graph;
import assistant.GraphAssistant;
import assistant.Vertex;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * check if undirected graph is bipartite.
 * Created by ritesh on 1/17/16.
 */
public class Bipartite {

    public static void main(String args[]) {

        Graph graph = new Graph();
        GraphAssistant graphAssistant = new GraphAssistant(graph);

        Vertex A = new Vertex("A");
        Vertex B = new Vertex("B");
        Vertex C = new Vertex("C");
        Vertex D = new Vertex("D");
        Vertex E = new Vertex("E");

        List<Vertex> vertices = new ArrayList<>();
        vertices.add(A);
        vertices.add(B);
        vertices.add(C);
        vertices.add(D);
        vertices.add(E);

        graphAssistant.addVertices(vertices);

        try {
            graphAssistant.addEdges("A", "B");
            graphAssistant.addEdges("B", "C");
            graphAssistant.addEdges("C", "D");
            graphAssistant.addEdges("D", "E");
            graphAssistant.addEdges("E", "B");


            System.out.println(isBipirateGraph(graph, graphAssistant));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean isBipirateGraph(final Graph graph, final GraphAssistant graphAssistant) throws Exception {

        final Stack<Vertex> stack = new Stack<>();

        for (final Vertex vertex : graph.getVertices()) {

            vertex.setColor("White");
        }

        stack.push(graph.getVertices().get(0));

        while (!stack.isEmpty()) {

            final Vertex rootVertex = stack.pop();

            if (rootVertex.getColor().equals("Blue")) {
                graphAssistant.changeColor(rootVertex.getValue(), "Black");
            } else {
                graphAssistant.changeColor(rootVertex.getValue(), "Blue");
            }

            for (final Vertex vertex : graphAssistant.getNeightbors(rootVertex.getValue())) {

                if (vertex.getColor().equals("Black")) {
                    return false;
                }

                if (!vertex.getColor().equals("Blue")) {
                    vertex.setColor("Blue");

                    stack.push(vertex);
                }
            }
        }

        return true;
    }
}
