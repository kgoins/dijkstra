// import java.util.ArrayList;
// import java.util.Arrays;
// import java.io.*;

// class GraphParser {
//     private ArrayList<String[]> graphFile;
//     private Node[] nodes;

//     public GraphParser() {}

//     public Graph parseFile(String filepath) {
//         ArrayList<String[]> graphFile = loadTxtFile(filepath);
//         graphFile = sanitize();

//         Node[] nodes = initNodes();
//         Node source = getSource(nodes);

//         Graph graph = new Graph(source, Arrays.asList(nodes));
//         return graph;
//     }


//     private ArrayList<String[]> loadTxtFile(String filepath) {
//         graphFile = new ArrayList<String[]>();

//         try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
//             String line;
//             while ((line = br.readLine()) != null)
//                 graphFile.add(line.split(","));

//         } catch(IOException e) {System.out.println(e.getStackTrace());}

//         return graphFile;
//     }

//     private Node getSource() {
//         String sourceKey = graphFile.get(0)[0];
//         Node source = null;
//         for(Node node : nodes) {
//             if (node.getKey().equals(sourceKey))
//                 source = node;
//         }
//         return source;
//     }

//     private Node[] initNodes() {
//         Node[] nodes = new Node[graphFile.size()];
//         for(int i = 0; i < graphFile.size(); i++ ) {
//             String[] nodeString = graphFile.get(i);
//             String key = nodeString[0];
//             nodes[i] = new Node(key);
//         }
//         return nodes;
//     }

//     private Node[] setNodeNeighbors() {
//         for (int i = 0; i < nodes.length; i++) {
//             Node node = nodes[i];
//             String[] nodeLine = graphFile.get(i);
//             for (int j = 1; j < nodeLine.length; j++) {
//                 int cost = Integer.parseInt(nodeLine[j]);
//                 if(cost != 0  && cost != Integer.MAX_VALUE)
//                     node.addNeighbor(nodes[i], cost);
//             }
//         }

//     }

//     // Converts matrix cells from Strings to ints
//     // Replaces "N" with Integer.MAX_VALUE
//     private ArrayList<String[]> sanitize() {}


// }
