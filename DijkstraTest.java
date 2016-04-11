import java.util.ArrayList;

import graph.*;

class DijkstraTest {
    public static void main(String[] args) {
       GraphBuilder builder = new GraphBuilder();
       Graph easyTest = builder.build("test.graphfile");
       Graph harderTest = builder.build("harderTest.graphfile");

       Dijkstra dijkstra = new Dijkstra();
       dijkstra.runDijkstra(easyTest, easyTest.getSource());

       ArrayList<Node> easyPath = dijkstra.getShortestPath("c");

       for(Node node : easyPath)
        System.out.print(node + " ");

        System.out.println();

       dijkstra.runDijkstra(harderTest, harderTest.getSource());
       ArrayList<Node> harderPath = dijkstra.getShortestPath("h");

       for(Node node : harderPath)
        System.out.print(node + " ");

        System.out.println();

       // System.out.println(easyTest);
       // System.out.println();
       // System.out.println(harderTest);

   }
}
