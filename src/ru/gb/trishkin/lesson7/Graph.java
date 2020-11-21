package ru.gb.trishkin.lesson7;

import java.util.*;

public class Graph {
    private final List<Vertex> vertexList;
    private final boolean[][] adjMat;

    public Graph(int maxVertexCount) {
        this.vertexList = new ArrayList<>(maxVertexCount);
        this.adjMat = new boolean[maxVertexCount][maxVertexCount];
    }

    public void addVertex(String label){
        vertexList.add(new Vertex(label));
    }

    public void addEdges(String startLabel, String endLabel){
        int startIndex = indexOf(startLabel);
        int endIndex = indexOf(endLabel);

        if (startIndex == -1 || endIndex == -1){
            throw new IllegalArgumentException("Invalid label for vertex");
        }

        adjMat[startIndex][endIndex] = true;
        adjMat[endIndex][startIndex] = true;

    }

    public void addEdges(String startLabel, String secondLabel, String... others){
        addEdges(startLabel, secondLabel);
        for (String other : others) {
            addEdges(startLabel, other);
        }
    }

    private int indexOf(String vertexLabel) {
        for (int i = 0; i < vertexList.size(); i++) {
            if (vertexLabel.equals(vertexList.get(i).getLabel())){
                return i;
            }
        }
        return  -1;
    }

    public int getVertexSize(){
        return vertexList.size();
    }

    public void display() {
        for (int i = 0; i < getVertexSize(); i++) {
            System.out.print(vertexList.get(i));
            for (int j = 0; j < getVertexSize(); j++) {
                if (adjMat[i][j]) {
                    System.out.print(" -> " + vertexList.get(j));
                }
            }
            System.out.println();
        }
    }

    /**
     * англ. Depth-first search, DFS
     *
     * @param startLabel
     */
    public void dfs(String startLabel){
        int startIndex = indexOf(startLabel);

        if (startIndex == -1){
            throw new IllegalArgumentException("Invalid start label for vertex");
        }

        Stack<Vertex> vertexStack = new Stack<>();

        Vertex vertex = vertexList.get(startIndex);
        visitVertex(vertex, vertexStack);
        while (!vertexStack.empty()){
            vertex = getUnvisitedVertex(vertexStack.peek());
            if (vertex != null){
                visitVertex(vertex, vertexStack);
            }
            else {
                vertexStack.pop();
            }
        }
        resetVertexState();
    }

    /**
     * англ. breadth-first search, BFS
     *
     * @param startLabel
     */
    public void bfs(String startLabel){
        int startIndex = indexOf(startLabel);

        if (startIndex == -1){
            throw new IllegalArgumentException("Invalid start label for vertex");
        }

        Queue<Vertex> vertexQueue = new LinkedList<>();

        Vertex vertex = vertexList.get(startIndex);
        visitVertex(vertex, vertexQueue);
        while (!vertexQueue.isEmpty()){
            vertex = getUnvisitedVertex(vertexQueue.peek());
            if (vertex != null){
                visitVertex(vertex, vertexQueue);
            }
            else {
                vertexQueue.remove();
            }
        }
        resetVertexState();
    }

    private void resetVertexState() {
        for (Vertex vertex: vertexList) {
            vertex.setVisited(false);
        }
    }

    private void visitVertex(Vertex vertex, Stack<Vertex> vertexStack) {
        System.out.println(vertex);
        vertexStack.push(vertex);
        vertex.setVisited(true);
    }

    private void visitVertex(Vertex vertex, Queue<Vertex> vertexQueue) {
        System.out.println(vertex);
        vertexQueue.add(vertex);
        vertex.setVisited(true);
    }

    private Vertex getUnvisitedVertex(Vertex peek) {
        int peekIndex = vertexList.indexOf(peek);

        for (int i = 0; i < getVertexSize(); i++) {
            if(adjMat[peekIndex][i] && !vertexList.get(i).isVisited()){
                return vertexList.get(i);
            }
        }

        return null;
    }

    public Stack<String> findShortWayWithBfs(String startLabel, String finishLabel){
        int startIndex = indexOf(startLabel);
        int finishIndex = indexOf(finishLabel);

        if(startIndex == -1 || finishIndex == -1){
            throw new IllegalArgumentException("Invalid label for vertex");
        }

        Queue<Vertex> queue = new ArrayDeque<>();
        Vertex vertex = vertexList.get(startIndex);
        visitVertex(vertex, queue);

        while (!queue.isEmpty()){
            vertex = getUnvisitedVertex(vertex);
            if (vertex == null){
                queue.remove();
            }
            else {
                visitVertex(vertex, queue);
                vertex.setPreviousVertex(queue.peek());
                if (vertex.equals(vertexList.get(finishIndex))){
                    return buildPath(vertex);
                }
            }
        }
        resetVertexState();
        return null;
    }

    private Stack<String> buildPath(Vertex vertex) {
        Stack<String> pathStacks = new Stack<>();
        Vertex current = vertex;

        while (current != null){
            pathStacks.push(current.getLabel());
            current = current.getPreviousVertex();
        }

        return pathStacks;
    }
}
