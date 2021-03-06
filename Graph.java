import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

class Graph {
    // Data
    private HashSet<Node> nodes;
    private Node source;

    private boolean dijkstraRun = false;
    private HashMap<Node, Integer> dist;
    private HashMap<Node, Node> prevHop;

    // Constructors
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

        dist = new HashMap<Node,Integer>();
        prevHop = new HashMap<Node,Node>();

        resetHashMaps();
    }


    // Interface
    public boolean contains(String nodeKey) {
        return nodes.contains(new Node(nodeKey));
    }

    public ArrayList<Node> getPathTo(String nodeKey) {
        if(!dijkstraRun)
            runDijkstra();

        Node node = getNode(nodeKey);
        ArrayList<Node> path = new ArrayList<Node>();
        path.add(node);

        return findPath(node, path);
    }

    public void runDijkstra() {
        resetHashMaps();
        HashSet<Node> visited = new HashSet<Node>();
        visited.add(source);

        for(Node node : nodes) {
            if (source.hasNeighbor(node)) {
                dist.put(node, source.costTo(node));
                prevHop.put(node, source);
            }
        }

        while(visited.size() != nodes.size()) {
            for(Node node : nodes) {
                if (!visited.contains(node)) {
                    node = minUnvisited(visited);
                    visited.add(node);
                    for(Node neighbor : node.getNeighbors()) {
                        if(!visited.contains(neighbor)) {
                            int neighborCost = dist.get(neighbor);
                            int altCost = dist.get(node) + node.costTo(neighbor);

                            neighborCost = (neighborCost < altCost) ? neighborCost:altCost;
                            dist.put(neighbor, neighborCost);
                            prevHop.put(neighbor, node);
                        }
                    }
                }
            }
        }
        dijkstraRun = true;
    }


    // Interface - gets
    public int size() { return nodes.size(); }
    public HashSet<Node> getNodes() {return nodes;}

    public Node getNode(String nodeKey) {
        for (Node node : nodes)
            if(node.getKey().equals(nodeKey))
                return node;
        return null;
    }


    // Interface - Sets
    public void addNode(Node node) { nodes.add(node); dijkstraRun = false;}
    public void setSource(Node source) {
        this.source = source;
        dijkstraRun = false;
        runDijkstra();
    }


    // Util
    private ArrayList<Node> findPath(Node node, ArrayList<Node> path) {
        Node prevNode = prevHop.get(node);
        if(node == source)
            return Collections.reverse(path);
        else {
            path.add(prevNode);
            return findPath(prevNode, path);
        }
    }
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

    private Node minUnvisited(HashSet<Node> visited) {
        int minCost = Integer.MAX_VALUE;
        Node minNode = null;

        for(Node node : nodes) {
            if(!visited.contains(node)) {
                int cost = dist.get(node);
                if(cost <= minCost) {
                    minCost = cost;
                    minNode = node;
                }
            }
        }
        return minNode;
    }


    // equals & hashCode
    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;

        Graph target = (Graph) obj;
        return (nodes.equals(target)) ? true:false;
    }

    @Override
    public int hashCode() {return nodes.hashCode() * 95;}


    // To String
    public String toString() {
        String graphString = "";
        graphString += printDist() + "\n\n";
        graphString += printPrevHop() + "\n\n";
        graphString += "Nodes:\n";
        for(Node node : nodes)
            graphString += node.toString() + ": " + node.neighborString() + "\n";
        return graphString;
    }

    private String printDist() {
        String nodeKeys = "";
        String nodeDist = "";
        for(Node node : dist.keySet()) {
            nodeKeys += String.format("%-16s", node.getKey());
            nodeDist += String.format("%-16s", dist.get(node) + " ");
        }
        return "Distance Vector\n" + nodeKeys + "\n" + nodeDist;
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
        return "Previous Hop\n" + nodeKeys + "\n" + nodePrev;
    }

}
