import java.util.ArrayList;
import java.util.HashSet;
import java.io.*;

class GraphBuilder {
	public GraphBuilder() {}

	// String[] format: [key,n1,c1,n2,c2,...]
	public Graph build(ArrayList<String[]> file) {
        HashSet<Node> nodes = new HashSet<Node>();
        Node source = createNode(file.get(0));

        for(String[] line : file)
        	nodes.put(createNode(line));

        nodes = setNodeNeighbors(nodes, file);

		Graph graph = new Graph(source, nodes);
		return graph;
	}
}
