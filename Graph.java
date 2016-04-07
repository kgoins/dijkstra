import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

class Graph {
    private HashSet<Node> nodes;
    private Node source;

    private HashMap<Node, Integer> dist;
    private HashMap<Node, Node> prevHop;

    public Graph() {
    	source = null;
    	nodes = new HashSet<Node>();

    	dist = new HashMap<Node, Integer>();
    	prevHop = new HashMap<Node, Node>();
    	resetHashMaps();
    }

    public Graph(Node source, HashSet<Node> nodes) {
        this.source = source;
        this.nodes = nodes;

        dist = new HashMap<Node, Integer>();
        prevHop = new HashMap<Node, Node>();

        resetHashMaps();
    }

    public String toString() {
    	String graphString = "";
    	for(Node node : nodes)
    		graphString += node.toString();
    	return graphString;
    }

    public void addNode(Node node) { nodes.add(node); }

    public void setSource(Node source) {
        this.source = source;
        runDijkstra();
    }

    private void resetHashMaps() {
        for(Node node : nodes) {
            dist.put(node, Integer.MAX_VALUE);
            prevHop.put(node, null);
        }
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

    public void runDijkstra() {
        resetHashMaps();

        HashSet<Node> visited = new HashSet<Node>();
    }
}
