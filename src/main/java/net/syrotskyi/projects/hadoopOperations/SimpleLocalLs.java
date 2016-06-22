package net.syrotskyi.projects.hadoopOperations;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.IOException;

public class SimpleLocalLs
{
    public static void main( String[] args ) throws IOException {
        Path path = new Path("/");
        if (args.length == 1) {
            path = new Path(args[0]);
        }

        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(conf);

        FileStatus[] files = fs.listStatus(path);
        for (FileStatus file : files) {
            System.out.println(file.getPath().getName());
        }


    }
}
