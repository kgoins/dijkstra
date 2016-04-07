import java.util.HashMap;

class Node {
    private String key;
    private HashMap<Node, Integer> neighbors;

    public Node(String key, HashMap<Node, Integer> neighbors) {
        this.key = key;
        this.neighbors = neighbors;
    }

    public Node[] getNeighbors() {
        return (Node[]) neighbors.keySet().toArray();
    }

    public boolean hasNeighbor(Node node) {
        return neighbors.containsKey(node);
    }

    int costTo(Node node) {
        return neighbors.get(node);
    }
}
