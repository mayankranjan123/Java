package graph;

import java.util.*;

class Node {
    int data;
    boolean visited;
    List<Node> neighbours;

    public Node(int data) {
        this.data = data;
        this.neighbours = new ArrayList<>();
    }

    public void addNeighbour(Node node) {
        this.neighbours.add(node);
    }

    public List<Node> getNeighbours() {
        return neighbours;
    }

    public void setNeighbours(List<Node> neighbours) {
        this.neighbours = neighbours;
    }
}


public class Graph {
    Stack<Node> stacks = new Stack<Node>();
    public static void main(String[] args) {
        List<Integer> l1 = new ArrayList<>();

        Node node1 =new Node(1);
        Node node2 =new Node(2);
        Node node3 =new Node(3);
        Node node4 =new Node(4);
        Node node5 =new Node(5);
        node1.addNeighbour(node2);
        node1.addNeighbour(node3);
        node2.addNeighbour(node3);
        node2.addNeighbour(node4);
        node3.addNeighbour(node4);
        node3.addNeighbour(node5);


//        Node node40 =new Node(40);
//        Node node10 =new Node(10);
//        Node node20 =new Node(20);
//        Node node30 =new Node(30);
//        Node node60 =new Node(60);
//        Node node50 =new Node(50);
//        Node node70 =new Node(70);
//
//        node40.addNeighbour(node10);
//        node40.addNeighbour(node20);
//        node10.addNeighbour(node30);
//        node20.addNeighbour(node10);
//        node20.addNeighbour(node30);
//        node20.addNeighbour(node60);
//        node20.addNeighbour(node50);
//        node30.addNeighbour(node60);
//        node60.addNeighbour(node70);
//        node50.addNeighbour(node70);

        System.out.println("Working");
        Graph graph = new Graph();
         //graph.dfs(node1);
       //  graph.bfs(node1);
        Stack<Node> node = new Stack<>();
        graph.topologicalSort(node1);
        while (graph.stacks.empty()==false)
            System.out.print(graph.stacks.pop().data + " ");
        // graph.bfs(node40);
    }

    public  void topologicalSort(Node node)
    {
        List<Node> neighbours=node.getNeighbours();
        for (int i = 0; i < neighbours.size(); i++) {
            Node n=neighbours.get(i);
            if(n!=null && !n.visited)
            {
                topologicalSort(n);
                n.visited=true;
            }
        }
        stacks.push(node);
    }

    private void bfs(Node node) {
        Queue<Node> queue = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getValue());
        }

        queue.add(node);
        while (!queue.isEmpty()) {
            Node element = queue.remove();
            if (Objects.nonNull(element) && !element.visited) {
                System.out.println(element.data + " ");
                element.visited = true;
            }
            List<Node> neighbours = element.getNeighbours();
            for (int i = 0; i < neighbours.size(); i++) {
                Node n = neighbours.get(i);
                if (Objects.nonNull(n) && !n.visited) {
                    queue.add(n);
                }
            }
        }
    }

    private void dfs(Node node) {
        Stack<Node> stack = new Stack<Node>();
        stack.add(node);
        while (!stack.isEmpty()) {
            Node element = stack.pop();
            if (!element.visited) {
                System.out.println(element.data + " ");
                element.visited = true;
            }
            List<Node> neighbours = element.getNeighbours();
            for (int i = 0; i< neighbours.size(); i++) {
                Node n = neighbours.get(i);
                if (Objects.nonNull(n) && !n.visited) {
                    stack.add(n);
                }
            }
        }
    }
}
