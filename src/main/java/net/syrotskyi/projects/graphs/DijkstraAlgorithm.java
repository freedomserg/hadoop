package net.syrotskyi.projects.graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DijkstraAlgorithm {

    public void findShortestPath() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String nodesEdges = reader.readLine();
        int nodesNumber = Integer.valueOf(nodesEdges.split(" ")[0]);
        int edgesNumber = Integer.valueOf(nodesEdges.split(" ")[1]);
        int initNode = 0;
        int targetNode = 0;
        int infinity = Integer.MAX_VALUE - 1;

        ArrayList<Integer> []adjacencyList = new ArrayList[nodesNumber];
        for (int i = 0; i < adjacencyList.length; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        ArrayList<Integer> []weightList = new ArrayList[nodesNumber];
        for (int i = 0; i < weightList.length; i++) {
            weightList[i] = new ArrayList<>();
        }

        boolean[] used = new boolean[nodesNumber];
        int[] distances = new int[nodesNumber];

        Arrays.fill(used, false);
        Arrays.fill(distances, infinity);

        String input = reader.readLine();
        while (input != null && !"".equals(input)) {
            String[] edgesData = input.split(" ");
            if (edgesData.length < 3) {
                initNode = Integer.valueOf(input.split(" ")[0]) - 1;
                targetNode = Integer.valueOf(input.split(" ")[1]) - 1;
                break;
            }

            int startNode = Integer.valueOf(input.split(" ")[0]);
            int endNode = Integer.valueOf(input.split(" ")[1]);
            int weightEdge = Integer.valueOf(input.split(" ")[2]);

            adjacencyList[startNode - 1].add(endNode - 1);
            weightList[startNode - 1].add(weightEdge);

            input = reader.readLine();
        }

        distances[initNode] = 0;

        for (int i = 0; i < nodesNumber; i++) {
            int node = -1;
            int distFromNodeToTarget = infinity - 1;

            for (int j = 0; j < nodesNumber; j++) {
                if (used[j]) {
                    continue;
                }
                if (distFromNodeToTarget < distances[j]) {
                    continue;
                }
                node = j;
                distFromNodeToTarget = distances[j];
            }

            if (node == -1) {
                continue;
            }

            for (int j = 0; j < adjacencyList[node].size(); j++) {
                int target = adjacencyList[node].get(j);
                int weightToTarget = weightList[node].get(j);
                if (distances[node] + weightToTarget < distances[target]) {
                    distances[target] = distances[node] + weightToTarget;
                }
            }
            used[node] = true;
        }

        if (distances[targetNode] == infinity) {
            System.out.println(-1);
        } else {
            System.out.println(distances[targetNode]);
        }
    }
}
