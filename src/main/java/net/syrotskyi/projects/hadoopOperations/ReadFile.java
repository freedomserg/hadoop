package net.syrotskyi.projects.hadoopOperations;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;

public class ReadFile {

    public static void main(String[] args) throws IOException {
        Path file = new Path("/path/to/file.txt");

        FileSystem fs = FileSystem.get(new Configuration());
        InputStream input = null;
        try {
            input = fs.open(file);
            IOUtils.copyBytes(input, System.out, 4096);
        } finally {
            IOUtils.closeStream(input);
        }
    }

}
