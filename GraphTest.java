import java.util.ArrayList;

class GraphTest {
    public static void main(String[] args) {
       GraphBuilder builder = new GraphBuilder();
       Graph easyTest = builder.build("test.graphfile");
       Graph harderTest = builder.build("harderTest.graphfile");

       ArrayList<Node> easyPath = easyTest.getPathTo("c");
       ArrayList<Node> harderPath = harderTest.getPathTo("h");

       for(Node node : easyPath)
        System.out.print(node + " ");

        System.out.println();

       for(Node node : harderPath)
        System.out.print(node + " ");

        System.out.println();

       // System.out.println(easyTest);
       // System.out.println();
       // System.out.println(harderTest);

   }
}
