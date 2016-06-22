package net.syrotskyi.projects.distinctValues;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Mapper mapper = new Mapper();
        Reducer reducer = new Reducer();
        reducer.reducePhase2();
    }
}
