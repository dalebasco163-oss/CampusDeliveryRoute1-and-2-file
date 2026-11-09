
import java.util.Scanner;

public class CampusRouteOptimizer {

public static void main(String[] args) {
    
WeightedGraph graph = new WeightedGraph();
 

graph.addEdge("A", "B", 4);
graph.addEdge("A", "C", 2);
graph.addEdge("B", "D", 5);
graph.addEdge("C", "D", 8);
graph.addEdge("D", "E", 2); 
graph.addEdge("B", "E", 7);

        System.out.println("CAMPUS COURIER ROUTE OPTIMIZER");

        System.out.println("\nLocations:");
        System.out.println("A - Main Gate");
        System.out.println("B - Registrar");
        System.out.println("C - Library");
        System.out.println("D - Laboratory");
        System.out.println("E - Faculty Room");
        
graph.displayGraph();

Scanner scanner = new Scanner(System.in);

        System.out.print("\nEnter source vertex: ");
        String source = scanner.nextLine().trim().toUpperCase();

        System.out.print("Enter destination vertex: ");
        String destination = scanner.nextLine().trim().toUpperCase();

        graph.dijkstra(source, destination);

scanner.close();
}
}
