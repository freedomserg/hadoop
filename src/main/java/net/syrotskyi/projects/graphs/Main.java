package net.syrotskyi.projects.graphs;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        DijkstraAlgorithm algorithm = new DijkstraAlgorithm();
        algorithm.findShortestPath();
    }
}
