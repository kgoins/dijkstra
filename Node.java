import java.util.HashMap;
import java.util.Set;

class Node {
    // Data
    private String key; // Nodes are uniquely defined by their keys
    private HashMap<Node,Integer> neighbors;

    // Constructor
    public Node(String key) {
        this.key = key;
        neighbors = new HashMap<Node, Integer>();
    }

    // Interface
    public boolean hasNeighbor(Node node) { return neighbors.containsKey(node); }
    public int costTo(Node node) { return neighbors.get(node); }

    @Override
    public boolean equals(Object obj) {
        if(obj == null)
            return false;

        Node target = (Node) obj;
        return (key.equals(target.getKey())) ? true:false;
    }

    @Override
    public int hashCode() {
        return key.hashCode();
    }


    // Interface - Gets
    public String getKey() { return key; }
    public Set<Node> getNeighbors() { return neighbors.keySet(); }


    // Interface - Sets
    public void addNeighbor(Node node, int cost) { neighbors.put(node,cost); }
    public void addNeighbor(String nodeKey, int cost) {
        neighbors.put(new Node(nodeKey), cost);
    }


    // To String
    public String toString() { return key; }
    public String neighborString() {
        String neighborString = "";
        for(Node node : getNeighbors())
            neighborString += node + "," + costTo(node) + ", ";

        neighborString = neighborString.substring(0, neighborString.length() -2);
        return neighborString;
    }
}
