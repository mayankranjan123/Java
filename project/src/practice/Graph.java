package practice;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

class Node {
    int data;
    boolean visited;
    List<Node> neighbours;

    public Node(int data, boolean visited, List<Node> neighbours) {
        this.data = data;
        this.visited = visited;
        this.neighbours = neighbours;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public List<Node> getNeighbours() {
        return neighbours;
    }

    public void setNeighbours(List<Node> neighbours) {
        this.neighbours = neighbours;
    }

    public Node(int data) {
        this.data = data;
        this.neighbours = new ArrayList<>();
    }

    public void addNeighbour(Node node) {
        this.neighbours.add(node);
    }
}

public class Graph {

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        node1.addNeighbour(node2);
        node1.addNeighbour(node3);
        node2.addNeighbour(node3);
        node2.addNeighbour(node4);
        node3.addNeighbour(node4);
        node3.addNeighbour(node5);
        System.out.println(node1);
        Graph graph = new Graph();
        graph.dfs(node1);

    }

    private void dfs(Node node) {
        Stack<Node> stack = new Stack<>();
        if (node == null)
            return;
        stack.push(node);
        while (!stack.isEmpty()) {
            Node temp = stack.pop();
            if (Objects.nonNull(temp) && !temp.visited) {
                System.out.println(temp.data);
                temp.visited = true;
            }

            if (temp.getNeighbours().size() > 0) {
                for (int i = 0; i < temp.getNeighbours().size(); i++) {
                    Node neighbourNode = temp.getNeighbours().get(i);
                    if (Objects.nonNull(neighbourNode) && !neighbourNode.visited) {
                        stack.push(neighbourNode);
                    }
                }
            }
        }
    }
}
