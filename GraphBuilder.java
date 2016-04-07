import java.util.ArrayList;
import java.util.HashSet;
import java.io.*;

class GraphBuilder {
	public GraphBuilder() {}

	public Graph parseTxtFile(String filepath) {
		ArrayList<String[]> file = loadTxtFile(filepath);

		Graph graph = new Graph()

	}

	private ArrayList<String[]> loadTxtFile(String filepath) {
		ArrayList<String[]> file = new ArrayList<String[]>();

		try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
			String line;
			while ((line = br.readLine()) != null) {
				file.add(line.split(","));
			}
		} catch(IOException e) {System.out.println(e.getStackTrace());}

		return file;
	}

	// Returns everything the builder needs to construct the graph
	private HashSet<Node> parseFile(ArrayList<String[]> file) {
		HashSet<Node> nodes = createNodes(file);
		nodes = setNodeNeighbors(nodes, file);

		return nodes;
	}

	// String[] format: [key,n1,c1,n2,c2,...]
	public Graph buildGraph(HashSet<Node> nodes, Node source) {
		Graph graph = new Graph(source, nodes);

		graph.setSource(source);

		return graph;
	}
}