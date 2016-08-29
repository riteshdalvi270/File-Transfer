package third.crackingcode.binarytree;

import assistant.Graph;
import assistant.GraphAssistant;
import assistant.Vertex;

import java.util.*;

/**
 * Algo to find route between two nodes.
 * Created by ritesh on 12/19/15.
 */
public class RouteBetweenTwoNodes {

    public static void main(String args[]) {

        final GraphAssistant graphAssistant = new GraphAssistant(new Graph());

        graphAssistant.addVertices("A");
        graphAssistant.addVertices("B");
        graphAssistant.addVertices("C");
        graphAssistant.addVertices("D");
        graphAssistant.addVertices("E");
        graphAssistant.addVertices("F");
        graphAssistant.addVertices("G");
        graphAssistant.addVertices("H");


        try {
            graphAssistant.addEdges("A", "B");
            graphAssistant.addEdges("A", "C");
            graphAssistant.addEdges("B", "D");
            graphAssistant.addEdges("B", "E");
            graphAssistant.addEdges("C", "F");
            graphAssistant.addEdges("D", "G");
            graphAssistant.addEdges("E", "H");

            graphAssistant.printNeighbors("A");
            graphAssistant.printNeighbors("B");
            graphAssistant.printNeighbors("C");
            graphAssistant.printNeighbors("D");
            graphAssistant.printNeighbors("E");
            graphAssistant.printNeighbors("F");
            graphAssistant.printNeighbors("G");
            graphAssistant.printNeighbors("H");

            System.out.println(doesRouteExist(graphAssistant,"A","E"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean doesRouteExist(final GraphAssistant graphAssistant, final String source, final String destination) throws Exception {

        Map<Vertex, List<Vertex>> edges = graphAssistant.getEdges();
        boolean routeDoesExist = false;

        for (final List<Vertex> vertices : edges.values()) {

            for (Vertex vertex : vertices) {
                vertex.setColor("WHITE");
            }
        }

        final Queue<String> queue = new ArrayDeque<>();
        queue.add(source);

        graphAssistant.changeColor(source, "BLACK");

        while(!queue.isEmpty()) {

            String startingSource = queue.remove();

            for (final Vertex vertex : graphAssistant.getNeightbors(startingSource)) {

                if (vertex.getValue().equals(destination)) {
                    routeDoesExist = true;
                    return routeDoesExist;
                }

                if (!vertex.getColor().equals("BLACK")) {

                    graphAssistant.changeColor(vertex.getValue(), "BLACK");
                    queue.add(vertex.getValue());
                }
            }
        }
        return false;
    }
}
