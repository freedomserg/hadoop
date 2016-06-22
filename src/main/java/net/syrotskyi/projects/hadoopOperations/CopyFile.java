package net.syrotskyi.projects.hadoopOperations;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

import java.io.InputStream;

public class CopyFile {

    public static void main(String[] args) throws Exception {

        if (args.length < 2) {
            System.err.println("Bad arguments");
            return;
        }

        Path source_path = new Path(args[0]);
        Path target_path = new Path(args[1]);

        Configuration conf = new Configuration();
        FileSystem source_fs = FileSystem.get(source_path.toUri(), conf);
        FileSystem target_fs = FileSystem.get(target_path.toUri(), conf);

        FSDataOutputStream output = target_fs.create(target_path);
        InputStream input = null;
        try{
            input = source_fs.open(source_path);
            IOUtils.copyBytes(input, output, conf);
        } finally {
            IOUtils.closeStream(input);
            IOUtils.closeStream(output);
        }
    }

}
