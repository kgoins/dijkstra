import java.util.ArrayList;
import java.util.HashSet;
import java.io.*;

class GraphBuilder {
	public GraphBuilder() {}

	// String[] format: [key,n1,c1,n2,c2,...]
	public Graph build(ArrayList<String[]> graphFile) {
        HashSet<Node> nodes = initNodes(graphFile);
        nodes = setNodeNeighbors(nodes, graphFile);

		Graph graph = new Graph(getSource(nodes, graphFile), nodes);
		return graph;
	}

	private Node getSource(HashSet<Node> nodes, ArrayList<String[]> graphFile) {
		String sourceKey = graphFile.get(0)[0];
		Node source = null;
		for(Node node : nodes)
			if (node.getKey().equals(sourceKey))
				source = node;
		return source;
	}
	private HashSet<Node> initNodes(ArrayList<String[]> graphFile) {
		HashSet<Node> nodes = new HashSet<Node>();
		for(String[] nodeString : graphFile) {
			String key = nodeString[0];
			nodes.add(new Node(key));
		}

		return nodes;
	}
	private HashSet<Node> setNodeNeighbors(HashSet<Node> nodes, ArrayList<String[]> graphFile) {
		for(String[] nodeString : nodes) {
			if ()
		}
	}
}
