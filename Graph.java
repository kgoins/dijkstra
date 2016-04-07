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
        resetMaps();
    }

    public void setSource(Node source) {
        this.source = source;
        runDijkstra();
    }

    private void resetMaps() {
        for(Node node : nodes) {
            dist.put(node, Integer.MAX_VALUE);
            prevHop.put(node, null);
        }
    }

    public void runDijkstra() {
        resetMaps();
    }

    private Node minDistEntry() {
        int minCost = Integer.MAX_VALUE;
        Node minNode = null;

        for(Node node : nodes) {
            int cost = dist.get(node);
            if(cost < minCost) {
                minCost = cost;
                minNode = node;
            }
        }

        return minNode;
    }
}
