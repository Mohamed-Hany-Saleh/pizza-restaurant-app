/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package online.pizza;
import java.util.ArrayList;
import java.util.PriorityQueue;
import static online.pizza.OrderMenu.jComboBox1;

/**
 *
 * @author 20128
 */
public class Dijkstra {
   
    static class ListNode {
        int vertex, weight;
        ListNode(int v, int w) {
            vertex = v;
            weight = w;
        }
        int getVertex() {
            return vertex;
        }
        int getWeight() {
            return weight;
        }
    }

    public static int[] dijkstra( ArrayList<ArrayList<ListNode>> graph) {
        int V = 9;
        int src=0;
        int[] distance = new int[V];
        for (int i = 0; i < V; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        distance[src] = 0;
        //O(n)
        PriorityQueue<ListNode> pq = new PriorityQueue<>((v1, v2) -> v1.getWeight() - v2.getWeight());
        pq.add(new ListNode(src, 0));

        while (pq.size() > 0) {
            ListNode current = pq.poll();
            for (ListNode n : graph.get(current.getVertex())) {
                if (distance[current.getVertex()] + n.getWeight() < distance[n.getVertex()]) {
                    distance[n.getVertex()] = n.getWeight() + distance[current.getVertex()];
                    pq.add(new ListNode(n.getVertex(),distance[n.getVertex()]));
                }
            }
        }
        return distance;
    }
    public static int Distance(){
        int v= jComboBox1.getSelectedIndex();
        ArrayList<ArrayList<ListNode>> graph = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            graph.add(new ArrayList<>());
        }
        int source = 0;
        //from graph.get(0),to ListNode(1, 2)->(vertex,distance)
        //O(VElogV)
        graph.get(0).add(new ListNode(1, 2));
        graph.get(0).add(new ListNode(7, 4));
        graph.get(1).add(new ListNode(2, 1));
        graph.get(1).add(new ListNode(7, 2));
        graph.get(1).add(new ListNode(0, 2));
        graph.get(2).add(new ListNode(1, 1));
        graph.get(2).add(new ListNode(3, 1));
        graph.get(2).add(new ListNode(8, 4));
        graph.get(2).add(new ListNode(5, 7));
        graph.get(3).add(new ListNode(2, 1));
        graph.get(3).add(new ListNode(4, 2));
        graph.get(3).add(new ListNode(5, 6));
        graph.get(4).add(new ListNode(3, 2));
        graph.get(4).add(new ListNode(5, 6));
        graph.get(5).add(new ListNode(4, 6));
        graph.get(5).add(new ListNode(6, 3));
        graph.get(6).add(new ListNode(5, 3));
        graph.get(6).add(new ListNode(7, 3));
        graph.get(6).add(new ListNode(8, 4));
        graph.get(7).add(new ListNode(0, 4));
        graph.get(7).add(new ListNode(1, 2));
        graph.get(7).add(new ListNode(6, 3));
        graph.get(7).add(new ListNode(8, 1));
        graph.get(8).add(new ListNode(2, 4));
        graph.get(8).add(new ListNode(6, 4));
        graph.get(8).add(new ListNode(7, 1));

        int[] distance = dijkstra(graph);
        return distance[v];
    }
    
}
