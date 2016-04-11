import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import graph.Graph;
import graph.Node;

public class Dijkstra {
    // Data
    private Node source;
    private boolean dijkstraRun;

    private HashMap<Node,Integer> dist;
    private HashMap<Node,Node> prevHop;

    // Constructor
    public Dijkstra() {
        dijkstraRun = false;
        dist = new HashMap<Node,Integer>();
        prevHop = new HashMap<Node,Node>();
    }

    // Interface
    public ArrayList<Node> getShortestPath(String nodeKey) {
        if (!dijkstraRun)
            return null;

        Node node = new Node(nodeKey);
        ArrayList<Node> path = new ArrayList<Node>();
        path.add(node);

        return findPath(node, path);
    }
    private ArrayList<Node> findPath(Node node, ArrayList<Node> path) {
        Node prevNode = prevHop.get(node);
        if(node == source)
            return path;
        else {
            path.add(prevNode);
            return findPath(prevNode, path);
        }
    }

    public void runDijkstra(Graph graph, Node source) {
        HashSet<Node> nodes = graph.getNodes();

        initHashMaps(nodes);

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
                    node = minUnvisited(visited, nodes);
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


    // Util
    private void initHashMaps(HashSet<Node> nodes) {
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

    private Node minUnvisited(HashSet<Node> visited, HashSet<Node> nodes) {
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

} // END Dijkstra
