import java.util.ArrayList;
import java.util.HashMap;

class Graph {
    private ArrayList<Node> nodes;
    private Node source;
    private HashMap<Node, Integer> dist;
    private HashMap<Node, Node> prevHop;

    public Graph(Node source, ArrayList<Node> nodes) {
        this.source = source;
        this.nodes = nodes;

        for(Node node : nodes) {
            dist.put(node, Integer.MAX_VALUE);
            prevHop.put(node, null);
        }
    }
}
