import Dijkstras.*;
public class Dijkstras {
	private List<Vertex> nodes;
	private List<Edge> edges;
	private Graph graph;
	public Dijkstras() {
		nodes = new ArrayList<Vertex>();
		edges = new ArrayList<Edge>();
		graph = new Graph(nodes, edges);
	}
	public void addNode(String ip) {
		nodes.add(new Vertex(ip, ip));
		graph = new Graph(nodes, edges);
	}
	public void addEdge(int val1, int val2, int cost) {
		edges.add(new Edge(ip1+"_"+ip2, nodes.get(val1), nodes.get(val2), cost));
		graph = new Graph(nodes, edges);
	}
	
}