class GraphTest {
    public static void main(String[] args) {
       GraphBuilder builder = new GraphBuilder();
       Graph easyTest = builder.build("test.graphfile");
       Graph harderTest = builder.build("harderTest.graphfile");

       easyTest.runDijkstra();
       harderTest.runDijkstra();

       System.out.println(easyTest);
       System.out.println();
       System.out.println(harderTest);

    }
}
