import java.util.HashMap;

class Node {
    private String key; // Nodes are uniquely defined by their keys
    private HashMap<Node, Integer> neighbors;

    public Node(String key) {
        this.key = key;
        neighbors = new HashMap<Node, Integer>();
    }

    public String toString() {
       String nodeString = key + "\n";
       for(Node neighbor : getNeighbors())
            nodeString += "   " + neighbor.getKey() + " " + neighbors.get(neighbor) + "\n";
       return nodeString;
    }

    public void addNeighbor(Node node, int cost) {
        neighbors.put(node,cost);
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
