import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

class Graph {
    // Data
    private HashSet<Node> nodes;
    private Node source;

    // Constructors
    public Graph(HashSet<Node> nodes) {this.nodes = nodes;}
    public Graph(HashSet<Node> nodes, Node source) {
        this.nodes = nodes;
        this.source = source;
    }


    // Interface
    public boolean contains(String nodeKey) {
        return nodes.contains(new Node(nodeKey));
    }


    // Interface - Get
    public int size() { return nodes.size(); }
    public Node getSource() { return source; }
    public HashSet<Node> getNodes() { return nodes; }

    public Node getNode(String nodeKey) {
        for (Node node : nodes)
            if(node.getKey().equals(nodeKey))
                return node;
        return null;
    }


    // Interface - Set
    public void addNode(Node node) { nodes.add(node); }
    public void setSource(Node source) { this.source = source; }


    // Equals & hashCode
    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;

        Graph target = (Graph) obj;
        return (nodes.equals(target)) ? true:false;
    }

    @Override
    public int hashCode() { return nodes.hashCode() * 95; }


    // To String
    @Override
    public String toString() {
        String graphString = "Nodes:\n";
        for(Node node : nodes)
            graphString += node.toString() + ": " + node.neighborString() + "\n";
        return graphString;
    }

} // END Graph
