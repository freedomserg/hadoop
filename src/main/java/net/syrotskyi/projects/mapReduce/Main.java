package net.syrotskyi.projects.mapReduce;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Mapper mapper = new Mapper();
        Reducer reducer = new Reducer();
        Combiner combiner = new Combiner();

        combiner.combine();
    }
}
