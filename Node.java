import java.util.HashMap;

class Node {
    private String key;
    private HashMap<Node, Integer> neighbors;

    public Node(String key, HashMap<Node, Integer> neighbors) {
        this.key = key;
        this.neighbors = neighbors;
    }

    public String toString() {
       String nodeString = key + "\n";
       for(Node neighbor : getNeighbors()) 
            nodeString += "   " + neighbor.getKey() + " " + neighbors.get(neighbor) + "\n";
       return nodeString;
    }

    public String getKey() { return key; }

    public Node[] getNeighbors() {
        return (Node[]) neighbors.keySet().toArray();
    }

    public boolean hasNeighbor(Node node) {
        return neighbors.containsKey(node);
    }

    public int costTo(Node node) {
        return neighbors.get(node);
    }
}
