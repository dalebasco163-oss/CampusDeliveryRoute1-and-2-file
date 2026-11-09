import java.util.*;

public class WeightedGraph {

static class Edge {
String destination;
int weight;

Edge(String d, int w) {
destination = d;
weight = w;
 }
}

Map<String, List<Edge>> graph = new HashMap<>();

public void addEdge(String s, String d, int w) {
graph.putIfAbsent(s, new ArrayList<>());
graph.putIfAbsent(d, new ArrayList<>());
graph.get(s).add(new Edge(d, w));
graph.get(d).add(new Edge(s, w));
}

public void displayGraph() {
graph.forEach((v, edges) -> {
System.out.print(v + " -> ");
edges.forEach(e -> System.out.print(e.destination + "(" + e.weight + ") "));
System.out.println();
});
}

    public void dijkstra(String start, String end) {
        Map<String, Integer> dist = new HashMap<>();
        Map<String, String> prev = new HashMap<>();
        Set<String> visited = new LinkedHashSet<>();

        if (!graph.containsKey(start) || !graph.containsKey(end)) {
            System.out.println("Invalid vertex.");
            return;
        }

        graph.keySet().forEach(v -> dist.put(v, Integer.MAX_VALUE));
        dist.put(start, 0);

        PriorityQueue<String> pq = new PriorityQueue<>(
            Comparator.comparingInt(dist::get));
        pq.add(start);

        while (!pq.isEmpty()) {
            String u = pq.poll();
            if (!visited.add(u)) continue;
            if (u.equals(end)) break;

      for (Edge e : graph.get(u)) {    
      int newDist = dist.get(u) + e.weight;
      if (newDist < dist.get(e.destination)) {
      dist.put(e.destination, newDist);
      prev.put(e.destination, u);
      pq.add(e.destination);
  }
  }
  }

System.out.println("Visited Vertices: " + String.join(" -> ", visited));

if (dist.get(end) == Integer.MAX_VALUE) {
System.out.println("No path found.");
return;
        }

List<String> path = new ArrayList<>();
for (String v = end; v != null; v = prev.get(v))
path.add(v);

Collections.reverse(path);
System.out.println("Shortest Path: " + String.join(" -> ", path));
System.out.println("Total Distance: " + dist.get(end) + " meters");
    }
}
