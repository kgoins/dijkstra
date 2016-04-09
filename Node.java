import java.util.HashMap;
import java.util.Set;

class Node {
    // Data
    private String key; // Nodes are uniquely defined by their keys
    private HashMap<Node, Integer> neighbors;

    // Constructor
    public Node(String key) {
        this.key = key;
        neighbors = new HashMap<Node, Integer>();
    }

    // Interface
    public boolean hasNeighbor(Node node) {
        return neighbors.containsKey(node);
    }

    public int costTo(Node node) {
        return neighbors.get(node);
    }

    // Interface - Gets
    public String getKey() { return key; }

    public Node[] getNeighbors() {
        Set<Node> keys = neighbors.keySet();
        Node[] keyArray = keys.toArray(new Node[keys.size()]);
        return keyArray;
    }

    // Interface - Sets
    public void addNeighbor(Node node, int cost) {
        neighbors.put(node,cost);
    }

    // To String
    public String toString() {
       String nodeString = key + "\n";
       for(Node neighbor : getNeighbors())
            nodeString += "   " + neighbor.getKey() + " " + neighbors.get(neighbor) + "\n";
       return nodeString;
    }
}
