public class GraphDemo {

    public static void main(String[] args) {
        Graph graph = new GraphImpl();

        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");

        graph.addEdge("A", "D", 1d);
        graph.addEdge("A", "E", 2d);
        graph.addEdge("A", "F", 3d);

        graph.addEdge("B", "C", 1d);
        graph.addEdge("B", "D", 10d);

        graph.addEdge("C", "E", 50d);
        graph.addEdge("C", "F", 3d);

        graph.addEdge("D", "B", 6d);

        System.out.println(graph);
        System.out.println();

        graph.dfs("A", System.out::print);
        System.out.println();
        graph.bfs("A", System.out::print);

    }


}
