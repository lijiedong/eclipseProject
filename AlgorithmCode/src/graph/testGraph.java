package graph;

public class testGraph {
	public static void main(String[] args) {
		Graph graph = new Graph(20);
		for (int i = 0; i < 10; i++) {
			graph.insertVex(i + 10);
		}
		// 添加边
		graph.insertEdge(0, 1);
		graph.insertEdge(0, 2);
		graph.insertEdge(1, 3);
		graph.insertEdge(1, 4);
		graph.insertEdge(2, 5);
		graph.insertEdge(2, 6);
		graph.insertEdge(3, 7);
		graph.insertEdge(3, 8);
		graph.insertEdge(4, 9);
		// Graph.BFSTraverse(graph);
		graph.DFSTraverse(graph);
	}
}
