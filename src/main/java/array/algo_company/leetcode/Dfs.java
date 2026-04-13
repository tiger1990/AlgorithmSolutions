package array.algo_company.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

//DFS Using Stack Iterative
public class Dfs {

    public static void main(String[] args) {
        Map<String, List<String>> graph = new HashMap<>();

        graph.put("A", new ArrayList<>(Arrays.asList("B", "C")));
        graph.put("B", new ArrayList<>(Arrays.asList("D", "E")));
        graph.put("C", new ArrayList<>(Arrays.asList("F")));
        graph.put("D", new ArrayList<>());
        graph.put("E", new ArrayList<>());
        graph.put("F", new ArrayList<>());

        dfs("A", graph);
    }

    /**
     *     A
     *    / \
     *   B   C
     *  / \   \
     * D   E   F
     * Vertices and Edges
     * Time	O(V + E)
     * Space	O(V)
     */
    private static void dfs(String start, Map<String, List<String>> graph) {
        Set<String> visited = new HashSet<>();
        Stack<String> stack = new Stack<>();

        stack.push(start);

        while (!stack.isEmpty()) {
            String node = stack.pop();

            if (!visited.contains(node)) {
                visited.add(node);


                List<String> neighbours = graph.get(node);
                // reverse to match recursive dfs order
                Collections.reverse(neighbours);

                for (String neighbour : neighbours) {
                    stack.push(neighbour);
                }
                // restore original order
                Collections.reverse(neighbours);
            }
        }
        for (String visit : visited) {
            System.out.print(visit);
        }
    }
}
