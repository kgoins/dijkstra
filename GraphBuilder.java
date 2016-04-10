import java.util.ArrayList;
import java.io.*;

class GraphBuilder {
    // Data
    private ArrayList<Node> nodes;
    private ArrayList<String[]> graphfile;


    // Constructor
    public GraphBuilder() {}


    // Interface
    public Graph build(String filepath) {
        readGraphFile(filepath);

        initNodes();
        setNeighbors();

        Node source = nodes.get(0);
        return new Graph(source, nodes);
    }


    // Util - IO
    private void readGraphFile(String filepath) {
        graphfile = new ArrayList<String[]>();
        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            String line;
            while ((line = br.readLine()) != null)
                graphfile.add(parseFileLine(line));
        } catch(IOException e) {System.out.println(e.getStackTrace());}
    }

    private String[] parseFileLine(String line) {
        String[] lineArray = line.split(" ");
        String[] nodeLine = new String[lineArray.length*2];

        for (int i = 0; i < lineArray.length; i++) {
            String[] pair = lineArray[i].split(",");
            nodeLine[i*2] = pair[1];
            nodeLine[(i*2)-1] = pair[0];
        }
        return nodeLine;
    }


    // Util
    private void initNodes() {
        nodes = new ArrayList<Node>();
        for(String[] nodeLine : graphfile)
            nodes.add(new Node(nodeLine[0]));
    }

    private void setNeighbors() {
        for(int i = 0; i < nodes.size(); i++) {
            Node current = nodes.get(i);
            String[] nodeLine = graphfile.get(i);
            for(int j = 1; j < nodeLine.length; j += 2) {
                String nodeKey = nodeLine[j];
                Node neighbor = findNode(nodeKey);
                int cost = Integer.parseInt(nodeLine[j+1]);
                current.addNeighbor(neighbor, cost);
            }
        }
    }

    private Node findNode(String key) {
        Node target = null;
        for(Node node : nodes)
            if(node.getKey().equals(key))
                target = node;
        return target;
    }

    // toString
    public String toString() {
        String builderString = "";
        return builderString;
    }

    private String nodeString() {
        String nodeString = "";
        for()
        return nodeString;
    }
}
