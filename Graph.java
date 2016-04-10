import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

class Graph {
    // Data
    private ArrayList<Node> nodes;
    private Node source;

    private HashMap<Node, Integer> dist;
    private HashMap<Node, Node> prevHop;

    // Constructors
    public Graph() {
    	source = null;
    	nodes = new ArrayList<Node>();

    	dist = new HashMap<Node, Integer>();
    	prevHop = new HashMap<Node, Node>();
    	resetHashMaps();
    }

    public Graph(Node source, ArrayList<Node> nodes) {
        this.source = source;
        this.nodes = nodes;

        dist = new HashMap<Node, Integer>();
        prevHop = new HashMap<Node, Node>();

        resetHashMaps();
    }


    // Interface
    public void runDijkstra() {
        resetHashMaps();
        HashSet<Node> visited = new HashSet<Node>();
    }


    // Interface - Sets
    public void addNode(Node node) { nodes.add(node); }
    public void setSource(Node source) {
        this.source = source;
        runDijkstra();
    }


    // Util
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


    // To String
    public String toString() {
        String graphString = "";
        graphString += printDist();
        graphString += printPrevHop();
        for(Node node : nodes)
            graphString += node.toString();
        return graphString;
    }

    private String printDist() {
        String nodeKeys = "";
        String nodeDist = "";
        for(Node node : dist.keySet()) {
            nodeKeys += String.format("%-16s", node.getKey());
            nodeDist += String.format("%-16s", (node == source) ? "0" : dist.get(node) + " ");
        }
        return "Distance Vector\n" + nodeKeys + "\n" + nodeDist + "\n\n";
    }

    private String printPrevHop() {
        String nodeKeys = "";
        String nodePrev= "";
        for(Node node : dist.keySet()) {
            nodeKeys += String.format("%-16s",node.getKey());
            nodePrev += String.format("%-16s",(node == source) ? "-" : prevHop.get(node));
        }
        return "Previous Hop\n" + nodeKeys + "\n" + nodePrev + "\n\n";
    }


    // Main
    public static void main(String[] args) {
        GraphBuilder builder = new GraphBuilder();
        Graph graph = builder.build("graphfile.test");
        System.out.println(graph);
    }
}
