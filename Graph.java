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
        visited.add(source);

        for(Node node : nodes) {
            if (source.hasNeighbor(node)) {
                dist.put(node, source.costTo(node));
                prevHop.put(node, node);
            }
        }

        System.out.println(visited);
        while(visited.size() != nodes.size()) {
            Node target = minDistEntry();
            for(Node neighbor : target.getNeighbors()) {
                if (!visited.contains(target)) {
                    int neighborCost = dist.get(neighbor);
                    int altCost = dist.get(target) + target.costTo(neighbor);

                    neighborCost = (neighborCost < altCost) ? neighborCost:altCost;
                    dist.put(neighbor, neighborCost);
                }
                visited.add(target);
            }
        }
    }


    // Interface - gets
    public int size() { return nodes.size(); }

    // Interface - Sets
    public void addNode(Node node) { nodes.add(node); }
    public void setSource(Node source) {
        this.source = source;
        runDijkstra();
    }


    // Util
    private void resetHashMaps() {
        for(Node node : nodes) {
            int initCost;
            Node prevNode;

            if (node == source) {
                initCost = 0;
                prevNode = source;
            } else {
                initCost = Integer.MAX_VALUE;
                prevNode = null;
            }

            dist.put(node, initCost);
            prevHop.put(node, prevNode);
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
            nodeDist += String.format("%-16s", dist.get(node) + " ");
        }
        return "Distance Vector\n" + nodeKeys + "\n" + nodeDist + "\n\n";
    }

    private String printPrevHop() {
        String nodeKeys = "";
        String nodePrev= "";
        for(Node node : dist.keySet()) {
            nodeKeys += String.format("%-16s",node.getKey());

            Node prevNode = prevHop.get(node);
            if(prevNode != null)
                nodePrev += String.format("%-16s", prevNode.getKey());
            else
                nodePrev += String.format("%-16s", prevNode);

        }
        return "Previous Hop\n" + nodeKeys + "\n" + nodePrev + "\n\n";
    }


    // Main
    public static void main(String[] args) {
        GraphBuilder builder = new GraphBuilder();
        Graph graph = builder.build("graphfile.test");

        // graph.runDijkstra();
        System.out.println(graph);
    }
}
