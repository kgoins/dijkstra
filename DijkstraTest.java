public class DijkstraTest {
    public static void main(String[] args) {
        GraphBuilder builder = new GraphBuilder();
        Graph test = builder.build("test.graphfile");

        System.out.println(test);
    }
}
