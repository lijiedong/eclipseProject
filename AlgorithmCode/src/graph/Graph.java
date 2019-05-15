package graph;

import java.util.LinkedList;
import java.util.Queue;

/*
 *该算法实现图的结构定义，使用邻接表
 */
public class Graph {
	private static int numOfVexs;// 顶点的实际数量
	private static int maxNumOfVexs;// 顶点的最大数量
	private VNode[] vNodes;

	public int getNumOfVexs() {
		return numOfVexs;
	}

	public void setNumOfVexs(int numOfVexs) {
		this.numOfVexs = numOfVexs;
	}

	public int getMaxNumOfVexs() {
		return maxNumOfVexs;
	}

	public void setMaxNumOfVexs(int maxNumOfVexs) {
		this.maxNumOfVexs = maxNumOfVexs;
	}

	public VNode[] getvNodes() {
		return vNodes;
	}

	public void setvNodes(VNode[] vNodes) {
		this.vNodes = vNodes;
	}

	public Graph(int maxNumOfVexs) {
		super();
		this.maxNumOfVexs = maxNumOfVexs;
		vNodes = new VNode[maxNumOfVexs];
	}

	// 得到顶点的数目
	public int getNumOfVertex() {
		return numOfVexs;
	}

	// 插入顶点
	public boolean insertVex(int v) {
		if (numOfVexs >= maxNumOfVexs)
			return false;
		VNode vNode = new VNode();
		vNode.data = v;
		vNodes[numOfVexs++] = vNode;
		return true;
	}

	// 插入边

	public boolean insertEdge(int v1, int v2) {
		if (v1 < 0 || v2 < 0 || v1 > numOfVexs || v2 > numOfVexs) {
			return false;
		}
		ArcNode vex1 = new ArcNode(v2);
		// 先更新v1顶点的邻接表
		// 判断索引为v1的顶点有没有邻接顶点
		if (vNodes[v1].first == null) {
			vNodes[v1].first = vex1;
		} else {
			vex1.next = vNodes[v1].first;
			vNodes[v1].first = vex1;
		}
		// 再更新v2节点的邻接表
		ArcNode vex2 = new ArcNode(v1);
		// 判断索引为v2的顶点有没有邻接顶点
		if (vNodes[v2].first == null) {
			vNodes[v2].first = vex2;
		} else {
			vex1.next = vNodes[v2].first;
			vNodes[v2].first = vex1;
		}
		return true;
	}

	// 广度优先搜索
	public static void BFSTraverse(Graph G) {
		boolean[] visited = new boolean[maxNumOfVexs];// 访问标记数组
		for (int i = 0; i < numOfVexs; i++) {
			visited[i] = false;
		}
		for (int i = 0; i < numOfVexs; i++) {
			if (!visited[i]) { // 这个判断是为了保证对每个连通分量只调用一次
				BFS(G, i, visited);
			}

		}
	}

	public static void BFS(Graph G, int v, boolean[] visited) {
		visit(G.getvNodes()[v].data);
		visited[v] = true;
		Queue<Integer> queues = new LinkedList<>();// 创建一个队列
		queues.add(v); // 顶点v入队列
		while (!queues.isEmpty()) {
			int vertex = queues.poll(); // 顶点vertex出列
			ArcNode arcNode = G.getvNodes()[vertex].first;
			while (arcNode != null) {
				if (!visited[arcNode.adjvex]) {
					visit(G.getvNodes()[arcNode.adjvex].data);
					visited[arcNode.adjvex] = true;
					queues.add(arcNode.adjvex);
				}
				arcNode = arcNode.next; // 访问下一个邻接节点
			}
		}
	}

	// 深度优先搜索，需要借助栈
	public void DFSTraverse(Graph G) {
		boolean[] visited = new boolean[maxNumOfVexs];// 访问标记数组
		for (int i = 0; i < numOfVexs; i++) {
			visited[i] = false;
		}
		for (int i = 0; i < numOfVexs; i++) {
			if (!visited[i]) { // 这个判断是为了保证对每个连通分量只调用一次
				DFS(G, i, visited);
			}

		}
	}

	public void DFS(Graph G, int v, boolean[] visited) {
		visit(G.getvNodes()[v].data);
		visited[v] = true;
		ArcNode arcNode = G.getvNodes()[v].first;
		while (arcNode != null) {
			if (!visited[arcNode.adjvex]) {
				DFS(G, arcNode.adjvex, visited);
			}
			arcNode = arcNode.next;
		}

	}

	public static void visit(int v) {
		System.out.print(v + "--");
	}
}

class ArcNode { // 边表节点
	int adjvex; // 该弧所指向的顶点在顶点表所对应的数组中的位置
	ArcNode next;

	public ArcNode(int adjvex) {
		super();
		this.adjvex = adjvex;
	}

}

class VNode { // 顶点表节点
	int data;
	ArcNode first;
}
