package Dijkstras;
public class Edge  {
	final Vertex source;
	final Vertex destination;
	final int weight; 
	public Edge( Vertex source, Vertex destination, int weight) {
		this.source = source;
		this.destination = destination;
		this.weight = weight;
	}

	public Vertex getDestination() {return destination;}
	public Vertex getSource() {return source;}
	public int getWeight() {return weight;}
	public String toString() {return source + " " + destination;}
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Edge other = (Edge) obj;
		if (source == null && destination==null) {
			if (other.source != null && other.destination != null)
				return false;
		} else if (!((source.equals(other.source) && destination.equals(other.destination) && weight == other.weight) || (source.equals(other.destination) && destination.equals(other.source) && weight==other.weight)))
			return false;
		return true;
	}
}