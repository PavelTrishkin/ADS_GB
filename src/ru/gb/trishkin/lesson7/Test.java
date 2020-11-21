package ru.gb.trishkin.lesson7;

public class Test {
    public static void main(String[] args) {
//        testGraph();
//        testBfs();
//        testDfs();

        testHomeWork();
    }

    private static void testGraph() {
        Graph graph = new Graph(4);
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");

        graph.addEdges("A", "B", "C");
        graph.addEdges("B", "A", "C", "D");
        graph.addEdges("C", "A", "B", "D");
        graph.addEdges("D", "B", "C");

        System.out.println("Size of graph is " + graph.getVertexSize());
        graph.display();
    }

    private static void testDfs() {
        Graph graph = new Graph(7);
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");
        graph.addVertex("G");

        graph.addEdges("A", "B", "C", "D");
        graph.addEdges("B", "E");
        graph.addEdges("D", "F");
        graph.addEdges("F", "G");

        graph.dfs("A");
        //A B E C D F G
    }


    private static void testBfs() {
        Graph graph = new Graph(8);
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");
        graph.addVertex("G");
        graph.addVertex("H");

        graph.addEdges("A", "B", "C", "D");
        graph.addEdges("B", "E");
        graph.addEdges("E", "H");
        graph.addEdges("C", "F");
        graph.addEdges("D", "G");

        graph.bfs("A");
    }

    private static void testHomeWork(){
        Graph graph = new Graph(10);
        graph.addVertex("Тула");
        graph.addVertex("Рязань");
        graph.addVertex("Калуга");
        graph.addVertex("Тамбов");
        graph.addVertex("Москва");
        graph.addVertex("Липецк");
        graph.addVertex("Орел");
        graph.addVertex("Саратов");
        graph.addVertex("Курск");
        graph.addVertex("Воронеж");

        graph.addEdges("Москва","Тула");
        graph.addEdges("Москва","Калуга");
        graph.addEdges("Москва","Рязань");
        graph.addEdges("Тула","Липецк");
        graph.addEdges("Рязань","Тамбов");
        graph.addEdges("Калуга","Орел");
        graph.addEdges("Липецк","Воронеж");
        graph.addEdges("Тамбов","Саратов");
        graph.addEdges("Орел","Курск");
        graph.addEdges("Саратов","Воронеж");
        graph.addEdges("Курск","Воронеж");

        graph.findShortWayWithBfs("Москва", "Воронеж");
    }
}
