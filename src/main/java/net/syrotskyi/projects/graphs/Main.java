package net.syrotskyi.projects.graphs;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
//        Mapper mapper = new Mapper();
//        mapper.map();

        Reducer reducer = new Reducer();
        reducer.reduce();
    }
}
